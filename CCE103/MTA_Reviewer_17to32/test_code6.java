package MTA_Reviewer_17to32;

public class test_code6 {

	public static void main(String[] args) {
		int timer = 60;
		
		while (timer >= 0) {
			if (timer == 0) {
				break;
			} else {
				System.out.println("The timer is counting down... " + timer);
				timer--;
			}
		}

	}

}
