package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenLookingUpFlights {

	private Flight flight;

	@Before
	public void setup() {
		// setup
		TddAirApplication app = new TddAirApplication();
		app.addFlight("ATL", "LAX", 2000, "AA", 23);

		// exercise
		String flightNumber = "AA23";
		flight = app.findFlightByNumber(flightNumber);
	}

	@Test 
	public void shouldHaveCorrectDestination() {
		assertEquals("LAX", flight.getDestination());
	} 
	
	@Test
	public void shouldHaveCorrectOrigin() {
		assertEquals("ATL", flight.getOrigin());
	}

	@Test
	public void shouldFindFlightByNumber() {
		assertNotNull(flight);
	}

}
