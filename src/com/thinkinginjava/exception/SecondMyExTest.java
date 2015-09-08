package com.thinkinginjava.exception;

public class SecondMyExTest extends BaseMyExceptionTest {
	
	public void f() throws MySecondException{
		throw new MySecondException();
	}
}
