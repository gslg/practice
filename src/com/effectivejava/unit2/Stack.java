package com.effectivejava.unit2;

import java.util.Arrays;
import java.util.EmptyStackException;
//java类存溢出返利
public class Stack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INIT_CAPACITY = 16;
	
	public Stack(){
		elements = new Object[DEFAULT_INIT_CAPACITY];
	}
	
	public void push(Object o){
		ensureCapacity();
		elements[size++] = o;
	}
	
	public Object pop(){
		if(size==0)
			throw new EmptyStackException();
		//这样会造成过期引用
		//return elements[--size];
		Object result = elements[--size];
		elements[size] = null;
		
		return result;
	} 
	private void ensureCapacity(){
		if(elements.length == size){
			elements = Arrays.copyOf(elements, size*2+1);
		}
	}
}
