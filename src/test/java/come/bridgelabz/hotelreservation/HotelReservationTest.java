package come.bridgelabz.hotelreservation;

import java.text.ParseException;

import org.junit.*;

import come.bridgelabz.hotelreservation.Hotel.customers;

public class HotelReservationTest {
	HotelReservation hotelreservation;

	@Before
	public void displayMessage() {
		Hotel hotel1 = new Hotel("Lakewood", 110, 90, 3, 80, 80);
		Hotel hotel2 = new Hotel("Bridgewood", 150, 50, 4, 110, 50);
		Hotel hotel3 = new Hotel("Ridgewood", 220, 150, 5, 100, 40);
		hotelreservation = new HotelReservation();
		hotelreservation.add(hotel1, hotel2, hotel3);
	}
	
	@Test
	public void diaplay() {
		HotelReservation.display();
	}

	@Test
	public void whenGivenHotel_WhenAdded_ShouldMatchTheAdded() {
		Hotel hotel = new Hotel("Ridgewood", 220, 150, 5, 100, 40);
		Assert.assertEquals("Ridgewood", hotel.hotelName);
		Assert.assertEquals(220, hotel.regularWeekDayRate);
	}

	@Test
	public void given3Hotels_whenGivenDates_ShouldReturnCheapestHotel() throws ParseException {
		Hotel cheapHotel = hotelreservation.findCheapestHotel(customers.REGULAR, "16Mar2020", "17Mar2020", "18Mar2020");
		Assert.assertEquals("Lakewood", cheapHotel.hotelName);

	}

	@Test
	public void givenWeekendRate_WhenAdded_ShouldMatch() {
		Hotel hotel = new Hotel("Ridgewood", 220, 150, 5, 100, 40);
		Assert.assertEquals("Ridgewood", hotel.hotelName);
		Assert.assertEquals(150, hotel.regularWeekEndRate);
	}

	@Test
	public void given3Hotels_whenGivenDatesIncludingWeekends_ShouldReturnCheapestHotel() throws ParseException {
		Hotel cheapHotel = hotelreservation.findCheapestHotel(customers.REGULAR,"11Sep2020", "12Sep2020");
		Assert.assertEquals("Bridgewood", cheapHotel.hotelName);
	}

	@Test
	public void givenRating_WhenAdded_ShouldMatch() {
		Hotel hotel = new Hotel("Ridgewood", 220, 150, 5, 100, 40);
		Assert.assertEquals("Ridgewood", hotel.hotelName);
		Assert.assertEquals(5, (int)hotel.rating);
	}

	@Test
	public void given3Hotels_whenGivenDates_ShouldReturnCheapestHotelAsPerRating() throws ParseException {
		Hotel cheapHotel = hotelreservation.findCheapestHotel(customers.REGULAR,"11Sep2020", "12Sep2020");
		Assert.assertEquals("Bridgewood", cheapHotel.hotelName);
	}

	@Test
	public void given3Hotels_whenGivenDates_ShouldReturnBestRated() throws ParseException {
		Hotel bestRated = hotelreservation.findBestRatedHotel("11Sep2020", "12Sep2020");
		Assert.assertEquals("Ridgewood", bestRated.hotelName);
	}
	
	@Test
	public void given3Hotels_whenGivenDatesAndRegularOrLoyalty_ShouldReturnCheapestHotel() throws ParseException {
		Hotel cheapHotel = hotelreservation.findCheapestHotel(customers.LOYALTY,"11Sep2020", "12Sep2020");
		Assert.assertEquals("Ridgewood", cheapHotel.hotelName);
	}
	
	@Test
	public void given3Hotels_whenGivenDatesAndRegularOrLoyalty_ShouldReturnCheapestHotelUsingStreams() throws ParseException {
		Hotel cheapHotel = hotelreservation.findCheapestHotel(customers.LOYALTY,"11Sep2020", "12Sep2020");
		Assert.assertEquals("Ridgewood", cheapHotel.hotelName);
	}

}
