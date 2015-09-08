package com.thinkinginjava.exception;

public class ExceptionTest {
	
	
	public void f() throws Myexception{
		System.out.println("Throw exception from f");
		throw new Myexception();
	}
	public void g() throws Myexception{
		System.out.println("Throw exception from g");
		throw new Myexception("look in g()");
	}
	
	public static void main(String[] args) {
		ExceptionTest ex = new ExceptionTest();
		
		try {
			ex.f();
		} catch (Myexception e) {
			System.err.println(e.getMsg());
			e.printStackTrace();
		}
		
		try {
			ex.g();
		} catch (Myexception e) {
			System.err.println(e.getMsg());
			e.printStackTrace();
		}finally{
			System.out.println("finally>>>>>>>>>");
		}
		
	}

}

class Myexception extends Exception{
	private String msg="default";
	public Myexception(){}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Myexception(String msg){
		super(msg);
		this.msg = msg;
	}
}
