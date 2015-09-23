package com.test.cachemap;

import java.util.Iterator;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
//		LRULinkedHashMap<Integer,String> cachemap = new LRULinkedHashMap<Integer,String>(4);
//		
//		cachemap.put(1, "aa");
//		cachemap.put(2, "bb");
//		cachemap.put(3, "cc");
//		cachemap.put(4, "dd");
//		cachemap.put(5, "ee");
//		cachemap.put(6, "ff");
//		cachemap.get(3);
//		
//		for(Iterator<Map.Entry<Integer,String>> it=cachemap.entrySet().iterator();it.hasNext();){
//			System.out.println(it.next().getKey());
//		}
		
        System.out.println(CacheManager.getSimpleFlag("alksd")); 
      CacheManager.putCache("abc", new Cache()); 
      CacheManager.putCache("def", new Cache()); 
      CacheManager.clearOnly(""); 
      Cache c = new Cache(); 
      for (int i = 0; i < 10; i++) { 
          CacheManager.putCache("" + i, c); 
      } 
      CacheManager.putCache("aaaaaaaa", c); 
      CacheManager.putCache("abchcy;alskd", c); 
      CacheManager.putCache("cccccccc", c); 
      CacheManager.putCache("abcoqiwhcy", c); 
      System.out.println("删除前的大小："+CacheManager.getCacheSize()); 
      CacheManager.getCacheAllkey(); 
      CacheManager.clearAll("aaaa"); 
      System.out.println("删除后的大小："+CacheManager.getCacheSize()); 
      CacheManager.getCacheAllkey(); 

	}
}
