package com.unit1.strategy.impl;

import com.unit1.strategy.inter.FlyBehavior;

public class FlyNoWay implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can't fly....");

	}

}
