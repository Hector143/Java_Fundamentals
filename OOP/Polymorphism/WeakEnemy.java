package Polymorphism;

public class WeakEnemy extends Enemy{
	
	WeakEnemy() {
		name = "Weak Enemy";
		hp = 20;
	}
	void dialog() {
		System.out.println(name + " : I am Weak.");
	}
}
