package com.thinkinginjava.string;

import java.util.regex.Pattern;

public class IntegerMatch {

	public static void main(String[] args) {
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("5678".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
		System.out.println("+911".matches("(-|\\+)?\\d+"));
		
		Pattern reg = Pattern.compile("^[A-Z].*$\\.");
		System.out.println(reg.matcher("Asdksh22.").matches());
		
	}

}
