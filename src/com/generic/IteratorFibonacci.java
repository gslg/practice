package com.generic;

import java.util.Iterator;

public class IteratorFibonacci extends Fibonacci implements Iterable<Integer>{

	private int n;
	public IteratorFibonacci(int count){
		n=count;
		fibonacci = new Fibonacci();
	}
	private Fibonacci fibonacci;
	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public boolean hasNext() {
				return n>0;
			}

			@Override
			public Integer next() {
				n--;
				return fibonacci.next();
			}

			@Override
			public void remove() {
				
			}
		
		};
	}
	
	public static void main(String[] args) {
		for(int i : new IteratorFibonacci(10))
			System.out.print(i+" ");
	}

}
