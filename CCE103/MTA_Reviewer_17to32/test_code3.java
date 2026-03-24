package MTA_Reviewer_17to32;

public class test_code3 {

	public static void main(String[] args) {
		String[][] board = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
		traverse(board);
	}
	
	public static void traverse(String[][] board) { 
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[x].length; y++) {
				System.out.println(board[x][y]);
			}
		}
	}

}
