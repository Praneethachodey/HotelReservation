package come.bridgelabz.hotelreservation;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import come.bridgelabz.hotelreservation.Hotel.customers;

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

	// method to return cheapest hotel
	public Hotel findCheapestHotel(customers type, String... days) throws ParseException {
		Hotel cheapHotel = listOfHotels.stream().sorted((Hotel hotel1, Hotel hotel2) -> {
			try {
				int compare = hotel1.calculatePrice(type, days).compareTo(hotel2.calculatePrice(type, days));
				if (compare == 0 && hotel1.rating > hotel2.rating)
					compare = -1;
				return compare;
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return 0;
		}).findFirst().orElse(null);
		System.out.println("cheapest hotel = " + cheapHotel.hotelName + " with rating : " + cheapHotel.rating
				+ " with price : " + cheapHotel.calculatePrice(type, days));

		return cheapHotel;
	}

	// method to find best rated hotel
	public Hotel findBestRatedHotel(String... days) throws ParseException {
		Hotel bestRated = listOfHotels.stream().sorted((Hotel hotel1, Hotel hotel2) -> {
			return hotel2.rating.compareTo(hotel1.rating);
		}).findFirst().orElse(null);
		System.out.println("best rated = " + bestRated.hotelName + " with rating : " + bestRated.rating);
		return bestRated;
	}
}
