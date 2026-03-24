package MTA_Reviewer_17to32;

public class test_code4 {

	public static void main(String[] args) {
		String firstName = "Christopher"; // Christopher
		firstName = firstName.substring(0,5); // converts Christopher to Chris 
		String output = String.format("%s is %d characters long.",
				firstName, firstName.length()); 
		System.out.println(output); // Console: Christ is 5 characters long.
	}

}
