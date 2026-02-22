package Constructors;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student stud = new student("Spongebob", 20, 3.14);
		student stud1 = new student("Patrick", 21, 2.50);
		student stud2 = new student("Jerry", 10, 2.13);
//		System.out.println(stud.name);
//		System.out.println(stud.age);
//		System.out.println(stud.gpa);
//		System.out.println(stud.isEnrolled);
//		System.out.println();
//		System.out.println(stud1.name);
//		System.out.println(stud1.age);
//		System.out.println(stud1.gpa);
//		System.out.println(stud1.isEnrolled);
		
		stud.study();
		stud1.sleeping();
		stud2.eating();
		
		
		
	}

}
