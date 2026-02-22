package main;

public class Main_character {

	public static void main(String[] args) {
		
		character c = new character("David", "Hello There",100, 50, 1);
		character c1 = new character("Marshmellow", "Hi There",80, 30, 5);
		
		
		c.talkToC(c1);
		c1.talkToC(c);
		
		System.out.println(c.talkToC(c1));
		System.out.println(c1.talkToC(c));
	}

}
