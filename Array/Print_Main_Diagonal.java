package Array;

import java.util.Scanner;

public class Print_Main_Diagonal {

	public static void main(String[] args) {
		//  
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter row: ");
		int row = scan.nextInt();
		System.out.print("Enter column: ");
		int column = scan.nextInt();
		
		int[][] arr = new int[row][column];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print("Enter element [" + i + "][" + j +"]: ");
				arr[i][j] = scan.nextInt();
			}
		}
		
		System.out.println("Column-wise Traversal: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (arr[i][i] == arr[i][j]) 
				System.out.print(arr[j][i] + " ");
			}
			
		}
		scan.close();

	}

}
