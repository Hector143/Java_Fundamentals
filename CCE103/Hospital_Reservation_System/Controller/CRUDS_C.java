package Hospital_Reservation_System.Controller;

import java.io.*;
import java.util.ArrayList;

import Hospital_Reservation_System.Model.Patient_M;

public class CRUDS_C {

    private ArrayList<Patient_M> patientList;
    private static final String fileName = "patients.txt";
    
    public CRUDS_C() {
    	// default Constructor
    }
    
    public CRUDS_C(ArrayList<Patient_M> patientList) {
        this.patientList = patientList;
    }

    // add the model to the ArrayList<Patient_M>
    public void add(Patient_M p) {
        patientList.add(p);
        saveFile();
    }
    
    // for add and update only hehe :)
    public boolean isDuplicate(String id) {
    	for(Patient_M p : patientList){
    		if(p.getId().equalsIgnoreCase(id)){
    			return true;
    		}
    	}
    	return false;
    }
    

    // delete the selectedRow in table model
    public void delete(int index) {
        patientList.remove(index);
        saveFile();
    }

    // update selectedRow from table in model
    public void update(int index, Patient_M p) {
        patientList.set(index, p);
        saveFile();
    }

    // save model to file
    public void saveFile() {
        try{
        	FileWriter fw = new FileWriter(fileName);
            for(Patient_M p : patientList){
                fw.write(p.toFileString()+"\n");
            }
            fw.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }

    // load from file to model
    public void readFile(){
        patientList.clear();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine())!=null){
                String[] s = line.split("\\|");
                Patient_M p = new Patient_M(
                        s[0],
                        s[1],
                        Integer.parseInt(s[2]),
                        s[3],
                        s[4],
                        s[5],
                        s[6]
                );
                patientList.add(p);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}