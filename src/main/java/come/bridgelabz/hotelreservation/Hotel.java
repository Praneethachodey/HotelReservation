package come.bridgelabz.hotelreservation;

import java.util.Date;

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

	// method to calculate price
	public int calculatePrice(String...days) {
		int totalAmount = 0;
		int day=0;
		while(day<days.length) {
			totalAmount += this.regularCustomerRate;
			day++;
		}
		return totalAmount;
	}
}
