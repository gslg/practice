package com.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FillLists {

	public static void main(String[] args) {
		List<StringAddrss> list = new ArrayList<StringAddrss>(Collections.nCopies(2, 
				new StringAddrss("hello")));
		
		System.out.println(list);
		Collections.fill(list, new StringAddrss("world"));
		System.out.println(list);

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
