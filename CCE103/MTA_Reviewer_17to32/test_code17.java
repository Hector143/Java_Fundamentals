package MTA_Reviewer_17to32;

public class test_code17 {
	public static void main(String[] args) {
		// Initially, s1 and s2 point to the same object in the string pool
        String s1 = "hello";
        String s2 = s1;
        String s3 = s2;

        s1 = "world"; // a different string can be assigned to s1
        s2 = "java"; // a different string can be assigned to s2
        
        // so can a different String 
        // be assigned to s1 and s2?
        // answer is true.
        
	}
}
