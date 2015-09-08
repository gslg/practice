package com.unit2.observer.inter;

public interface Subject {
	//注册一个观察者
	public void registObserver(Observer observer);
	//删除一个观察者
	public void removeObserver(Observer observer);
	//提醒所用观察者
	public void notifyObservers();
	
	
	
}
