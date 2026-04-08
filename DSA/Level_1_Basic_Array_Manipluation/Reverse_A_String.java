package Level_1_Basic_Array_Manipluation;

public class Reverse_A_String {

	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(reverseString(s));
	}
	public static String reverseString(String s) {
		// code here
		String ReverseS = "";
		for (int i = s.length()-1; i >= 0; i--) {
			ReverseS += s.charAt(i);
		}

		return ReverseS;
	}

}
