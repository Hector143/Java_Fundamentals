package Java_GUI_Example2;

public class Reservation {
	private String reservationNumber;
	private String guestName;
	private String roomType;
	private int numOfDays;
	private double totalAmount;
	private String status;

	public Reservation(String reservationNumber, String guestName,
			String roomType, int numOfDays, String status) {
		this.reservationNumber = reservationNumber;
		this.guestName = guestName;
		this.roomType = roomType;
		this.numOfDays = numOfDays;
		this.status = status;
		computeTotalAmount();
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
		computeTotalAmount();
	}

	public int getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toFileString() {
		return reservationNumber + "|" +
				guestName + "|" +
				roomType+ "|" +
				numOfDays + "|" +
				totalAmount + "|" +
				status; 
	}

	public void computeTotalAmount() {
		double rate = 0;
		switch (roomType) {
		case "Single":
			rate = 1000;
			break;
		case "Double":
			rate = 1800;
			break;
		case "Suite":
			rate = 3000;
			break;
		}
		totalAmount = rate * numOfDays;
	}
}


