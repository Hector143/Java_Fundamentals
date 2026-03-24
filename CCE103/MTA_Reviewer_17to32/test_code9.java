package MTA_Reviewer_17to32;

public class test_code9 {
	public static void main(String[] args) {
		int anum = 55;
		for(int cnt = 0; cnt < 10; cnt++) {
			add(anum);
		}
		System.out.println(anum);
	}
	
	public static void add(int anum) {
		anum++;
	}
}
