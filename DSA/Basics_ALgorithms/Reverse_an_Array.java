package Basics_ALgorithms;

import java.util.Arrays;

public class Reverse_an_Array {

	public static void main(String[] args) {
		
		int[] nums = {17,21,4,8,10,15,6};
		System.out.println(Arrays.toString(nums));
		int len = nums.length - 1;
		System.out.print("Original array: ");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.print("\nReversed array: ");
		for (int i = len; i >= 0; i--) {
			System.out.print(nums[i] +" ");
		}
		
		System.exit(0);
		
	}

}
