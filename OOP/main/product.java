package main;

public class product {
	
	String name;
	float price;
	
	
	product(String name, float price){
		
		this.name = name;
		this.price = price;
		
		System.out.println(name + " Created");
		System.out.println("PHP. " + price);
		
	}
}
