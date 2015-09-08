package com.unit2.observer.domain;

import java.util.Observable;
import java.util.Observer;

import com.unit2.observer.impl.WeatherData2;
import com.unit2.observer.inter.DisplayElement;


public class CurrentConditionDisplay2 implements DisplayElement,Observer{
	
	private float temperature;
	private float pressure;
	private float humidity;
	
	Observable ob;
	
	public CurrentConditionDisplay2(Observable ob){
		this.ob=ob;
		ob.addObserver(this);//×¢²á¹Û²ì
	}
	
	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData2){
			WeatherData2 weather=(WeatherData2)o;
			
			this.temperature=weather.getTemperature();
			this.pressure=weather.getPressure();
			this.humidity=weather.getHumidity();
			
			System.out.println(arg);
			display();
		}
		
	}
	@Override
	public void display() {
		System.out.println("Current Conditions:"+ temperature +"F degrees and " +humidity+"%humidity");
		
	}
	
	
	
	
}
