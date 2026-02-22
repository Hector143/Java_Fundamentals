package OOP_Exercise_Problems.OOP_Problem_2;

public class Rectangle1 {
	
	private double width;
	private double height;
	
	public Rectangle1(double width, double height) {
		this.width = width;
		this.height = height;
	}
	
	
	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}

	public double getArea() {
		return width * height;
	}
	
	public double getPerimeter() {
		return 2 * (width + height);
	}

}
