package main;

import java.util.Random;

public class DiceRoller_v {
	Random random;
	int number;
	
	DiceRoller_v(){
		random = new Random();
		roll();
	}
	void roll() {
		number = random.nextInt(6)+1;
		System.out.println(number);
		
	}
}
