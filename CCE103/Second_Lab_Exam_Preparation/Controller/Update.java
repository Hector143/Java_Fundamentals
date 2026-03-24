package Second_Lab_Exam_Preparation.Controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Second_Lab_Exam_Preparation.Model.Asset;
import Second_Lab_Exam_Preparation.View.mainWindow;

public class Update {

    private mainWindow view;
    private ArrayList<Asset> assetList;

    public Update(mainWindow view, ArrayList<Asset> assetList) {
        this.view = view;
        this.assetList = assetList;
    }

    public void updateAsset() {
        String id = view.txtId.getText().trim();
        String name = view.txtName.getText().trim();
        String date = view.txtDate.getText().trim();
        String cost = view.txtCost.getText().trim();
        String desc = view.txtDescription.getText().trim();
        
        if (id.equals("") ||
        	name.equals("") ||
        	date.equals("") ||
        	cost.equals("") ||
        	desc.equals("") ) {
        	JOptionPane.showMessageDialog(null, "You must enter Asset ID!");
        	return;
        }
        if (!id.equals("")) {
        	for (Asset a : assetList) {
                if (a.getId().equals(id)) {
                    a.setName(view.txtName.getText());
                    a.setCategory(view.selectCategory.getSelectedItem().toString());
                    a.setPurchaseDate(view.txtDate.getText());
                    a.setLoc(view.checkLoc.getSelectedItem().toString());
                    a.setCost(Double.parseDouble(view.txtCost.getText()));
                    a.setDescript(view.txtDescription.getText());
                    if (view.checkStatus.isSelected()) {
                        a.setStatus("In Use");
                    } else {
                        a.setStatus("Available");
                    }
                    
                }
            }
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("assets.txt"));
            for (Asset a : assetList) {
                bw.write(a.toFileString());
                bw.newLine();
            }
            bw.close();
            JOptionPane.showMessageDialog(null, "Asset Updated!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Update Failed!");
        }
        clearFields();
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