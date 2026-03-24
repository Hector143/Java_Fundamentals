package Second_Lab_Exam_Preparation.Controller;

import Second_Lab_Exam_Preparation.View.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import Second_Lab_Exam_Preparation.Model.*;

public class Create {

	public mainWindow view;
	private ArrayList<Asset> assetList;

	public Create(mainWindow view, ArrayList<Asset> assetList) {
		this.view = view;
		this.assetList = assetList;
	}

	public void saveToFile() {
		try {
			String status = null;
			if (view.checkStatus.isSelected()) {
				status = "In Use";
			} else {
				status = "Available";
			}
			Asset a;
			
			String category = view.selectCategory.getSelectedItem().toString();
			if (category.equals("Desktop") || category.equals("Laptop") || category.equals("Macbook")) {
				a = new HardwareAsset(
						view.txtId.getText(),
						view.txtName.getText(),
						category,
						view.txtDate.getText(),
						status,
						view.checkLoc.getSelectedItem().toString(),
						Double.parseDouble(view.txtCost.getText()),
						view.txtDescription.getText()
						);
			} else {
				a = new VehicleAsset(
						view.txtId.getText(),
						view.txtName.getText(),
						category,
						view.txtDate.getText(),
						status,
						view.checkLoc.getSelectedItem().toString(),
						Double.parseDouble(view.txtCost.getText()),
						"No Description"
						);
			}
			assetList.add(a);

			BufferedWriter bw = new BufferedWriter(new FileWriter("assets.txt", true));
			bw.write(a.toFileString());
			bw.newLine();
			bw.close();
			clearFields();
			JOptionPane.showMessageDialog(null, "Asset Added Successfully!");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cannot Create!" ,"Error Message", JOptionPane.ERROR_MESSAGE);
		}
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
