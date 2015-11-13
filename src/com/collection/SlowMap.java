package com.collection;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap<K,V> extends AbstractMap<K, V> {
	
	private List<K> keys = new ArrayList<K>();
	private List<V> values = new ArrayList<V>();
	
	public V put(K key,V val){
		V oldValue = get(key);
		if(!keys.contains(key)){
			//如果keys中不包含key,则添加
			keys.add(key);
			values.add(val);
		}else{
			//如果keys中已包含key,替换values
			values.set(keys.indexOf(key), val);
		}
		return oldValue;
	}
	
	public V get(Object key){//注意此处key为type object,而不是K
		if(keys.contains(key)){
			return values.get(keys.indexOf(key));
		}
		return null;
	}
	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		
		Iterator<K> ki = keys.iterator();
		Iterator<V> vi = values.iterator();
		while(ki.hasNext()){
			set.add(new MapEntry<K,V>(ki.next(),vi.next()));
		}
		return null;
	}

	public static void main(String[] args) {

	}
}
