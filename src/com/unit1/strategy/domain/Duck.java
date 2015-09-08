package com.unit1.strategy.domain;

import com.unit1.strategy.inter.FlyBehavior;
import com.unit1.strategy.inter.QuackBehavior;

public abstract class Duck {
	private FlyBehavior flyBehavior;
	private QuackBehavior quackBehavior;
	
	public abstract void display();
	
	public void performFly(){
		flyBehavior.fly();
	}
	
	public void performQuack(){
		quackBehavior.quack();
	}
	
	public void setFlyBehavior(FlyBehavior flyBehavior){
		this.flyBehavior=flyBehavior;
	}
	
	public void setQuackBehavior(QuackBehavior quackBehavior){
		this.quackBehavior=quackBehavior;
	}
}
