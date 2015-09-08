package com.util.dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sun.xml.internal.ws.server.DraconianValidationErrorHandler;

public class GenericDao {
	private  Class clazz;
	
	public GenericDao(Class clazz){
		this.clazz = clazz;
	}
	
	 public ArrayList<? extends Object> query() throws Exception {
		 Connection con = null;
		 PreparedStatement ps = null;
		 ResultSet rs = null;
		 
		 ArrayList<Object> al = new ArrayList<Object>();
		 
		 con = DriverManager.getConnection(null);
		 String sql=String.format(  
			     "select * from %s",clazz.getSimpleName()  
			     );
		 ps = con.prepareStatement(sql);
		 
		 rs = ps.executeQuery();
		 while(rs.next()){
			Object obj = clazz.newInstance();
			 
			 Field[] fields = clazz.getDeclaredFields();
			 
			 for(Field field :fields){
				 field.setAccessible(true);
				 field.set(obj, rs.getObject(field.getName()));
			 }
			 al.add(obj);
		 }
		return al;
	 }
	 public static void main(String[] args) {
		 String sql=String.format(  
			     "select * from %s",GenericDao.class.getSimpleName()  
			     );
		 System.out.println(sql);
	}
}
