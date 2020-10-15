package come.bridgelabz.hotelreservation;

import java.text.ParseException;

import org.junit.*;

public class HotelReservationTest {
	HotelReservation hotelreservation;

	@Before
	public void displayMessage() {
		HotelReservation.display();
		Hotel hotel1 = new Hotel("Lakewood", 110, 90);
		Hotel hotel2 = new Hotel("Bridgewood", 150, 50);
		Hotel hotel3 = new Hotel("Ridgewood", 220, 150);
		hotelreservation = new HotelReservation();
		hotelreservation.add(hotel1, hotel2, hotel3);
	}

	@Test
	public void whenGivenHotel_WhenAdded_ShouldMatchTheAdded() {
		Hotel hotel = new Hotel("Ridgewood", 220, 150);
		Assert.assertEquals("Ridgewood", hotel.hotelName);
		Assert.assertEquals(220, hotel.regularWeekDayRate);
	}

	@Test
	public void given3Hotels_whenGivenDates_ShouldReturnCheapestHotel() throws ParseException {
		Hotel cheapHotel = hotelreservation.findCheapestHotel("16Mar2020", "17Mar2020", "18Mar2020");
		Assert.assertEquals("Lakewood", cheapHotel.hotelName);

	}

	@Test
	public void givenWeekendRate_WhenAdded_ShouldMatch() {
		Hotel hotel = new Hotel("Ridgewood", 220, 150);
		Assert.assertEquals("Ridgewood", hotel.hotelName);
		Assert.assertEquals(150, hotel.regularWeekEndRate);
	}
	
	@Test
	public void given3Hotels_whenGivenDatesIncludingWeekends_ShouldReturnCheapestHotel() throws ParseException {
		Hotel cheapHotel = hotelreservation.findCheapestHotel("11Sep2020", "12Sep2020");
		Assert.assertEquals("Lakewood", cheapHotel.hotelName);

	}

}
