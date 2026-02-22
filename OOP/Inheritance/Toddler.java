package Inheritance;
//Sub-class
public class Toddler extends Person{
	
	String favoriteGame;
	
	Toddler(String name, String sex, int age, String favoriteGame) {
		
		super(name,sex,age);
		this.favoriteGame = favoriteGame;
	}
	
// you can also call name, age, sex variable names from the person class because we inherited from the superclass
	void eat() {
		System.out.println(name + " is eating a pizza!");
	}

	void drink() {
		System.out.println("Drinking Water");
	}
// use this method below if you want only the Toddler to output and not the Superclass
	void checkStatus() {
		//add super when you want to include persons attributes like (name,age,sex)
		super.checkStatus();
		System.out.println("Favorite Game : " + favoriteGame);
	}

		
	
}
