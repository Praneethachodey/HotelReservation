package come.bridgelabz.hotelreservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			if (whichDay == "Sat" || whichDay == "Sun")
				totalAmount += this.regularWeekEndRate;
			else
				totalAmount += this.regularWeekDayRate;
			day++;
		}
		return totalAmount;
	}
}
