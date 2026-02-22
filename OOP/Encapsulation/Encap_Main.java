package Encapsulation;

public class Encap_Main {

	public static void main(String[] args) {
		
		Encap e = new Encap("Angel", "12/27/2025"); // THis is called object
		
		System.out.println("My name is : " + e.getName()); // tinawag ko si object method
		System.out.println("Today is : " + e.getDate());// tinawag ko si object method
		
		e.setName("Abarento"); // tinawag ko si object Setters method
		e.setDate("12/29/2025"); // tinawag ko si object Setters method
		
		System.out.println("My name now is : " + e.getName()); 
		System.out.println("right now date is : " + e.getDate());
		
		// gets?
		

	}

}
