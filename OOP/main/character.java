package main;

public class character {
	
	String name, dialog;
	int hp, mp, lvl;
	
	character(String name, String dialog, int hp, int mp, int lvl) {
		
		this.name = name;
		this.dialog = dialog;
		this.hp = hp;
		this.mp = mp;
		this.lvl = lvl;
	}
	
	void introduce() {
		System.out.println("I am " + name);
	}
	
	void sayDialog() {
		System.out.println(name + " : " + dialog);
	}
	
	void talkTo(String firstName) {
		System.out.println(name + " : Hello, " + firstName);
	}
	
	String talkToC(character x) {
		return name + " : Hello, " + x.name;
	}


}
