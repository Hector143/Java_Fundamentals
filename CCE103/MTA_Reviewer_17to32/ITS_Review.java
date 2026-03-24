package MTA_Reviewer_17to32;

public class ITS_Review {
	static int extra = 500;
	public static int changeScore(int score, Boolean bonus, int extra) {
		if (bonus == true) {
			score += extra;
		}
		return score;
	}
	
	public static void main(String[] args) {
		Boolean bonus = true;
		int score = 10;
		int newScore = changeScore(score, bonus, 100);
		System.out.println(score);
		System.out.println(newScore);

	}

}
