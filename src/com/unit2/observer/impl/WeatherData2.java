package com.unit2.observer.impl;

import java.util.Observable;

public class WeatherData2 extends Observable{
	private float temperature;
	private float pressure;
	private float humidity;
	
	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	public void setMeasurements(float temperature,float humidity,float pressure){
		this.temperature=temperature;
		this.humidity=humidity;
		this.pressure=pressure;
		
		
		measurementsChanges();
	}

	private void measurementsChanges() {
		setChanged();
		notifyObservers();
	}
}
