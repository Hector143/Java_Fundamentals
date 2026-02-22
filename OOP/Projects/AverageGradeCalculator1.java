package Projects;

public class AverageGradeCalculator1 extends GradeCalculator1{

	@Override
	public double calculateAverage(double[] grades) {
		double total = 0;
		for (int i = 0; i < grades.length; i++) {
			total += grades[i];
		}
		return total / grades.length;
	
	}
	
}
