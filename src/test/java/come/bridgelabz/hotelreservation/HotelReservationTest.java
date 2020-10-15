package come.bridgelabz.hotelreservation;

import java.text.ParseException;

import org.junit.*;

public class HotelReservationTest {
	HotelReservation hotelreservation;

	@Before
	public void displayMessage() {
		HotelReservation.display();
		Hotel hotel1 = new Hotel("Lakewood", 110);
		Hotel hotel2 = new Hotel("Nridgewood", 160);
		Hotel hotel3 = new Hotel("Ridgewood", 220);
		hotelreservation = new HotelReservation();
		hotelreservation.add(hotel1, hotel2, hotel3);
	}

	@Test
	public void whenGivenHotel_WhenAdded_ShouldMatchTheAdded() {
		Hotel hotel = new Hotel("Ridgewood", 220);
		Assert.assertEquals("Ridgewood", hotel.hotelName);
		Assert.assertEquals(220, hotel.regularCustomerRate);
	}

	@Test
	public void given3Hotels_whenGivenDates_ShouldReturnCheapestHotel() {
		Hotel cheapHotel = hotelreservation.findCheapestHotel("16March2020", "17March2020", "18March2020");
		Assert.assertEquals("Lakewood", cheapHotel.hotelName);

	}

}
