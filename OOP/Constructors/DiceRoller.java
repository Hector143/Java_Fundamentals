package Constructors;

import java.util.Random;

public class DiceRoller {
	Random random;
	int number;
	 
	DiceRoller(){
	random = new Random();
	roll();
}
	 
	void roll() {
	number = random.nextInt(3)+1;
	if (number == 1) {
		System.out.println("Rock");
	} else if (number == 2) {
		System.out.println("Scissor");
	} else if (number == 3) {
		System.out.println("Paper");
	}
		

	}
}