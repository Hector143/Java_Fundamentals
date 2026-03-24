package Departmental_Exam_Redo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Controllers_C {
	public static final String fileName = "product.txt";
	public static File file = new File(fileName);
	public ArrayList<Product_M> productList;
	
	// default Constructor
	public Controllers_C() {
		
	}
	
	// overload constructor
	public Controllers_C(ArrayList<Product_M> productList) {
		this.productList = productList;
	}
	
	public void initFile() {
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void saveToFile() {
		try {
			FileWriter fw = new FileWriter(fileName);
			for (Product_M p : productList) {
				fw.write(p.toFileString() + "\n");
			}
			fw.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public void readFromFile() {
		productList.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while ((line = br.readLine()) != null) {
				String[] split = line.split("\\|");
				Product_M p = new Product_M(
						split[0],
						split[1],
						split[2],
						split[3],
						split[4],
						split[5],
						split[6]
						);
				productList.add(p);
			}
			br.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean isDuplicate(String id) {
		for (Product_M p : productList) {
			if(p.getProductId().equalsIgnoreCase(id)) {
				return true;
			}
		}
		return false;
	}
	
	public void addProduct(Product_M p) {
		productList.add(p);
		saveToFile();
	}
	
	public void updateProduct(int index, Product_M p) {
		productList.set(index, p);
		saveToFile();
	}
	
	public void deleteProduct(int index) {
		productList.remove(index);
		saveToFile();
	}
	
}
