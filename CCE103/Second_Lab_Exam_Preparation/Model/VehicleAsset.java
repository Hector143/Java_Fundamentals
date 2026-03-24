package Second_Lab_Exam_Preparation.Model;

public class VehicleAsset extends Asset implements Maintainable{

	public VehicleAsset(String id, String name, String category, String purchaseDate, String inUse, String loc,
			double cost, String descript) {
		super(id, name, category, purchaseDate, inUse, loc, cost, descript);
		// TODO Auto-generated constructor stub
	}

	@Override
    public double calculateDepreciation() {
        return getCost() * 0.30; // 30% for vehicles
    }

    @Override
    public void scheduleMaintenance() {
        System.out.println("Vehicle maintenance scheduled.");
    }
}
