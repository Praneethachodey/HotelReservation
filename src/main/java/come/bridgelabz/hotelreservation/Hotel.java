package come.bridgelabz.hotelreservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Hotel {
	String hotelName;
	int regularWeekDayRate;
	int regularWeekEndRate;
	int loyaltyWeekDayRate;
	int loyaltyWeekEndRate;
	int rating;

	public Hotel(String hotelName, int regularWeekDayRate, int regularWeekEndRate, int rating, int loyaltyWeekDayRate,
			int loyaltyWeekEndRate) {
		this.hotelName = hotelName;
		this.regularWeekDayRate = regularWeekDayRate;
		this.regularWeekEndRate = regularWeekEndRate;
		this.rating = rating;
		this.loyaltyWeekDayRate = loyaltyWeekDayRate;
		this.loyaltyWeekEndRate = loyaltyWeekEndRate;
	}

	// method to get day-weekday/weekend
	public static String getDayOfWeek(String date) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		Date actualDate = dateFormat.parse(date);
		DateFormat dayFormat = new SimpleDateFormat("EE");
		String day = dayFormat.format(actualDate);
		return day;
	}

	// method to calculate price
	public int calculatePrice(String... days) throws ParseException {
		int totalAmount = 0;
		for (int day = 0; day < days.length; day++) {
			String whichDay = getDayOfWeek(days[day]);
			if (whichDay.equals("Sat") || whichDay.equals("Sun"))
				totalAmount += this.regularWeekEndRate;
			else
				totalAmount += this.regularWeekDayRate;
		}
		return totalAmount;
	}
}
