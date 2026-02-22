package fasd;

public class methodsoverload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(5, 2));
		System.out.println(add(5, 2, 6));
		System.out.println(add(5.5, 2.6));

	}
	static double add(double num1, double num2) {
		return num1 + num2;
	}
	static int add(int num1, int num2) {
		return num1 + num2;
	}
	static int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	
	
}
