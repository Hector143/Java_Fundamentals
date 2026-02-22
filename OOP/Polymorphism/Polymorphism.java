package Polymorphism;

class Bird {
	public void sing() {
		System.out.println("tweet tweet tweet");
	}
}

class Robin extends Bird {
	public void sing() {
		System.out.println("twiddledeedee");
	}
}

class Pelican extends Bird {
	public void sing() {
		System.out.println("KWAAH KWAHAH KWAHA");
	}
}

public class Polymorphism {

	public static void main(String[] args) {
		// make an object class
		Bird b = new Bird();
		Robin r = new Robin();
		Pelican p = new Pelican();
		
		
		b.sing(); // bird sings tweek twekk tweek because it is called inside its class method.
		r.sing(); // even though robin knows bird it still priorities within its class.
		p.sing(); // even though pelican knows bird it still priorities pelican more than extends bird because it is within its class.
		
	
		

	}

}
