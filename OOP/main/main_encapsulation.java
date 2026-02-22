package main;

import java.util.Scanner;
public class main_encapsulation {

	public static void main(String[] args) {
		User u = new User(54321, "Professor", "Hector", "Hekit");
		
		u.setFirstName("Hector Josh ");
		u.setLastName("Salera");
		System.out.print(u.getFirstName());
		System.out.println(u.getLastName());
	}

}
