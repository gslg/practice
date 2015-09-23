package com.collection;

import java.util.LinkedHashSet;
import java.util.Set;

import com.generic.Generator;

public class CollectionDataTest {

	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<String>(
				new CollectionData(new Goverment(),10));
		
		System.out.println(set);
		
		set.addAll(CollectionData.list(new Goverment(), 10));
		System.out.println(set);
	}

}
class Goverment implements Generator<String>{

	String[] foundation="a b c d e f g h i j k".split(" ");
	private  int index;
	@Override
	public String next() {
		return foundation[index++];
	}
	
}