package AbstractionOne;
// abstract is different from interface.

// interface you can't implement in methods because abstract methods do not specify a body.
// because all methods in interface assumes that its abstract so it means 
// its not implemented yet or it means no code inside.
interface DogInterface {
	void bark();
	void poop();
}

//abstract classes help us organize what a dog should have or what shoudl htis clas s have.
// abstract classes are different because you can have a list of methods and ones that are already implemeneted.
// so only use abstract if there is at least one or many methods that are implemented otherwise you could use interface.
abstract class Dogs {
	// an implemented method
	public void bark() {
		System.out.println("Bark!");
	}
	
	// non implemented method which means this can be also done in interface.
	public abstract void poop();
	public abstract void weapons();
}

// but in abstract class you an have both abstract class and abstract methods.
abstract class Cats {
	public void meow() {
		System.out.println("Meow!!");
	}
	
	public abstract void poop();
	
	public abstract void weapons();
}

// you can have interface chihuahua but you need to implement it.
//class Chihuahua implements DogInterface


// extends means adding on to our previous implemented code where as only use implements if no methods are already implemented.
class Chihuahua extends Dogs {
	public void poop() {
		System.out.println("Dog pooped!");
	}

	public void weapons() {
		System.out.println("Dog Main weapon: Bite, Secondary: Claws");
	}
}

class Siamese extends Cats {
	public void poop() {
		System.out.println("Cat pooped!");
	}

	public void weapons() {
		System.out.println("Cat Main weapon: Claws, Bite; Secondary: pow, kick");
	}
}

public class AbstractTutorial {

	public static void main(String[] args) {
		Chihuahua c = new Chihuahua();
		Siamese s = new Siamese();
		
		c.bark();
		c.poop();
		
		s.meow();
		s.weapons();
		
		
		
	}

}
