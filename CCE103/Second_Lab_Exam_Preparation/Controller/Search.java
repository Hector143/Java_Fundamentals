package Second_Lab_Exam_Preparation.Controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Second_Lab_Exam_Preparation.Model.Asset;
import Second_Lab_Exam_Preparation.View.mainWindow;

public class Search {

    private mainWindow view;
    private ArrayList<Asset> assetList;

    public Search(mainWindow view, ArrayList<Asset> assetList) {
        this.view = view;
        this.assetList = assetList;
    }

    public void searchAsset(String keyword) {
        view.model.setRowCount(0);
        Read r = new Read(view, assetList);
        r.loadFromFile();
        String id = keyword.trim();
        for (Asset a : assetList) {
            if (a.getId().equals(id)) {
            	JOptionPane.showMessageDialog(null, "Asset Found!");
            	view.model.addRow(new Object[]{
                        a.getId(),
                        a.getName(),
                        a.getCategory(),
                        a.getPurchaseDate(),
                        a.getCost(),
                        a.getStatus(),
                        a.getLoc(),
                        a.getDescript()
                });
            	clearFields();
            	return;
            }
        }
        JOptionPane.showMessageDialog(null, "Asset Not Found!");
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
