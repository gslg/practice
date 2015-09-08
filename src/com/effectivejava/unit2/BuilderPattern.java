package com.effectivejava.unit2;

public class BuilderPattern {
	private final int servingSize; 
	private final int servings; 
	private final int calories; 
	private final int fat; 
	private final int sodium; 
	private final int calbohydrate; 
	
	public static class Builder{
		//required
		private final int servingSize; 
		private final int servings; 
		//optional
		private  int calories = 0; 
		private  int fat = 0; 
		private  int sodium = 0 ; 
		private  int calbohydrate = 0; 
		
		public Builder(int servingSize,int servings) {
			this.servingSize=servingSize;
			this.servings=servings;
		}
		
		public Builder calories(int val){
			calories = val;
			return this;
		}
		public Builder fat(int val){
			fat = val;
			return this;
		}
		public Builder sodium(int val){
			sodium = val;
			return this;
		}
		public Builder calbohydrate(int val){
			calbohydrate = val;
			return this;
		}
		
		public BuilderPattern build(){
			return new BuilderPattern(this);
		}
	}
	
	private BuilderPattern(Builder builder){
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		calbohydrate = builder.calbohydrate;
	}
	
}
