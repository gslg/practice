package com.test.dao;

import java.util.LinkedHashMap;

import com.generic.dao.BaseDaoImpl;
import com.test.domain.User;

public class UserDao<User,Long> extends BaseDaoImpl{

	public static void main(String[] args) {
		LinkedHashMap<Integer, String> cachemap = new  LinkedHashMap<>(10, 0.75f, true);
		
		cachemap.put(1, "aa");
		cachemap.put(2, "bb");
		cachemap.put(3, "cc");
		cachemap.put(4, "dd");
		cachemap.put(5, "ee");

		System.out.println(cachemap.toString());
		
		cachemap.get(1);
		System.out.println(cachemap.toString());
	}

}
