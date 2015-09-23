package com.test.cachemap.version2;

public interface Cache<K,V> {
	/**
	 * 返回当前缓存的大小
	 * @return
	 */
	int size();
	/**
	 * 缓存的默认存活时间
	 * @return
	 */
	long getDefaultExpire();
	/**
	 * 放入缓存对象，其存在的缓存时间为默认值
	 * @param key
	 * @param value
	 */
	void put(K key,V value);
	/**
	 * 放入缓存对象，其存在的缓存时间为指定的值
	 * @param key
	 * @param value
	 * @param expire 
	 */
	void put(K key,V value,long expire);
	/**
	 * 查找缓存对象
	 * @param key
	 * @return
	 */
	V get(K key);
	/**
     * 淘汰对象
     * @return  被删除对象大小
     */
    int eliminate();
    /**
     * 判断缓存是否已满
     * @return
     */
    boolean isFull();
    /**
     * 清除所有缓存对象
     */
    void clear();
    /**
     * 返回缓存的大小
     * @return
     */
    int getCacheSize();
    /**
     * 缓存是否为空
     * @return
     */
    boolean isEmpty();
	
}
