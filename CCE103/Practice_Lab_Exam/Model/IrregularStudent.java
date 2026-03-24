package Practice_Lab_Exam.Model;

public class IrregularStudent extends Student{

	public IrregularStudent(String studentID, String studentName, String course, String yearLevel, String subject,
			byte midtermGrade, byte finalGrade, double finalAverage, String remarks) {
		super(studentID, studentName, course, yearLevel, subject, midtermGrade, finalGrade, finalAverage, remarks);
	}
	
	@Override
	public double calculateAverage(byte midtermGrade, byte finalGrade, double finalAverage) {
		finalAverage = (midtermGrade + finalGrade) / 2;
		return finalAverage;
	}
}
