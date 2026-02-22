package Constructors;

public class pizza {
	
	String bread;
	String sauce;
	String flavor;
	String cheese;
	String Toppings;
	
	
	pizza(String bread) {
		this.bread = bread;
	
		
	}
	pizza(String bread, String sauce) {
		this.bread = bread;
		this.sauce = sauce;
		
		
	}
	pizza(String bread, String sauce, String flavor) {
		this.bread = bread;
		this.sauce = sauce;
		this.flavor = flavor;
		
		
	}
	pizza(String bread, String sauce, String flavor, String cheese) {
		this.bread = bread;
		this.sauce = sauce;
		this.flavor = flavor;
		this.cheese = cheese;
		
	}
	pizza(String bread, String sauce, String flavor, String cheese, String Toppings) {
		this.bread = bread;
		this.sauce = sauce;
		this.flavor = flavor;
		this.cheese = cheese;
		this.Toppings = Toppings;
	}
	
}
