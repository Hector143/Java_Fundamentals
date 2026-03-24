package Student_Record_System.Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Student_Record_System.Model.Student_M;

public class File_Handling_C {
	private static final String fileTranscript = "transcript.txt";
	private static final String fileRecords = "student_records.txt";
	public static File file1 = new File(fileTranscript);
	public static File file2 = new File(fileRecords);
	private static ArrayList<Student_M> studentList;
	
	public File_Handling_C() {/* Default Constructor */}
	public File_Handling_C(ArrayList<Student_M> studentList) {
		this.studentList = studentList;
	}

	public void add(Student_M student) {
		studentList.add(student);
		saveToFile();
	}
	public void delete(int index) {
		studentList.remove(index);
		saveToFile();
	}

	public void initFile() {
		try {
			if(!file1.exists()) {
				file1.createNewFile();
			}
			if(!file2.exists()) {
				file2.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveToFile() {
		try {
			FileWriter fw = new FileWriter(fileRecords);
			for (Student_M s : studentList) {
				fw.write(s.toFileString() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void readFromFile() {
		studentList.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileRecords));
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				Student_M s = new Student_M(
						split[0],
						split[1],
						split[2],
						split[3],
						Integer.parseInt(split[4]),
						Integer.parseInt(split[5]),
						Integer.parseInt(split[6]),
						Integer.parseInt(split[7]),
						Integer.parseInt(split[8]),
						Integer.parseInt(split[9]),
						Integer.parseInt(split[10]),
						Integer.parseInt(split[11]),
						split[12]		
						);
				studentList.add(s);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isDuplicate(String id) {
		try {
			for (Student_M s : studentList) {
				if (s.getStudentId().equals(id)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


}
