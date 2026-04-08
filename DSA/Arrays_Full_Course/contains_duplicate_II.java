package Arrays_Full_Course;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class contains_duplicate_II {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		

	}
	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; ++i) {
			if (set.contains(nums[i])) return true;
			set.add(nums[i]);
			if(set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}

}
