package Second_Lab_Exam_Preparation.Controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import Second_Lab_Exam_Preparation.Model.Asset;
import Second_Lab_Exam_Preparation.View.mainWindow;

import java.io.BufferedReader;

public class Read {
	private ArrayList<Asset> assetList;
    private mainWindow view;
    public Read(mainWindow view, ArrayList<Asset> assetList) {
        this.view = view;
        this.assetList = assetList;
    }
	
    public void read() {
    	view.model.setRowCount(0);
    	try {
    		for (Asset a : assetList) {
    			view.model.addRow(new String[] {
    					a.getId(),
    				    a.getName(),
    				    a.getCategory(),
    				    a.getPurchaseDate(),
    				    Double.toString(a.getCost()),  // cost first
    				    a.getStatus(),
    				    a.getLoc(),
    				    a.getDescript()
    			});
    		}
    	} catch (Exception e) {
    		JOptionPane.showMessageDialog(null, 
					"Cannot Load File!", 
					"Error Message",
					JOptionPane.ERROR_MESSAGE);
    	}
    	
    	
    }
	public void loadFromFile() {
		assetList.clear();
		try {
			BufferedReader br = new BufferedReader(new FileReader("assets.txt"));
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("\\|");
				if (data.length == 8) {
					Asset a = new Asset(
							data[0],
							data[1],
							data[2],
							data[3],
							data[4],
							data[5],
							Double.parseDouble(data[6]),
							data[7]
					);
					assetList.add(a);
				}
			}
			br.close();
//			JOptionPane.showMessageDialog(null, "Successfull Load file!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, 
					"Cannot Load File!", 
					"Error Message",
					JOptionPane.ERROR_MESSAGE);
		}
		clearFields();
	}
	private void clearFields() {
        view.txtId.setText("");
        view.txtName.setText("");
        view.txtDate.setText("");
        view.txtCost.setText("");
        view.txtDescription.setText("");

        view.selectCategory.setSelectedIndex(0);
        view.checkLoc.setSelectedIndex(0);
        view.checkStatus.setSelected(false);
    }
}
