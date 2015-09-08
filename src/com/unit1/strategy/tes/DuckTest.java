package com.unit1.strategy.tes;

import com.unit1.strategy.domain.Duck;
import com.unit1.strategy.domain.MallardDuck;
import com.unit1.strategy.domain.ModelDuck;
import com.unit1.strategy.impl.FlyNoWay;
import com.unit1.strategy.impl.FlyWithRockets;
import com.unit1.strategy.impl.FlyWithWings;
import com.unit1.strategy.impl.Quack;
import com.unit1.strategy.impl.Squeak;

public class DuckTest {

	public static void main(String[] args) {
		Duck mallardDuck=new MallardDuck();
		
		mallardDuck.setFlyBehavior(new FlyWithWings());
		mallardDuck.setQuackBehavior(new Quack());
		
		mallardDuck.display();
		mallardDuck.performFly();
		mallardDuck.performQuack();
		
		Duck modelduck=new ModelDuck();
		
		modelduck.setFlyBehavior(new FlyNoWay());
		modelduck.performFly();
		modelduck.setQuackBehavior(new Squeak());
		modelduck.setFlyBehavior(new FlyWithRockets());
		
		modelduck.display();
		modelduck.performFly();
		modelduck.performQuack();
		
		

	}

}
