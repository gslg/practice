package com.thinkinginjava.clazz;

public class SimpleProxyDemo {

	public static void main(String[] args) {
		RealObject real = new RealObject();
		
		consumer(real);
		consumer(new SimleProxy(real));
		System.out.println(RealObject.doCount);
		System.out.println(RealObject.soCount);
		
	}
	
	public static void consumer(Interface inf){
		inf.doSomething();
		inf.somethingElse("SimpleProxyDemo");
	}

}
interface Interface{
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface{

	 static int doCount=0;
	 static int soCount=0;
	@Override
	public void doSomething() {
		System.out.println("doSomething");
		doCount++;
	}

	@Override
	public void somethingElse(String arg) {
		System.out.println("somethingElse "+arg);
		soCount++;
	}
	
}
class SimleProxy implements Interface{
	private Interface inter;
	
	public SimleProxy(Interface inter) {
		this.inter = inter;
	}
	@Override
	public void doSomething() {
		inter.doSomething();
	}

	@Override
	public void somethingElse(String arg) {
		inter.somethingElse("SimleProxy");
	}
	
}
