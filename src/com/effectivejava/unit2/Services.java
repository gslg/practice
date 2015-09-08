package com.effectivejava.unit2;

import java.util.HashMap;
import java.util.Map;

public class Services {
	/**
	 * 私有构造器，防止创建实例
	 */
	private Services(){}
	
	private static final Map<String,Provider> providers=new HashMap<String,Provider>();
	
	public static final String DEFAULT_PROVIDER_NAME="<def>";
	
	/**
	 * provider registration API
	 * @param p
	 */
	public static void registerDeafaultProvider(Provider p){
		registerProvider(DEFAULT_PROVIDER_NAME,p);
	}

	public static void registerProvider(String providerName, Provider p) {
		providers.put(providerName,p);
	}
	/**
	 * Service access API
	 * @return
	 */
	public static Service newInstance(){
		return newInstance(DEFAULT_PROVIDER_NAME);
	}
	public static Service newInstance(String name){
		Provider p = providers.get(name);
		if(p == null){
			throw new IllegalArgumentException("Noprovider register with name:"+name);
		}
		return p.newService();
	}
	
}
