package com.unit2.observer.impl;

import java.util.ArrayList;

import com.unit2.observer.inter.Observer;
import com.unit2.observer.inter.Subject;

public class WeatherData implements Subject {
	private ArrayList<Observer> observerList;
	
	private float temperature;
	private float pressure;
	private float humidity;
	
	public WeatherData(){
		observerList=new ArrayList<Observer>();
	}
	
	@Override
	public void registObserver(Observer observer) {
		observerList.add(observer);

	}

	@Override
	public void removeObserver(Observer observer) {
		//if(observerList.contains(observer)){
			int index=observerList.indexOf(observer);
			if(index != -1)
				observerList.remove(index);
		//}

	}

	@Override
	public void notifyObservers() {
		for(int i=0;i<observerList.size();i++){
			observerList.get(i).update(temperature, humidity, pressure);
		}

	}
	
	//设置新的天气状况
	public void setMeasurements(float temperature,float humidity,float pressure){
		this.temperature=temperature;
		this.humidity=humidity;
		this.pressure=pressure;
		
		measurementsChanges();
	}
	//气温改变时提醒
	private void measurementsChanges() {
		notifyObservers();
		
	}

}
