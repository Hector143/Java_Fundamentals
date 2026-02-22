package Examples_Methods;

import java.util.Scanner;

public class dontTrustThisIdiotMethods {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // use only if need inputs sa main method.
		UserInput();// better way
		
		scan.close(); // only use it for your own good.
	}
	
	public static void UserInput() {
		// pointless kay no need na mag scanner sa main method if dili ka mag input sa main.
		Scanner sc = new Scanner(System.in);
		
		// and its not really no need close the scanner unless if it is required. pero mas better para dili mag leak ang code.
	}
	

}
