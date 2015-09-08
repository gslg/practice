package com.unit1.strategy.impl;

import com.unit1.strategy.inter.QuackBehavior;

public class MuteQuack implements QuackBehavior {

	@Override
	public void quack() {
		System.out.println("keep silence.....");

	}

}
