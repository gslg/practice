package com.thinkinginjava.string;

import java.util.ArrayList;
import java.util.List;

public class InfinitRecursion {

	public String toString(){
		return "InfinitRecursion Address:"+super.toString()+"\n";
	}
	public static void main(String[] args) {
		List<InfinitRecursion> cl = new ArrayList<InfinitRecursion>();
		
		for(int i=0;i<10;i++){
			cl.add(new InfinitRecursion());
		}
		
		System.out.println(cl);
		
	}

}
