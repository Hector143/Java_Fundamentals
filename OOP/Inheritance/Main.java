package Inheritance;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("Hector","Male",18);
		Toddler t = new Toddler("Alenere", "Female",1,"PS4");
		Kid k = new Kid("Hakkubo","Male",6,"Feeding Frenzy 2",2);
	
//		p.name = "Hector";
//		p.sex = "Male";
//		p.age = 18;
//		
//		t.name = "Niel John";
//		t.sex = "Male";
//		t.age = 18;
//		
		
//		Toddler t1 = new Kid("Hakkubo","Male",6,"Feeding Frenzy 2",2);
//		kid k = new Person("Hector","Male",18);  note that this is error because kid is in the top subclass only superclass can call subclass
//		p.checkStatus();
		t.checkStatus();
		
		k.sayGradeLevel();
		k.eat();
		t.drink();
		t.eat();
		
// meaning k can do everything t and p can and t can do p can and p cannot do p or k can.
	}

}
