package Student_Record_System.Model;

public class Transcript_M extends Student_M{
	
	public Transcript_M(String studentId, String firstName, String lastName, String courseCode, int mathematic,
			int english, int biology, int infoTech, int chemistry, int physic, int totalScore, int average,
			String ranking) {
		super(studentId, firstName, lastName, courseCode, mathematic, english, biology, infoTech, chemistry, physic, totalScore,
				average, ranking);
	}

	
}
