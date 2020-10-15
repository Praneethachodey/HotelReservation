package come.bridgelabz.hotelreservation;

import java.util.Date;

public class Hotel {
	String hotelName;
	int regularWeekDayRate;
	int regularWeekEndRate;

	public Hotel(String hotelName, int regularWeekDayRate, int regularWeekEndRate) {
		this.hotelName = hotelName;
		this.regularWeekDayRate = regularWeekDayRate;
		this.regularWeekEndRate = regularWeekEndRate;

	}

	@Override
	public String toString() {
		String str = "Hotel name : " + this.hotelName + " rates for regular customer : " + this.regularWeekDayRate;
		return str;
	}

	// method to calculate price
	public int calculatePrice(String...days) {
		int totalAmount = 0;
		int day=0;
		while(day<days.length) {
			totalAmount += this.regularWeekDayRate;
			day++;
		}
		return totalAmount;
	}
}
