package come.bridgelabz.hotelreservation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservation {

	public List<Hotel> listOfHotels = new ArrayList<>();

	public static void display() {
		System.out.println("Welcome to hotel reservation program");
	}

	// method to add hotels
	public void add(Hotel... hotels) {
		int i = 0;
		while (i < hotels.length) {
			listOfHotels.add(hotels[i]);
			i++;
		}
	}

	public Hotel findCheapestHotel(String... days) {
		int lowestPrice = 0;
		Hotel cheapHotel = listOfHotels.get(0);
		for (int hotel = 0; hotel < listOfHotels.size(); hotel++) {
			int price = listOfHotels.get(hotel).calculatePrice(days);
			if (price < lowestPrice) {
				lowestPrice = price;
				cheapHotel = listOfHotels.get(hotel);
			}
		}
		return cheapHotel;
	}

}
