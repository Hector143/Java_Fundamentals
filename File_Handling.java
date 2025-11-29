package File_Handling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File_Handling {
	// Using File Class we can handle Computer files.
	public static void FolderObject() {
		// Create a file type of any but we created a folder file and we need to import java.io.File.
		File files = new File("C:/Users/MCJUPI/Desktop/File Handling");
		files.mkdir();
		
	}
	
	public static void CheckFolderExist() {
		// check the existence of File
		File files = new File("C:/Users/MCJUPI/Desktop/File Handling");
//		files.mkdir();
		boolean a = files.exists();
		if (a == true) {
			System.out.println("Folder Exists");
					
		} else {
			System.out.println("Folder Not Exists");
		}
	}
	
	public static void DeleteFolder() {
		// Delete a folder named "File Handling" you can always change file name to be removed.
		File files = new File("C:/Users/MCJUPI/Desktop/File Handling");
		files.delete();
	}
	
	public static void CreateTextFile() {
		// Create text file   1st choice imports IO exception and throws exception to method
		// 2nd choice surround with try and catch 
		File files = new File("C:/Users/MCJUPI/Desktop/UFT.txt");
		try {
			files.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void DeleteTextFile() {
		// delete text file named "UFT.txt".
		File files = new File("C:/Users/MCJUPI/Desktop/UFT.txt");
		files.delete();
	}
	
	public static void ReadTextFile() throws IOException {
		// Reads the lines in console from file
		String line;
		FileReader file = new FileReader("C:/Users/MCJUPI/Desktop/bro Code full course.txt");
		BufferedReader br = new BufferedReader(file);
		
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		file.close();
		
	}
	
	// Assignment 
	
	// Read some Range of lines from a Text file
	
	// Example:
	// WE have 10 lines in a text file, you read 4 to 8 lines.
	
	
	public static void FileWriter() throws IOException {
		// writes a string or text inside a file.
		FileWriter writer = new FileWriter("C:/Users/MCJUPI/Desktop/Java is the best.txt");
		BufferedWriter bw = new BufferedWriter(writer);
		String data1 = "Write a file in java\n";
		String data2 = "Welcome to Java";
		bw.write(data1);
		bw.write(data2);
		bw.close();
	}
	
	public static void ReadWriteTextFile() throws IOException {
		String line;
		// read and write a file.
		FileReader file1 = new FileReader("C:/Users/MCJUPI/Desktop/welcome.txt");
		FileWriter file2 = new FileWriter("C:/Users/MCJUPI/Desktop/Java is the best.txt");
		// read and write a line.
		BufferedReader bfrd = new BufferedReader(file1);
		BufferedWriter bfwt = new BufferedWriter(file2);
		
		while ((line = bfrd.readLine()) != null) {
			bfwt.write(line);
			// writes newline by line in text file.
			bfwt.newLine();
			
		}
		
		bfwt.close();
		bfrd.close();
		
	}
	
	public static void main(String[] args) throws IOException {
		
		
		
		
	}
	
}
