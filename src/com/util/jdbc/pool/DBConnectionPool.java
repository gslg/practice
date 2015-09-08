package com.util.jdbc.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
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
	
	public DBConnectionPool(){}
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
	/**
	 * 根据timeout获取连接
	 * @param timeOut
	 * @return
	 */
	public synchronized Connection getConnection(long timeOut){
		Connection conn = null;
		if(this.freeConnections.size()>0){
			conn = this.freeConnections.get(0);
			if(conn==null){
				conn = getConnection(timeOut);//继续获得连接
			}
		}else{
			conn = newConnection();//新建连接
		}
		
		if(this.maxConn == 0 || this.maxConn<this.inUsed){
			conn = null;//已达最大连接数，暂时不能获得连接
		}
		
		if(conn!=null){
			this.inUsed++;
		}
		return conn;
	}
	/**
	 * 从连接池里得到连接
	 * @return
	 */
	public synchronized Connection getConnection(){
		Connection conn = null;
		if(this.freeConnections.size()>0){
			conn = this.freeConnections.get(0);//获取空闲连接里的第一个
			this.freeConnections.remove(0);//如果获取到了就移除这个已分配的连接
			if(conn==null){
				conn = getConnection();
			}
		}else{
			conn = newConnection();
		}
		
		if(this.maxConn == 0 || this.maxConn<this.inUsed){
			conn = null;//等待，超过最大连接数
		}
		if(conn!=null){
			this.inUsed++;
			System.out.println("得到　"+this.name+"　的连接，现有"+inUsed+"个连接在使用!");
		}
		return conn;
	}
	/**
	 * 释放所有连接
	 */
	public synchronized void release(){
		Iterator<Connection> it = this.freeConnections.iterator();
		
		while(it.hasNext()){
			try {
				it.next().close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		this.freeConnections.clear();
	}
	/**
	 * 创建新连接
	 * @return
	 */
	private Connection newConnection() {
		Connection conn=null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
		} catch (Exception e) {
			System.out.println("can not creat Connection");
			e.printStackTrace();
		}
		
		return conn;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	public int getInUsed() {
		return inUsed;
	}
	public void setInUsed(int inUsed) {
		this.inUsed = inUsed;
	}
	public int getMinConn() {
		return minConn;
	}
	public void setMinConn(int minConn) {
		this.minConn = minConn;
	}
	public int getMaxConn() {
		return maxConn;
	}
	public void setMaxConn(int maxConn) {
		this.maxConn = maxConn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Timer getTimer() {
		return timer;
	}
	public void setTimer(Timer timer) {
		this.timer = timer;
	}
	public ArrayList<Connection> getFreeConnections() {
		return freeConnections;
	}
	public void setFreeConnections(ArrayList<Connection> freeConnections) {
		this.freeConnections = freeConnections;
	}
	
	
}
