package This_Keyword;

public class ThisIsFun {
	// Global Variable
	int x; // only be used or called using 'this' keyword or by implementing static.
	int y;
	
	// if you dont wnat to use this. you can renmae the variable name to other 
	// example int a, int b instead of int x, int y so in method setData so this.a = x; something like that.
	
	String food;
	char size;
	
	
	public void setData(int x, int y) { // x is 4 and y is 3
		this.x = x; // the keyword this means the class name you called this.x is the int x inside the class ThisIsFun
		this.y = y; // the keyword menas the class name calling this.y is the int y inside the class ThisIsFun
		// the reason why this. keyword exist is not because it is just for convenience
		// and its really convenient 
		

	}
	// we use method overloading so that we can use same name but different paramters.
	public void setData(String food, char size) {
		this.food = food;
		this.size = size;
	}
	

	public static void main(String[] args) {
		// make an object of our class named t
		ThisIsFun t = new ThisIsFun();
		t.setData("soup", 'L');
		t.setData(4, 3);
		System.out.println(t.x);
		System.out.println(t.y);
		
		System.out.println(t.food);
		System.out.println(t.size);

	}

}
