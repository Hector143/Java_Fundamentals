package Interfaces.Problems_Projects;

public class Circle implements Shape {
	 // Private instance variable to store the radius of the circle.
	 private double radius;

	 // Constructor for creating a Circle object with a given radius.
	 public Circle(double radius) {
	     this.radius = radius;
	 }

	 // Implementation of the 'getArea' method as required by the 'Shape' interface.
	 @Override
	 public double getArea() {
	     // Calculate and return the area of the circle using the formula: π * r^2.
	     return Math.PI * radius * radius;
	 }
}
