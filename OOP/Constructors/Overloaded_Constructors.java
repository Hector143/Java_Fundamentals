package Constructors;

public class Overloaded_Constructors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		pizza pidza = new pizza("Loaf","tomato sauce","pineapple","mozzerella");
		
		System.out.println("Here are the Ingredients of your pizza: ");
		System.out.println(pidza.bread);
		System.out.println(pidza.sauce);
		System.out.println(pidza.flavor);
		System.out.println(pidza.cheese);

	}

}
