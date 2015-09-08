package com.thinkinginjava.generic;

public class Holder<T> {
	private T o;
	public static void main(String[] args) {
		Holder<AutoMobile> h = new Holder<AutoMobile>(new AutoMobile());
		
		h.getO().f();
	}
	
	public T getO() {
		return o;
	}
	public void setO(T o) {
		this.o = o;
	}
	
	public Holder(T t){
		this.o = t;
	}
	

	
}
class AutoMobile{
	void f(){
		System.out.println("AutoMobile.f()");
	}
}
