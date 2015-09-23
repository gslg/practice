package com.generic.coffees;

import java.util.Iterator;
import java.util.Random;

import com.generic.Generator;

public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee>{

	private int size=0;
	private Random rand = new Random(47);
	Class coffeeType[]={com.generic.coffees.Coffee.class,com.generic.coffees.Americanio.class,
						com.generic.coffees.Breve.class,com.generic.coffees.Cappuccino.class,
						com.generic.coffees.Latte.class,com.generic.coffees.Mocha.class};
	public CoffeeGenerator(){}
	public CoffeeGenerator(int sz){size=sz;}
	
	@Override
	public Iterator<Coffee> iterator() {
		
		return new CoffeeIterator();
	}

	/**
	 * 随机生成一种Coffee
	 */
	@Override
	public Coffee next() {
		try {
			return (Coffee) coffeeType[rand.nextInt(coffeeType.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 自定义迭代器
	 * @author sobey
	 */
	class CoffeeIterator implements Iterator<Coffee>{
		int count=size;
		@Override
		public boolean hasNext() {
			return count>0;
		}

		@Override
		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}
	public static void main(String[] args) {
		CoffeeGenerator gen = new CoffeeGenerator();
		for(int i=0;i<5;i++)
			System.out.println(gen.next());
		
		for(Coffee c : new CoffeeGenerator(5))
			System.out.println(c);
	}

}
