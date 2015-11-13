package com.collection;

import java.util.Arrays;
import java.util.Collection;

public class Unsuported {

	public static void main(String[] args) {
		Collection<String> c = Arrays.asList("A,B,C,D,E,F,G".split(","));
		/**
		 * Arrays.asList()会产生基于固定大小数组产生的List，任何试图改变list大小的操作都是不支持的
		 */
		try {
			c.add("h");
		} catch (UnsupportedOperationException e) {
			System.out.println(e);
		}
	}

}
