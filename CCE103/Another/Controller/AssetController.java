//package Another.Controller;
//
//import Another.Model.*;
//import Another.View.AssetView;
//
//import java.awt.event.*;
//import java.util.ArrayList;
//
//public class AssetController {
//
//    private AssetView view;
//    private ArrayList<Asset> assetList;
//
//    public AssetController(AssetView view) {
//        this.view = view;
//        loadAssets();
//
//        view.btnAdd.addActionListener(e -> addAsset());
//        view.btnUpdate.addActionListener(e -> updateAsset());
//        view.btnDelete.addActionListener(e -> deleteAsset());
//        view.btnSearch.addActionListener(e -> searchAsset());
//    }
//
//    // LOAD DATA INTO TABLE
//    private void loadAssets() {
//        assetList = AssetFileHandler.readAssets();
//        refreshTable(assetList);
//    }
//
//    // REFRESH TABLE
//    private void refreshTable(ArrayList<Asset> list) {
//        view.tableModel.setRowCount(0);
//
//        for (Asset a : list) {
//            view.tableModel.addRow(new Object[]{
//                    a.getId(),
//                    a.getName(),
//                    a.getCategory(),
//                    a.getPurchaseDate(),
//                    a.getInUse(),
//                    a.getCost(),
//                    a.getLoc(),
//                    a.getDescript()
//            });
//        }
//    }
//
//    // ADD
//    private void addAsset() {
//
//        Asset asset = new Asset(
//                view.txtId.getText(),
//                view.txtName.getText(),
//                view.txtCategory.getText(),
//                view.txtDate.getText(),
//                Double.parseDouble(view.txtCost.getText()),
//                view.txtStatus.getText(),
//                view.txtLocation.getText(),
//                view.txtDescription.getText()
//        );
//
//        AssetFileHandler.addAsset(asset);
//        loadAssets();
//    }
//
//    // UPDATE
//    private void updateAsset() {
//
//        String id = view.txtId.getText();
//
//        for (Asset a : assetList) {
//            if (a.getId().equals(id)) {
//
//                a.setName(view.txtName.getText());
//                a.setCategory(view.txtCategory.getText());
//                a.setPurchaseDate(view.txtDate.getText());
//                a.setCost(Double.parseDouble(view.txtCost.getText()));
//                a.setStatus(view.txtStatus.getText());
//                a.setLocation(view.txtLocation.getText());
//                a.setDescription(view.txtDescription.getText());
//
//                break;
//            }
//        }
//
//        AssetFileHandler.writeAssets(assetList);
//        loadAssets();
//    }
//
//    // DELETE
//    private void deleteAsset() {
//
//        String id = view.txtId.getText();
//
//        assetList.removeIf(a -> a.getId().equals(id));
//
//        AssetFileHandler.writeAssets(assetList);
//        loadAssets();
//    }
//
//    // SEARCH
//    private void searchAsset() {
//
//        String keyword = view.txtSearch.getText().toLowerCase();
//        ArrayList<Asset> filtered = new ArrayList<>();
//
//        for (Asset a : assetList) {
//            if (a.getId().toLowerCase().contains(keyword) ||
//                a.getName().toLowerCase().contains(keyword)) {
//
//                filtered.add(a);
//            }
//        }
//
//        refreshTable(filtered);
//    }
//}