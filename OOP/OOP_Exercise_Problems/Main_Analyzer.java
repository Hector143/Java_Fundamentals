package OOP_Exercise_Problems;


public class Main_Analyzer {

	public static void main(String[] args) {
		Analyzer analyze = new Analyzer();
		String text = "";
		
		double[] input = analyze.inputPurchases();
		for (int i = 0; i < input.length; i++) {
			text += String.format("Customer %d: ₱%.1f - %s%n", (i+1), input[i] , analyze.getCategory(input[i]));
		}
		
		System.out.println("\n" + text);
		analyze.saveToFile(text);
		System.out.println("Saved reprot to customer_report.txt");
		
		
		

	}

}
