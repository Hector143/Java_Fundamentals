package fasd;

public class methodsummation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numbers[] = {1,2,9,6,8,1,3,4,5,6,4,3,4,5,2,6,1,5,3,1,3,4,8,8,7};
		int result = summation(numbers);
		System.out.println(result);
	}
	
	static int summation(int numbers[]) {
		int sum = 0;
		
		
		
		for (int number: numbers) {
			sum = sum + number;
		}
		return sum;
	}

}
