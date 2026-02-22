package OOP_Exercise_Problems.OOP_Problem_2;

public class Main2 {

	public static void main(String[] args) {
		Circle2 c = new Circle2(5);
		
		System.out.println("Radius of the circle is " + c.getRadius());
		System.out.println("The area of the circle is " + c.getArea());
		System.out.println("The circumference of the circle is " + c.getCircumference());
		
		c.setRadius(8);
		
		System.out.println("\nRadius of the circle is " + c.getRadius());
		System.out.println("The area of the circle is now " + c.getArea());
		System.out.println("The circumference of the circle is now " + c.getCircumference());
		
		
		

	}

}
