package Encapsulation;

public class Main_Students {

	public static void main(String[] args) {
		// this is not a good habit because we are doing OOP
//		Students s = new Students();
//		s.name = "TommyInit";
//		s.age = 17;
//		System.out.println(s.name);
//		System.out.println(s.age);
		
		Students s = new Students();
		// basically we created object Student named s.
		s.setName("TommyInit");
		s.setAge(25);
		// so when we call s.setName we are referring to the method inside the class of Students and since it doesnt have String we fill it up with that return value;
		System.out.println(s.getName());
		System.out.println(s.getAge());
		
		// basically encapsulation is just setters and getters. 
	}

}
