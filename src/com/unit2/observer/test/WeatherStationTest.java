package com.unit2.observer.test;

import java.util.Observable;

import com.unit2.observer.domain.CurrentConditionDisplay;
import com.unit2.observer.domain.CurrentConditionDisplay2;
import com.unit2.observer.impl.WeatherData;
import com.unit2.observer.impl.WeatherData2;

public class WeatherStationTest {
	
	public static void main(String []args){
		//自定义方式
		//WeatherData weather=new WeatherData();
		
		//CurrentConditionDisplay currentConditionDisplay=new CurrentConditionDisplay(weather);
		
		//weather.setMeasurements(80, 60, 29.2f);
		
		//java.util.Obsever
		WeatherData2 ob=new WeatherData2();
		CurrentConditionDisplay2 currentConditionDisplay=new CurrentConditionDisplay2(ob);
		ob.setMeasurements(80, 60, 30.0f);
		
	}
	
	
}
