package Encapsulation;

public class Students {
	// Encapsulation means it is contained inside the capsule
	// so we do not know what inside of the Students because its capsule so we need to make it private;
	private String name;
	private int age;
	
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String getName() {
		return name;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public int getAge() {
		return age;
	}
}
