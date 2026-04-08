package Level_3_Subarrays_and_Slightly_Tricky;

import java.util.Scanner;

public class CovertCamelCase {
	// Function to convert the given string to Camel Case
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String convertedString = convertToCamelCase(s);
		System.out.println(convertedString);
		sc.close();
	}
	public static String convertToCamelCase(String s) {
		StringBuilder sb = new StringBuilder();
		String[] split = s.split("\\s+");
		for (int i = 0; i < split.length; i++) {
			if (i != 0) {
				split[i] = split[i].substring(0,1).toUpperCase() + split[i].substring(1).toLowerCase();
			}
			sb.append(split[i]);
		}
		return sb.toString();

	}
}