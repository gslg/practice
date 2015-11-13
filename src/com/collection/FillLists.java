package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillLists {

	public static void main(String[] args) {
//		List<StringAddrss> list = new ArrayList<StringAddrss>(Collections.nCopies(2, 
//				new StringAddrss("hello")));
//		
//		System.out.println(list);
//		Collections.fill(list, new StringAddrss("world"));
//		System.out.println(list);
		List<String> list = new ArrayList<String>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		//list.add(7, "b");
		//System.out.println(list);
		//List<String> sublist=list.subList(2, 4);
		//System.out.println("sublist:"+sublist);
//		System.out.println("list:"+list);
//		list.subList(2, 4).clear();
//		System.out.println("list:"+list);
		//String[] arr = new String[10];
//		String[] arr = new String[4];
//		arr = list.toArray(arr);
//		for(String s : arr){
//			System.out.println(s);
//		}
		
		System.out.println(list.subList(2, 5).indexOf("5"));
	}

}
class StringAddrss{
	private String s;
	public StringAddrss(String s){
		this.s = s;
	}
	@Override
	public String toString() {
		return super.toString()+" "+s;
	}
}
