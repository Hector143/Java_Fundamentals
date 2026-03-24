package Page_2;

import java.util.Scanner;

public class Question_6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner("1 Excellent 2 Good 3 Fair 4 Poor");
		Object data1 = sc.next(); 
		Object data2 = sc.next(); 
		Object data3 = sc.nextInt(); 
		Object data4 = sc.nextLine(); 
		
		System.out.println(data1); // 1
		System.out.println(data2); // Excellent
		System.out.println(data3); // 2
		System.out.println(data4); // Good 3 Fair 4 Poor
		sc.close();
	}

}
