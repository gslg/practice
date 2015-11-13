package com.collection;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
/**
 * 自定义简单的hashmap
 * @author sobey
 *
 * @param <K>
 * @param <V>
 */
public class SimpleHashMap<K,V> extends AbstractMap<K, V> {
	static final int SIZE=997;
	
	@SuppressWarnings("unchecked")
	LinkedList<MapEntry<K,V>>[] buckets = new LinkedList[SIZE];
	
	public V put(K key,V value){
		V oldValue = null;
		//计算下标
		int index = Math.abs(key.hashCode()) % SIZE;
		//创建链表
		if(buckets[index] == null){
			buckets[index] = new LinkedList<MapEntry<K,V>>();
		}
		//获取当前小标的链表
		LinkedList<MapEntry<K,V>> bucket = buckets[index];
		//将要保存的键值对存入MapEntry
		MapEntry<K,V> pair = new MapEntry<K, V>(key, value);
		//定义是否找到
		boolean found = false;
		//遍历当前链表
		ListIterator<MapEntry<K,V>> it = bucket.listIterator();
		
		while(it.hasNext()){
			//获取MapEntry
			MapEntry<K,V> ipair = it.next();
			
			if(ipair.getKey().equals(key)){
				oldValue = ipair.getValue();
				it.set(pair);
				found = true;
				break;
			}
 		}
		if(!found){
			bucket.add(pair);
		}
		return oldValue;
	}
	public V get(Object key){
		int index = Math.abs(key.hashCode()) % SIZE;
		
		if(buckets[index]==null) return null;
		
		for(MapEntry<K,V> me : buckets[index]){
			if(me.getKey().equals(key)){
				return me.getValue();
			}
		}
		return null;
	}
	
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K,V>>();
		for(LinkedList<MapEntry<K,V>> bucket : buckets){
			if(bucket==null) continue;
			
			for(MapEntry<K, V> ipair : bucket){
				set.add(ipair);
			}
		}
		return set;
	}

	public static void main(String[] args){
		SimpleHashMap<String,String> sh = new SimpleHashMap<String,String>();
		
		sh.put("1","1");
		sh.put("lg","liuguo");
		sh.put("ly","liyang");
		sh.put("lb","luobin");
		sh.put("cjx","caijianxiong");
		sh.put("hy","huyang");
		
		System.out.println(sh);
		System.out.println(sh.get("lg"));
		System.out.println(sh.entrySet());
	}
}
