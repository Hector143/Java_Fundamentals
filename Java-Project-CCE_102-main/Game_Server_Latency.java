package Projects_FileHandling;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
 
public class Game_Server_Latency {
 
 
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		File file = new File("server_status.txt");
		initFile(file);
		
		int[] pingArray = inputPingValues(scan);
		String catConnect = categorizeConnection(pingArray);
		saveToFile(file, catConnect);
		scan.close();
		
	}
	
	public static int[] inputPingValues(Scanner scan) {
		System.out.print("How many servers to test? ");
		int servers = scan.nextInt();
		scan.nextLine();
		System.out.println();
		
		int[] ping = new int[servers];
		for (int i = 0; i < ping.length; i++) {
			System.out.print("Enter ping for Server " + (i+1) + ": ");
			ping[i] = scan.nextInt();
			scan.nextLine();
		}
		System.out.println();
		return ping;
	}
	
	public static String categorizeConnection(int[] ping) {
		String data = "";
		System.out.println("--- SERVER REPORT ---");
		for (int i = 0; i < ping.length; i++) {
			if (ping[i] > 150) {
				data += "Server " + (i+1) + ": " + ping[i] + " ms - Laggy (Unstable)\n";
			} else if (ping[i] >= 50) {
				data += "Server " + (i+1) + ": " + ping[i] + " ms - Good (Playable)\n";
			} else {
				data += "Server " + (i+1) + ": " + ping[i] + " ms - Excellent (Competitive)\n";
			}
		}
		System.out.println(data);
		return data;
	}
	
	public static void initFile(File file) {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			System.out.println("Error " + e );
		}
	}
	
	public static void saveToFile(File file, String text) {
		try {
			FileWriter writer = new FileWriter(file, true);
			writer.write(text);
			writer.close();
			System.out.println("Report saved to server_status.txt");
		} catch (Exception e) {
			System.out.println("Something went wrong!");
		}
	}
 
 
}
 