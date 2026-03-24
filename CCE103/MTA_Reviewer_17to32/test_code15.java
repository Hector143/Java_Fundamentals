package MTA_Reviewer_17to32;

public class test_code15 {
	public static void main(String[] args) {
		int v = 5;
		int x = 10;
		int y = ++v * x--; // 6 * 10 = 60 
		System.out.println(y);
		int z = v-- + ++x; // 6 + 10 = 16
		System.out.println(z);
	}
}
