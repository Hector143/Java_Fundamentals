package Level_1_Basic_Array_Manipluation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class three_sum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("How many elements in the array? ");
		int n = scan.nextInt(); scan.nextLine();
		System.out.print("target: ");
		int target = scan.nextInt(); scan.nextLine();
		
		int[] nums = new int[n];
		
		for (int i = 0; i < nums.length; i++) {
			System.out.print("Element ["+ i + "]: ");
			nums[i] = scan.nextInt();scan.nextLine();
		}
		System.out.println(Arrays.toString(nums));
		System.out.println();
		scan.close();
		threeSum(nums,target);
		System.out.println("Output: " + Arrays.toString(threeSum(nums,target)));
		
	}
	
	
//	 Brute Force Approach 		time complexity O(n^3)
    public static int[] threeSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
            	for (int k = j + 1; k < nums.length; k++) {
            		if (nums[i] + nums[j] + nums[k] == target) {
                    	// returns the index of nums by getting the sum of 2 index in arrays;
            			System.out.println("Because " + nums[i] + " + " + nums[j] + " + " + nums[k] + " = " + target);
            			return new int[] {i, j, k};
                        
                    }
            	}
            }
        }
        // returns the index of the two sum.
        return new int[] {};
    }
    
	// best solution and fastest and efficient and less than O(n^2) time complexity
    
}
