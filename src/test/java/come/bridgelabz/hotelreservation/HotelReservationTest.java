package come.bridgelabz.hotelreservation;

import org.junit.*;

public class HotelReservationTest {

	@Before
	public void displayMessage() {
		HotelReservation.display();
	}
	
	@Test
	public void whenGivenHotel_WhenAdded_ShouldMatchTheAdded() {
		Hotel hotel= new Hotel("Ridgewood" , 220);
		Assert.assertEquals("Ridgewood",hotel.hotelName);
		Assert.assertEquals(220, hotel.regularCustomerRate);
	}
}
