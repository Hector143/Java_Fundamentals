package Interfaces.Problems_Projects;

//Main.java
//Main class that creates objects of Rectangle, Circle, and Triangle
public class Main {
	 public static void main(String[] args) {
	     // Create a Rectangle object with length=10 and width=12
	     Rectangle rectangle = new Rectangle(10, 12);
	     
	     // Create a Circle object with radius=3
	     Circle circle = new Circle(3);
	     
	     // Create a Triangle object with base=4 and height=6
	     Triangle triangle = new Triangle(4, 6);

	     // Print the area of the Rectangle
	     System.out.println("Area of the Rectangle: " + rectangle.getArea());
	     
	     // Print the area of the Circle
	     System.out.println("Area of the Circle: " + circle.getArea());
	     
	     // Print the area of the Triangle
	     System.out.println("Area of the Triangle: " + triangle.getArea());
	 }
}