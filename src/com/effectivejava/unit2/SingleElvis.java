package com.effectivejava.unit2;

public class SingleElvis {
	/**
	 * 第一种单例
	 */
	//private static final SingleElvis singleElvis = new SingleElvis();
	/**
	 * 第二种单例
	 */
	/*
	private static final SingleElvis singleElvis = new SingleElvis();
	
	public static SingleElvis getInstance(){
		return singleElvis;
	}
	*/
	private static final SingleElvis singleElvis = new SingleElvis();
	
	private SingleElvis(){}
}
