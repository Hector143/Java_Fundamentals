package Polymorphism;

public class Main {

	public static void main(String[] args) {
		// this is inheritance
//		Dog d = new Dog();
//		Cat c = new Cat();
		
//		d.makeSound();
//		c.makeSound(); 
		// one class multiple forms  this is 'polymorphism'
//		Animal a = new Dog();
//		Animal b = new Cat();
//		a.makeSound();
//		b.makeSound();
		
		
		Enemy we = new WeakEnemy();
		Enemy se = new StrongEnemy();
		
		
		we.showStatus();
		we.dialog();
		
		se.showStatus();
		se.dialog();
		

	}

}
