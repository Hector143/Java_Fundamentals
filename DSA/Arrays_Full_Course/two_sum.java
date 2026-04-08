package Arrays_Full_Course;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class two_sum {
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
		twoSum1(nums,target);
		System.out.println("Output: " + Arrays.toString(twoSum(nums,target)));
		
	}
	
	
//	 Brute Force Approach 		time complexity O(n^2)
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                	// returns the index of nums by getting the sum of 2 index in arrays;
                    return new int[] {i, j};
                }
            }
        }
        // returns the index of the two sum.
        return new int[] {};
    }
    
	// best solution and fastest and efficient and less than O(n^2) time complexity
    public static int[] twoSum1(int[] nums, int target) {
       Map<Integer, Integer> map = new HashMap<>();
       
       // iterate through array
         for (int i = 0; i < nums.length; i++) {
        	 // calculate the complement of the current number.
             int complement = target - nums[i];
             
             // check if the complement is already in the map.
             if (map.containsKey(complement)) { 
            	 // if found, return the indices of the complement and the current number.
            	 return new int[] {map.get(complement) , i};
             }
             // otherwise, add the current number and its index to the map.
             map.put(nums[i], i);
        }
         // Return an empty array if no solution is found (this case won't occur as per problem constraints).
         return new int[] {};
        }
    
}
