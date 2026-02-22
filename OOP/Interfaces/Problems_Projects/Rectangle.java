package Interfaces.Problems_Projects;

//Rectangle.java
//This is the 'Rectangle' class that implements the 'Shape' interface.

public class Rectangle implements Shape {
 // Private instance variables to store the dimensions of the rectangle.
 private double length;
 private double width;

 // Constructor for creating a Rectangle object with given length and width.
 public Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 // Implementation of the 'getArea' method as required by the 'Shape' interface.
 @Override
 public double getArea() {
     // Calculate and return the area of the rectangle.
     return length * width;
 }
}
//Circle.java
//This is the 'Circle' class that implements the 'Shape' interface.


//Triangle.java
//This is the 'Triangle' class that implements the 'Shape' interface.




