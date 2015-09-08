package com.thinkinginjava.clazz;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.thinkinginjava.clazz.packageaccess.HiddenC;

public class HiddenImplementation {

	public static void main(String[] args) throws Exception {
		A a = HiddenC.makeA();
		
		a.f();
		System.out.println(a.getClass().getName());
		/* compile error
		if(a instanceof C){
			C c = (C)a;
			c.g();
		}*/
		callHiddenMethod(a,"g");
		callHiddenMethod(a,"u");
		callHiddenMethod(a,"v");
		callHiddenMethod(a,"w");
		
		setField(a, "b");
		
	}
	
	static void callHiddenMethod(Object a,String methodName) throws Exception{
		Method m = a.getClass().getDeclaredMethod(methodName);
		
		m.setAccessible(true);
		m.invoke(a);
	}
	static void setField(Object a,String fieldName) throws Exception{
		Field field = a.getClass().getDeclaredField(fieldName);
		field.setAccessible(true);
		field.set(a, 2);
	}

}
