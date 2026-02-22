package AccessModifiers;
import AccessModifiers2.Access3;
public class Access2 {

	public static void main(String[] args) {
		Access1 a = new Access1();
		System.out.println(a.days);
		System.out.println(a.hours);
		System.out.println(a.minutes);
		System.out.println(a.seconds);
		
		Access3 b = new Access3();
		System.out.println(b.days);
		System.out.println(b.hours);
		System.out.println(b.minutes);
		System.out.println(b.seconds);
	}

}
