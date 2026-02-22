package AbstractionOne;

public class Main {

	public static void main(String[] args) {
		// Abstraction Flow
		// 1. Abstraction
		// 2. Abstract Classes
		// 3. Abstract Methods
		// 4. Using Abstraction (Abstract Class)
		
		/* Abstraction: 
		It is an OOP technique that hides certain details and
		only shows the important information.
		
		It can be achieved in 2 ways:
			> Abstract Classes(Uses Abstract modifier)
			> Interfaces(Uses implements keyword)
		
		Abstract Class:
		- It cannot be instantiated, to access it you need to 
		inherit it from another class.
		
		ABSTRACT Methods
		- Can only be declared inside an abstract class it is 
		a Method without a body and it needs to be override 
		in the subclass of the abstract class
		
		
		* 	Abstraction Syntax
		* 	(Abstract Classes)
		* 
		* abstract class Animal {
		* 	abstract void makeSound();
		* }
		* 
		* class Dog extends Animal{
		* 	void makeSound() { } }
		*  		Output: Arf!
		* 
		* class Cat extends Animal{
		* 	void makeSound(){
		* 		Output: Meow!
		*/
		// ABSTRACT IDEA
//		Animal a = new Animal();
		
		//CONCRETE IDEA
		Animal d = new Dog();
		Animal c = new Dog();
		
		d.setName("Doggy", "120", "Bite Damage = 15");
		c.setName("Catt", "70", "Claws & Bite Damage = 7 & 9");
		
		d.showName();
		c.showName();
		
	}

}
