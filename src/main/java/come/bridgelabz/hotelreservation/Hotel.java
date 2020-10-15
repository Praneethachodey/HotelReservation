package come.bridgelabz.hotelreservation;

public class Hotel {
	String hotelName;
	int regularCustomerRate;

	public Hotel(String hotelName, int regularCustomerRate) {
		this.hotelName = hotelName;
		this.regularCustomerRate = regularCustomerRate;
	}

	@Override
	public String toString() {
		String str = "Hotel name : " + this.hotelName + " rates for regular customer : " + this.regularCustomerRate;
		return str;
	}
}
