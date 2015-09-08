package com.thinkinginjava.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

class ShowMethods {
	private static String useage = 
			"useage:\n"+
			"ShowMethods qualifieds.class.name\n"+
			"To show all methods in class or\n"+
			"ShowMethods qualifieds.class.name word\n"+
			"To search for methods involving 'world'";
	private static Pattern p = Pattern.compile("\\w+\\.");
	public static void main(String[] args) {
		if(args.length<1){
			System.out.println(useage);
			System.exit(0);
		}
		int lines=0;
		
		try {
			Class<?> clazz = Class.forName(args[0]);
			Method[] methods = clazz.getMethods();
			Constructor[] cons = clazz.getConstructors();
			
			if(args.length==1){
				for(Method method : methods)
					System.out.println(p.matcher(method.toString()).replaceAll(""));
				
				for(Constructor con : cons){
					System.out.println(p.matcher(con.toString()).replaceAll(""));
					//con.newInstance(args)
					
				}
				lines = methods.length+cons.length;
			}else{
				for(Method method : methods){
					if(method.toString().indexOf(args[1]) !=-1){
						System.out.println(p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				}
				for(Constructor con : cons)
					if(con.toString().indexOf(args[1]) !=-1){
						System.out.println(p.matcher(con.toString()).replaceAll(""));
						lines++;
					}
				
			}
		} catch (ClassNotFoundException e) {
			System.out.println("No Such Class :"+e);
		}
	}

}
