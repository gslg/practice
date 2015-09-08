package com.util.jdbc.pool;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Timer;

public class DBConnectionPool extends Timer{
	private Connection conn=null;//连接
	private int inUsed=0;//在使用中的连接数
	private int minConn;//最小连接数
	private int maxConn=0;//最大连接数
	private String name;//连接池名字
	private String password;//连接池密码
	private String url;//数据库连接地址
	private String driver;//数据库驱动
	private String user;//用户名
	private Timer timer;//定时
	private ArrayList<Connection> freeConnections = new ArrayList<Connection>();//容器，空闲连接
	/**
	 * <创建连接池>
	 * @param maxConn
	 * @param name
	 * @param password
	 * @param url
	 * @param driver
	 * @param user
	 */
	public DBConnectionPool(int maxConn, String name, String password, String url, String driver, String user) {
		super();
		this.maxConn = maxConn;
		this.name = name;
		this.password = password;
		this.url = url;
		this.driver = driver;
		this.user = user;
	}
	/**
	 * 释放连接
	 * @param conn
	 */
	public synchronized void freeConnection(Connection conn){
		this.freeConnections.add(conn);//添加到空闲连接的末尾
		this.inUsed--;
	}
	public synchronized Connection getConnection(long timeOut){
		return null;
	}
	
	
}
