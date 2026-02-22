package Constructors;

public class Doggo {
	String color;
	
	public Doggo(String color) {
		this.color = color;
	}
	
	public boolean compareColor(Doggo otherDog) {
        return this.color.equals(otherDog.color);
    }
	public static void main(String[] args) {
		Doggo dog1 = new Doggo("Yellowish");
		Doggo dog2 = new Doggo("Yellowish");
		
		if (dog1.compareColor(dog2)) {
			System.out.println("Both dogs have same color because \nColors of the dogs are " + "Dog1 = " + dog1.color + ", Dog2 = " + dog2.color);
		} else {
			System.out.println("Both dogs have different color because \nThe dog1 color is " + dog1.color + " and dog2 color is " + dog2.color + ".");
		}
		
		

	}

}
