package com.unit2.observer.domain;

import com.unit2.observer.impl.WeatherData;
import com.unit2.observer.inter.DisplayElement;
import com.unit2.observer.inter.Observer;
import com.unit2.observer.inter.Subject;

public class CurrentConditionDisplay implements DisplayElement,Observer {
	private float temperature;
	private float pressure;
	private float humidity;
	
	private Subject weatherData;

	
	public CurrentConditionDisplay(WeatherData weatherData){
		this.weatherData = weatherData;
		
		weatherData.registObserver(this);
		
	}
	@Override
	public void display() {
		System.out.println("Current Conditions:"+ temperature +"F degrees and " +humidity+"%humidity");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature=temp;
		this.humidity=humidity;
		this.pressure=pressure;
		//更新气温时展示
		display();
	}
	
	
	
	
}
