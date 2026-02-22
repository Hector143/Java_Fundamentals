package AccessModifiers;

public class Access1 {
	
	// 4 types of access modifiers
	// default, public, private and protected
	// default means when you dont do anything. Default gives accss to everything inside the package but cant see in other packages.
	// public, you can access acrros packages or folder we can do it outside the pacakges.
	// private, is only have access inside its own class or class itself. or itself file.
	// protected is only accessible inside a package or folder and canot be accessed in other packages.
	
	protected int days = 2;
	protected int hours = 3;
	protected int minutes = 47;
	protected int seconds = 25;
	
	public void getAccess() {
		System.out.println("You have access");
	}
	
	int getDays() {
		return days;
	}
	public int getHours() {
		return hours;
	}
	private int getMinutes() {
		return minutes;
	}
	protected int getSeconds() {
		return seconds;
	}
	
}
