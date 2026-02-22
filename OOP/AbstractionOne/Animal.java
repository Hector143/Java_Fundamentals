package AbstractionOne;

public abstract class Animal {
	
	String name;
	String hp;
	String attackDmg;
	
	abstract void makeSound();
	abstract void walk();
	
	void showName() {
		System.out.println("Name : " + name);
		System.out.println("hp : " + hp);
		System.out.println("attack Type & Dmg : " + attackDmg);
	}
	
	void setName(String name, String hp, String attackDmg) {
		this.name = name;
		this.hp = hp;
		this.attackDmg = attackDmg;
	}
}
