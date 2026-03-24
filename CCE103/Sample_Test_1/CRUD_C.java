package Sample_Test_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CRUD_C {
	private static final String fileName = "patients2.txt";
	private static File file = new File(fileName);

	ArrayList<Patient_M> patientList;
	public CRUD_C () {}
	public CRUD_C (ArrayList<Patient_M> patientList) {
		 this.patientList = patientList;
	}
	
	public void addRecords(Patient_M p) {
		patientList.add(p);
		saveToFile();
	}
	
	public void updateRecords(int index, Patient_M p) {
		patientList.set(index, p);
		saveToFile();
	}
	
	public void deleteRecords(int index) {
		patientList.remove(index);
		saveToFile();
	}
	
	public boolean isDuplicate(String id) {
		for (Patient_M p : patientList) {
			if (p.getId().equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}
	
	public void initFile() {
		try {
			if(!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public void saveToFile() {
		try {
			FileWriter fw = new FileWriter(fileName);
			for(Patient_M p : patientList) {
				fw.write(p.toFileString() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readFile() {
		patientList.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				Patient_M p = new Patient_M(
						split[0],
						split[1],
						split[2],
						split[3],
						split[4],
						split[5],
						split[6]
						);

				patientList.add(p);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
