package Sample_Test_1;

public class Patient_M {
	private String id;
	private String fullName;
	private String age;
	private String gender;
	private String contactNo;
	private String admissionDate;
	private String diagnosis;
	public Patient_M(String id, String fullName, String age, String gender, String contactNo, String admissionDate,
			String diagnosis) {
		setId(id);
		setFullName(fullName);
		setAge(age);
		setGender(gender);
		setContactNo(contactNo);
		setAdmissionDate(admissionDate);
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	
	public String toFileString() {
		return id +"|" + fullName + "|" + 
				age +"|" + gender + "|" + 
				contactNo +"|" + admissionDate + "|" + 
				diagnosis;
	}
	
	public String[] getFileInfo() {
		String[] info = {getId(), getFullName(), getAge(), getGender(),
				getContactNo(), getAdmissionDate(), getDiagnosis()};
		return info;
	}
	
	
	
}
