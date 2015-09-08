package com.thinkinginjava.clazz.packageaccess;

import com.thinkinginjava.clazz.A;

public class HiddenC {
	public static A makeA(){
		return new C();
	}
}

class C implements A{

	private int b;
	
	public int getB() {
		return b;
	}
	
	@Override
	public void f() {
		System.out.println("C.f()");
	}
	public void g() {
		System.out.println("C.g()");
	}
	
	void u(){
		System.out.println("package C.u()");
	}
	protected void v(){
		System.out.println("protected C.v()");
	}
	private void w(){
		System.out.println("private C.w()");
	}
	
}
