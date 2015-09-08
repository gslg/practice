package com.unit1.strategy.impl;

import com.unit1.strategy.inter.FlyBehavior;

public class FlyWithWings implements FlyBehavior {

	@Override
	public void fly() {
		System.out.println("I can fly with Wings");

	}

}
