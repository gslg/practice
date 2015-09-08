package com.thinkinginjava.clazz;

import java.util.Random;

public class ClassInitinalization {
	public static Random rand = new Random(47);
	public static void main(String[] args) throws Exception {
		Class initable = Initable.class;
		System.out.println("after create Initable Class ref>>>>>");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		System.out.println(Initable2.staticNoFinal);
		
		System.out.println("before create Initable3 Class ref>>>>>");
		Class initable3 = Class.forName("com.thinkinginjava.clazz.Initable3");
		System.out.println("after create Initable3 Class ref>>>>>");
		System.out.println(Initable3.staticNoFinal);
		
		//Class<Integer> clzz=int.class;
		//clzz=double.class;
		Class<? extends Number> clazz=int.class;
		clazz=double.class;
		
	}
}
class Initable{
	static final int staticFinal=47;
	static final int staticFinal2=ClassInitinalization.rand.nextInt(100);
	
	static{
		System.out.println("Initinalization Initable");
	}
}
class Initable2{
	static  int staticNoFinal=147;
	static{
		System.out.println("Initinalization Initable2");
	}
}
class Initable3{
	static  int staticNoFinal=74;
	static{
		System.out.println("Initinalization Initable3");
	}
}