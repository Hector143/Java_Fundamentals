package main;

import java.util.Scanner;

public class Main101 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.print("Name : ");
		String name = s.nextLine();
		
		
		System.out.print("Price : ");
		float price = s.nextFloat();
		
		product p = new product(name,price);
		
		// before we used methods
//		person p = new person();
//		p.firstName = "David";
//		p.lastName = "Dudes";
//		p.age = 18;
//		p.sex = 'M';
//		// after we used constructors
		
//		person p = new person("David","Dunkry",'M',32);
//		person p1 = new person("Rolly","Denver",'M',28);
//		person p2 = new person("Woods","holly",'M',24);
//		
//		System.out.println(p.lastName);
//		System.out.println(p1.firstName);
//		product p3 = new product("Milk",150.0f);
//		product p4 = new product("Softdrinks",12.50f);
//		product p5 = new product("CupNoodles",20.25f);
		
		
		
		
	}

}
