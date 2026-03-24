package Hospital_Reservation_System.Model;

public class Patient_M {
	
	/* needs to fix */
	// Model be called for file handling and table model
	
	private String id;
	private String fullName;
	private int age;
	private String gender;
	private String contactNum;
	private String date;
	private String diagnosis;
	
	public Patient_M() {
		// 
	}
	
	public Patient_M(String id, String fullName, int age, String gender, String contactNum, String date,
			String diagnosis) {
		setId(id);
		setFullName(fullName);
		setAge(age);
		setGender(gender);
		setContactNum(contactNum);
		setDate(date);
		setDiagnosis(diagnosis);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNum() {
		return contactNum;
	}
	public void setContactNum(String contantNum) {
		this.contactNum = contantNum;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	// this must be used in Controllers
	/** this is for File Handling **/
	public String toFileString() {
		return id + "|" + fullName + "|" + 
				age + "|" + gender + "|" +
				contactNum + "|" + date + "|" +
				diagnosis ;
	}
	// this must be used in VIew
	/** this is for Data Table Model **/
	public String[] getInfo() {
		String[] info = {getId(), getFullName(), Integer.toString(getAge()),
				getGender(), getContactNum(), getDate(), getDiagnosis()};
		return info;
	}


}
