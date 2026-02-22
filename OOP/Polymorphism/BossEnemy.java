package Polymorphism;

public class BossEnemy extends Enemy{
	
	BossEnemy() {
		name = "Final Boss!";
		hp = 1000;
	}
	void dialog() {
		System.out.println(name + " : I am the Final Boss!");
	}
}
