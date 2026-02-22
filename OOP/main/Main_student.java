package main;
import java.util.Scanner;

public class Main_student {

	public static void main(String[] args) {
		student s = new student("Hector Josh","Salera ","Bachelor of Science in Information and Technology", "1", "IT-30" , 92.45f, 91.24f);
		student s1 = new student("Andrey","Gadia ","Bachelor of Science in Information and Technology", "2", "IT-20" , 94.15f, 93.29f);
		
		
//		s.introduceSelf();
		s.evaluateGrade();
		
//		s1.introduceSelf();
		
		s1.evaluateGrade();
		
	}
}
