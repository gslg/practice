package com.generic;

public class Fibonacci implements Generator<Integer> {
	private int count=0;
	@Override
	public Integer next() {
		return fib(count++);
	}
	
	public Integer fib(int n){
		if(n<2) return 1;
		return fib(n-2)+fib(n-1);
	}
	public static void main(String[] args) {
		Fibonacci fib = new Fibonacci();
		for(int i=0;i<10;i++)
			System.out.println(fib.next());
	}
}
