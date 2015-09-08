package com.thinkinginjava.clazz;

import java.util.ArrayList;
import java.util.List;

public class FilledList<T> {
	private Class<T> type;
	public FilledList(Class<T> type){
		this.type = type;
	}
	
	public List<T> create(int nElements) throws Exception{
		List<T> list = new ArrayList<T>();
		for(int i=0;i<nElements;i++){
			list.add(type.newInstance());
		}
		
		return list;
	}
	
	public static void main(String[] args) throws Exception {
		FilledList<CountedInteger> fl = new FilledList<CountedInteger>(CountedInteger.class);
		System.out.println(fl.create(10));
	}
}
class CountedInteger{
	private static long counter;
	private long id = counter++;
	public String toString(){
		return Long.toString(id);
	}
}
