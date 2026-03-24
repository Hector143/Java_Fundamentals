//package Another.Model;
//
//public class HardwareAsset extends Asset implements Maintainable {
//
//    public HardwareAsset(String assetId, String name, String category,
//                         String purchaseDate, double cost,
//                         String status, String location, String description) {
//
//        super(assetId, name, category, purchaseDate, location, status, cost, description);
//    }
//
//    // Override (Polymorphism)
//    @Override
//    public double calculateDepreciation() {
//        return getCost() * 0.20; // Hardware depreciates 20%
//    }
//
//    @Override
//    public void scheduleMaintenance() {
//        System.out.println("Maintenance scheduled for hardware asset.");
//    }
//}