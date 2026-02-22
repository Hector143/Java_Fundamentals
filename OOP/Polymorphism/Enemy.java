package Polymorphism;

public class Enemy {
	
	String name;
	int hp;
	
	void dialog() {
		System.out.println("Please Override Me.");
	}
	
	void showStatus() {
		System.out.println("Name  : " + name);
		System.out.println("HP    : " + hp);
		
	}
}
