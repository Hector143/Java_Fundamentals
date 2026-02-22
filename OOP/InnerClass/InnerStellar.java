package InnerClass;

class Outside {
	int a = 0; 
	
	
	class Inside {
		int b = 5;
	}
}
public class InnerStellar {

	public static void main(String[] args) {
		Outside o = new Outside();
		// accessing inner class from outside object 
		Outside.Inside i = o.new Inside();
		// now we have inside object using inside class from outside object of outside class. hehe i hope you understand.
		System.out.println("The number inside the 'Inside' Class " + o.a + " " + i.b);
	}

}
