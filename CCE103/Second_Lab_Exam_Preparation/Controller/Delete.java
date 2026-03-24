package Second_Lab_Exam_Preparation.Controller;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Second_Lab_Exam_Preparation.Model.Asset;
import Second_Lab_Exam_Preparation.View.mainWindow;

public class Delete {
	private ArrayList<Asset> assetList;
	private mainWindow view;
	public Delete(mainWindow view, ArrayList<Asset> assetList) {
		this.view = view;
		this.assetList = assetList;
	}

	public void deleteAsset() {
		int selectedRow = view.table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(null, "Please select a row to delete.");
			return;
		}
		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        //System.out.println(confirm);
        if (confirm != JOptionPane.YES_OPTION) return;

		String id = view.model.getValueAt(selectedRow, 0).toString();

		Asset assetToRemove = null;
	    for (Asset a : assetList) {
	        if (a.getId().equals(id)) {
	            assetToRemove = a;
	            break;
	        }
	    }
	    if (assetToRemove != null) {
	        assetList.remove(assetToRemove);
	    }
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("assets.txt"));

			for (Asset a : assetList) {
	            bw.write(a.toFileString());
	            bw.newLine();
	        }
	        bw.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error Updating File!");
		}
		view.model.removeRow(selectedRow);
		clearFields();
		JOptionPane.showMessageDialog(null, "Asset Deleted Successfully!");
		Read r = new Read(view, assetList);
		r.read();
		
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
