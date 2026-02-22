package Encapsulation;

public class Main_encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		student student1 = new student(563565, "hector", "salera", 'M');
		
		System.out.println(student1.getStudentFirstName());
		System.out.println(student1.getStudentLastName());
		System.out.println(student1.getStudentID());
		System.out.println(student1.getStudentGender());
		
		// setting the variables
		
		student1.setStudentFirstName("Drekthar");
		student1.setStudentLastName("Rick");
		student1.setStudentGender('M');
		student1.setStudentID(538565);
		
		// printing the getters from setter
		
		System.out.println(student1.getStudentFirstName());
		System.out.println(student1.getStudentLastName());
		System.out.println(student1.getStudentID());
		System.out.println(student1.getStudentGender());
		

	}

}
