package com.thinkinginjava.clazz;


class Candy{
	static{
		System.out.println("Loading Candy....");
	}
}
class Gum{
	static{
		System.out.println("Loading Gum....");
	}
	public Gum(){}
	void f(){
		System.out.println("I AM Gum....");
	}
}
class Cookie{
	static{
		System.out.println("Loading Cookie....");
	}
}
public class SweetShop {
	
	public static void main(String[] args) {
		System.out.println("inside main>>>>>>>>");
		new Candy();
		System.out.println("after create candy......");
		try {
			Class clazz =Class.forName("com.thinkinginjava.clazz.Gum");
			try {
				
				Object obj = (Gum) clazz.newInstance();
				if(obj instanceof Gum){
					Gum gum =(Gum) obj;
					gum.f();
					Class cl = int.class;
					cl = Integer.TYPE;
				}
				//Cookie gum = (Cookie) clazz.newInstance();
			} catch (InstantiationException e) {
				
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("after 'Class.forName('Gum')' ........");
		new Cookie();
	}
}
