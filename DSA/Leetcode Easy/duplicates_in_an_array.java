package Easy;

import java.util.HashSet;

public class duplicates_in_an_array {

	public static void main(String[] args) {


		int[] arr = {3, 5, 2, 4, 1};
		
		// 1st solution
		boolean duplicates = false;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					duplicates = true;
					break;
				} 
			}
			if (duplicates) {
				break; // break the outer loop
			}
		}
		
		System.out.println(duplicates);
		
		
		// 2nd solution
//		Arrays.sort(arr);
//		
//		boolean duplicate = false;
//		for (int i = 0; i < arr.length - 1; i++) {
//			if (arr[i] == arr[i+1]) {
//				duplicate = true;
//				break;
//			}
//		}
//		
//		System.out.println(duplicate);
		
		// solution 3 execute
		
//		boolean duplicate = containsDuplicate(arr);
//		System.out.println(duplicate);
		

	}
	
	// solution 3: using HashSet (this is better because it has time complexity of O(n).
	
	public static boolean containsDuplicate(int[] arr) {
		// Create a HashSet to store elements from the array
		HashSet<Integer> seenNumbers = new HashSet<>();
		
		// Iterate through each element in the array
		for (int num : arr) {
			// Check if the element is already in the HashSet
			if (seenNumbers.contains(num)) {
				return true; // duplicate found
			}
			// Add the element to the HashSet
			seenNumbers.add(num);
		}
		
		return false; // No duplicates found
	}
}
