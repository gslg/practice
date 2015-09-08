package com.thinkinginjava.exception;

public class ThirdMyExTest extends SecondMyExTest{

	public void f() throws MythirdException{
		throw new MythirdException();
	}
	
	public static void main(String[] args) {
		BaseMyExceptionTest bmet = new ThirdMyExTest();
		
		try {
			bmet.f();
		} catch (MyFirstException e) {
			e.printStackTrace();
		}
	}

}
