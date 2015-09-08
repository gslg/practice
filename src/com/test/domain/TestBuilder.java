package com.test.domain;

import java.util.Date;

import com.effectivejava.unit2.BuilderPattern;
import com.effectivejava.unit2.SingleElviByEnum;

public class TestBuilder {

	public static void main(String[] args) {
		//BuilderPattern bp = new BuilderPattern.Builder(22,33).calories(0).fat(3).build();
		
		/**
		 * 枚举类型的单例模式
		 */
		//SingleElviByEnum.instance.say();
		
		/**
		 * 一般优先使用基本类型而不是包装类型
		 */
		long sum = 0L;
		long start = new Date().getTime();
		for(int i=0;i<Integer.MAX_VALUE;i++){
			sum+=i;
		}
		long end = new Date().getTime();
		System.out.println("sum="+sum+",time="+(end-start));
	}

}
