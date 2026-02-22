package OOP_Exercise_Problems.OOP_Problem_2;

public class Main1 {

	public static void main(String[] args) {
		Rectangle1 r = new Rectangle1(7, 12);
		
		System.out.println("The are of the rectangle is " + r.getArea());
		System.out.println("The perimeter of the rectangle is " + r.getPerimeter());
		
		r.setWidth(6);
		r.setHeight(12);
		
		System.out.println("\nThe are of the rectangle is now " + r.getArea());
		System.out.println("The perimeter of the rectangle is now " + r.getPerimeter());

	}

}
