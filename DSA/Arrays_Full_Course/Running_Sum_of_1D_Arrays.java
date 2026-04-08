package Arrays_Full_Course;

import java.util.Arrays;

public class Running_Sum_of_1D_Arrays {

	public static void main(String[] args) {
		int nums[] = {1,2,3,4};
		System.out.println("Arrays before: " + Arrays.toString(nums));

		System.out.println("Arrays After: " + Arrays.toString(runningSum(nums)));
		
	}
	
	public static int[] runningSum(int[] nums) {
		int[] runningSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                 sum += nums[j];
                
            }
            runningSum[i] = sum;
        }
        return runningSum;
    }
}
