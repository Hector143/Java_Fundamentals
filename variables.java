package variables;

public class variables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Hector";
		int age = 18;
		char gender = 'M';
		double height = 1.74;
		float weight = 54.78f;
		boolean isaPerson = true;
		
		if (isaPerson) {
			System.out.println("my name is: " + name);
			System.out.println("my age is: " + age);
			System.out.println("my gender is: " + gender);
			System.out.println("my height is: " + height + " meters");
			System.out.println("my weight is: " + weight + " kg");
			System.out.println("is "+name+ " a person? : " + isaPerson);
		}

	}

}
