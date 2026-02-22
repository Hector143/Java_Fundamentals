package Projects;

public class AverageGradeCalculator extends GradeCalculator {

	@Override
	public double calculateAverage(double[] grades) {
		double total = 0;
		for (int i = 0; i < grades.length; i++) {
			total += grades[i];
		}
		return total / grades.length;
	}
	
}
