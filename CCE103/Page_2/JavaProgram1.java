package Page_2;

public class JavaProgram1 {
	int x = 25;
	public static void main(String[] args) {
		JavaProgram1 app = new JavaProgram1();
		{
			int x = 5;
		}
		{
			int x = 10;
		}
		int x = 100;
		System.out.println(x); // outputs 100
		System.out.println(app.x); // outputs 25
	}
	public JavaProgram1() {
		int x = 1;
		System.out.println(x); // outputs 1
	}

}
