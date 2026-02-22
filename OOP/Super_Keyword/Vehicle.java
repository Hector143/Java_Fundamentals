package Super_Keyword;
// super is a keyword when it turns into orange it means it is a keyword.

class Vehicle {
	int maxSpeed; 
	
	Vehicle() {
		System.out.println("Vehicle Constructor");
	}
	
	Vehicle(int maxSpeed) {
		System.out.println("Vehicle Constructor w / speed");
		this.maxSpeed = maxSpeed;
	}
	
	public void vroom() {
		System.out.println("Vroom vroom");
	}
}

class Car extends Vehicle {
	// override the maxspeed
	int maxSpeed = 100; // this will be printed out instead of 120
	
	Car() {
		super(); // this works 
		System.out.println("Car constructor");
		//super(); its weird becuas it errors
	}
	
	public void display() {
		System.out.println(maxSpeed); // prints out 100
		System.out.println(super.maxSpeed); // print out 120 because its prioritizing the parent.
	}
	
	public void vroom() {
		System.out.println("SKUURT"); // override
		super.vroom(); // callling the parent vroom.
	}
	
}


