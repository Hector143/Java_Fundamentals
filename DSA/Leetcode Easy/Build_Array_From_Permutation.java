package Easy;

import java.util.Arrays;
import java.util.Scanner;

public class Build_Array_From_Permutation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n = scan.nextInt();
		
		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = scan.nextInt(); 
		}
		scan.nextLine();
		scan.close();
		System.out.println("Original Array: " + Arrays.toString(nums));
		System.out.println("Permutated Array: " + Arrays.toString(buildArray(nums)));
	}


	public static int[] buildArray(int[] nums) {
		int[] ans = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			ans[i] = nums[nums[i]];
		}
		return ans;
	}

}
