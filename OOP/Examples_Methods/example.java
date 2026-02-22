package Examples_Methods;

import java.util.Arrays;

public class example {

	public static void main(String[] args) {
//		example ex = new example(); // this is an object of our own class
		// example of pre-defined methods is
		
//		int[] arr = {1, 3, 5, 4, 10};
//		
//		Arrays.sort(arr); // . operation is the pre defined keyword/ method because it is already in java.
		
//		noReturnValue();
		
		int x = 6;
		int y = 8;
		int z = 10;
		int a = 2;
		System.out.println(sum(x, y)); // output 14
		System.out.println(sum(x, y, z)); // ouptut 24
		System.out.println(sum(x, y, z, a)); // output 26
		// x and y is our parameters in method but it still works even if different ang parameter name
		// as long as same ang data type like int then it still works somehow.
		//to execute the method with parameters need natu i butang ang values na need sa parameters.
		
		
		// wala siya output its because gi return niya ang value
		
		// but we forgot to print it. right?
	}
	// while user defined methods is
	// when the user will define it or create or make the action
	
	// there are 2 types of user defined methods.
	
	// first is void or no returning value.
	
	public static void noReturnValue() { // pwede ra i copy paste
		System.out.println("I dont return anything.");
		// it doesnt run unless if it is called in the main method.
		// kay diba all methods dont execute if not called in the main method.
	}
	
	
	// 2nd with returning values. 
	
	// example
	public static int sum(int x, int y) { // this values are empty or are undefined or dont know. 
		// lets say naa tay gi calculate na addition so we need values from main method to pass with.
		// dont worry if nag red ang imo method its normal
		// because wala paman ta nag return ug values.
		// first we create our int value so we can return it.
		// since gi initialize naman nato si x and si y we can call it instantly.
//		return x += y; // faster way
		
		
		int sum = x + y; // dynamic 
		return sum; // good habit
	}
	
	
	// another example
	public static void noReturn(int x, int y) {
		// since no returning value 
		
		// pwede giahpon niya ma access si x and y pero 
		// dili siya maka return ug value same with the int before.
		
		System.out.println(x + y);
		// output should be 14;
	}
	
	// so when to use methods?
	
	// use void when u dont return the values or kung dili nimo necessary ang iyahang values 
	// use returning values if need nimo ang sum, average, total, or mga categorization sa mga values or depende sa word problems.

	// also i think na confuse pud mo why there is public and static always right?
	// il show you why.
	
	
	// method overloading
	
	// so what is method overloading?
	// method overloading is using the same name of method but different parameters.
	
	// for example : the sum method.
	public static int sum(int x, int y, int z) {
		return x + y + z;
		// output should be 24;
	}
	
	public static int sum(int annoying, int y, int z, int a) {
		return annoying + y + z + a;
		// output should be 26;
	}
}
