package Projects;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		balance account = new balance();
		
		while (true) {
			System.out.println("\n[1] Deposit");
			System.out.println("[2] Withdraw");
			System.out.println("[3] Check Balance");
			System.out.println("[4] Exit");
			int option = scan.nextInt();
			
			switch (option) {
			case 1:
				System.out.println("Enter an amount to deposit: ");
				double despositAmount = scan.nextDouble();
				account.deposit(despositAmount);
				break;
			case 2:
				System.out.println("Enter an amount to withdraw: ");
				double withdrawAmount = scan.nextDouble();
				account.withdraw(withdrawAmount);
				break;
			case 3:
				account.checkBalance();
				break;
			case 4:
				System.out.println("Thank you for using the banking system");
				System.exit(0);
				
			default:
				break;
				
			}
		}

	}

}
