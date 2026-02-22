package Encapsulation;


// encapsulation means getters and setters hiding the information.
// na gets mo?
// okay!
public class Encap { // this is what we called class or classes
	private String name;
	private String date;
	
	
	// mao ni constructor
	Encap(String name, String date) {
		this.name = name;
		this.date = date;
	}

	// getters
	public String getName() {
		return name;
	}

	// setters
	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
