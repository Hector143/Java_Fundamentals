package Interfaces;


// we make an interface named WaterBottleInterface to create.
interface WaterBottleInterface {
	// we make an atrtribute for the waterbottleinterface.
	String color = "Blue";
	
	void fillUp(); // empty bodies of the method
	void pourOut(); // empty bodies
}


public class InterfaceExample implements WaterBottleInterface {
	// implements because you will implement it here in the class not in the waterbootleinterface.
	public static void main(String[] args) {
		// since class INterfaceExample knows what is waterBottle Inteface he can do hes job or work with it.
		System.out.println(color);
		// we call our own class and make an object ex to call the methods in our class of what we implement.
		InterfaceExample ex = new InterfaceExample();
		ex.fillUp();
		ex.pourOut();

	}
	
	// this is required because you implement the class which needs to fill up the empty methods.
	@Override
	public void fillUp() {
		// since this class implements the waterbottle it should fill the empty method.
		System.out.println("It is filled!");
		
	}

	@Override
	public void pourOut() {
		// since this class implements the waterbottle it should fill the empty method.
		System.out.println("Your cup has been poured out!");
		
	}

}
