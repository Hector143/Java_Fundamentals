package MTA_Reviewer_17to32;
import java.util.ArrayList;
public class test_code7 {
	public static void main(String[] args) {
		ArrayList<String> invoices = new ArrayList<>();
		invoices.add("Apple");
		invoices.add("Banana");
		invoices.add("Cantaloupe");
		invoices.add("Durian");
		System.out.println(invoices.toString());
		Process(invoices);
		System.out.println(invoices.toString());
	}
	public static void Process(ArrayList<String> invoices) {
		// correct
//		for (int i = invoices.size() - 1; i >= 0; i--) {
//			String invoice = invoices.get(i);
//			invoices.remove(i);
//		}
		// wrong
		for (int i = 0; i < invoices.size(); i++) { // 
			String invoice = invoices.get(i);
			invoices.remove(i);
		}
	}
}
