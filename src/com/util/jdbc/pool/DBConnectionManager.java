package com.util.jdbc.pool;

import java.sql.Connection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class DBConnectionManager {
	private static DBConnectionManager instance;//单例数据库连接管类
	private static int clients;//客户连接数
	private Vector<DSConfigBean> drivers = new Vector<DSConfigBean>();//驱动信息
	private Hashtable<String,DBConnectionPool> pools = new Hashtable<String, DBConnectionPool>();//连接池
	/**
	 * 获得管理实例
	 * @return
	 */
	public synchronized static DBConnectionManager getInstance(){
		if(instance==null){
			instance = new DBConnectionManager();
		}
		return instance;
	}
	/**
	 * 释放连接
	 * @param name
	 * @param conn
	 */
	public void freeConnection(String name,Connection conn){
		DBConnectionPool pool = (DBConnectionPool) pools.get(name);
		if(pool!=null){
			pool.freeConnection(conn);
		}
	}
	/**
	 * 从指定连接池中获取连接
	 * @param name
	 * @return
	 */
	public Connection getConnection(String name){
		DBConnectionPool pool = (DBConnectionPool) pools.get(name);
		Connection conn=null;
		if(pool!=null)
			conn= pool.getConnection();
		if(conn!=null)
			System.out.println("得到连接....");
		
		return conn;
	}
	/**
	  * 根据连接池的名字和等待时间得到一个连接
	  * @param name
	  * @param time
	  * @return
	  */
	 public Connection getConnection(String name, long timeout)
	 {
	  DBConnectionPool pool=null;
	  Connection con=null;
	  pool=(DBConnectionPool)pools.get(name);//从名字中获取连接池
	  if(pool!=null)
		  con=pool.getConnection(timeout);//从选定的连接池中获得连接
	  if(con!=null)
		  System.out.println("得到连接..");
	  
	  return con;
	 }
	 /**
	  * 释放所有连接
	  */
	 public synchronized void release(){
		 Enumeration<DBConnectionPool> poolEnum = pools.elements();
		 
		 while(poolEnum.hasMoreElements()){
			 DBConnectionPool pool = poolEnum.nextElement();
			 if(pool!=null){
				 pool.release();
			 }
		 }
		 
		 pools.clear();
	 }
	 /**
	  * 创建连接池
	  * @param dscb
	  */
	 private void createPools(DSConfigBean dscb){
		 DBConnectionPool pool = new DBConnectionPool();
		 
		 pool.setDriver(dscb.getDriver());
		 pool.setMaxConn(dscb.getMaxconn());
		 pool.setName(dscb.getName());
		 pool.setUser(dscb.getUsername());
		 pool.setUrl(dscb.getUrl());
		 pool.setPassword(dscb.getPassword());
		 System.out.println("ioio:"+dscb.getMaxconn());
		 pools.put(dscb.getName(), pool);
	 }
	 
	 private void init(){
		 loadDirvers();
		 Iterator<DSConfigBean> it = drivers.iterator();
		 
		 while(it.hasNext()){
			 createPools(it.next());
			 System.out.println("创建连接池....");
		 }
		 System.out.println("创建连接池完成...");
	 }
	 
	private void loadDirvers() {
		drivers = ParseDSConfig.loadProperties();
	}
	 
}
