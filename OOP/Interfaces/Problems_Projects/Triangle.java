package Interfaces.Problems_Projects;

public class Triangle implements Shape {
	 // Private instance variables to store the base and height of the triangle.
	 private double base;
	 private double height;

	 // Constructor for creating a Triangle object with a given base and height.
	 public Triangle(double base, double height) {
	     this.base = base;
	     this.height = height;
	 }
	 
	 // Implementation of the 'getArea' method as required by the 'Shape' interface.
	 @Override
	 public double getArea() {
	     // Calculate and return the area of the triangle using the formula: 0.5 * base * height.
	     return 0.5 * base * height;
	 }
}
