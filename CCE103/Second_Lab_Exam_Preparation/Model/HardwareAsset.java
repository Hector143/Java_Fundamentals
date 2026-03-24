package Second_Lab_Exam_Preparation.Model;

public class HardwareAsset extends Asset implements Maintainable{

	public HardwareAsset(String id, String name, String category, String purchaseDate, String inUse, String loc,
			double cost, String descript) {
		super(id, name, category, purchaseDate, inUse, loc, cost, descript);
	}

	public double calculateDepreciation() {
		return getCost() * 0.10; // default 10%
	}

	@Override
	public void scheduleMaintenance() {
		System.out.println("Hardware maintenance scheduled.");
	}
}
