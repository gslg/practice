package com.test.cachemap.version2;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public abstract class AbstractCacheMap<K,V> implements Cache<K, V> {

	class CacheObject<K2,V2>{
		final K2 key;
		final V2 cachedObject;
		/**
		 * 最后一次访问的时间
		 */
		long lastAccess;
		/**
		 * 访问的次数
		 */
		long accessCount;
		/**
		 * 对象存活的时间（time-to-live）
		 */
		long ttl;
		
		CacheObject(K2 key,V2 value,long ttl){
			this.key = key;
			this.cachedObject = value;
			this.ttl = ttl;
		}
		/**
		 * 判断对象是否存活
		 * @return
		 */
		boolean isExpired(){
			if(ttl==0){
				return false;
			}
			return lastAccess+ttl < System.currentTimeMillis();
		}
		/**
		 * 获取缓存的对象
		 * @return
		 */
		V2 getObject(){
			lastAccess = System.currentTimeMillis(); // 更新最后访问时间
			accessCount++;//更新访问次数
			return cachedObject;
		}
	}
	
	protected Map<K,CacheObject<K,V>> cacheMap;
	 
    private final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private final Lock readLock = cacheLock.readLock();
    private final Lock writeLock = cacheLock.writeLock();
    protected int cacheSize;      // 缓存大小 , 0 -> 无限制
    protected  boolean existCustomExpire ; //是否设置默认过期时间
	protected long defaultExpire;//默认过期时间
	/**
	 * @param cacheSize 缓存的大小
	 * @param defaultExpire 默认过期时间
	 */
    public AbstractCacheMap(int cacheSize ,long defaultExpire){
        this.cacheSize  = cacheSize ;
        this.defaultExpire  = defaultExpire ;
    }
    
    protected boolean isNeedClearExpiredObject(){
        return defaultExpire > 0 || existCustomExpire ;
    }
    
    @Override
	public int size() {
		return cacheMap.size();
	}

	@Override
	public long getDefaultExpire() {
		return defaultExpire;
	}

	@Override
	public void put(K key, V value) {
		put(key,value,defaultExpire);
	}

	@Override
	public void put(K key, V value, long expire) {
		writeLock.lock();
		try {
            CacheObject<K,V> co = new CacheObject<K,V>(key, value, expire);
            if (expire != 0) {
            	//存在默认时间
                existCustomExpire = true;
            }
            if (isFull()) {
            	//缓存已满，需要清除
                eliminate() ;
            }
            cacheMap.put(key, co);
        }
        finally {
            writeLock.unlock();
        }
	}

	@Override
	public V get(K key) {
		 readLock.lock();
	        try {
	            CacheObject<K,V> co = cacheMap.get(key);
	            if (co == null) {
	                return null;
	            }
	            if (co.isExpired() == true) {
	                cacheMap.remove(key);
	                return null;
	            }
	 
	            return co.getObject();
	        }
	        finally {
	            readLock.unlock();
	        }
	}

	@Override
	public int eliminate() {
		writeLock.lock();
        try {
            return eliminateCache();
        }
        finally {
            writeLock.unlock();
        }
	}
	protected abstract int eliminateCache();

	@Override
	public boolean isFull() {
		if (cacheSize == 0) {//o -> 无限制
            return false;
        }
        return cacheMap.size() >= cacheSize;
	}

	@Override
	public void clear() {
		writeLock.lock();
        try {
            cacheMap.clear();
        }
        finally {
            writeLock.unlock();
        }
		
	}

	@Override
	public int getCacheSize() {
		return cacheSize;
	}

	@Override
	public boolean isEmpty() {
		return size()==0;
	}

}
