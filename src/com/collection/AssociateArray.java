package com.collection;
/**
 * 模仿简单的map
 * @author lg
 *
 */
public class AssociateArray<K,V> {
	private Object[][] pairs;
	private int index;
	
	public AssociateArray(int length){
		pairs = new Object[length][2];
	}
	
	public void put(K k,V v){
		if(index >= pairs.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		pairs[index++] =new Object[]{k,v};
	}
	
	@SuppressWarnings("unchecked")
	public V get(K k){
		for(int i=0;i<index;i++){
			if(k.equals(pairs[i][0])){
				return (V) pairs[i][1];
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<index;i++){
			sb.append(pairs[i][0].toString());
			sb.append(":");
			sb.append(pairs[i][1].toString());
			if(i<index-1)
				sb.append("\n");
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		AssociateArray<String,String> map = new AssociateArray<String,String>(6);
		
		map.put("sky", "blue");
		map.put("grass", "green");
		map.put("ocean", "dancing");
		map.put("tree", "tall");
		map.put("earth", "brawn");
		map.put("sun", "warm");
		try {
			map.put("tree", "tall");
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println(map);
		
		System.out.println(map.get("sun"));
	}

}
