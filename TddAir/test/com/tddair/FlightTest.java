package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlightTest {

	@Test(expected=IllegalArgumentException.class)
	public void testFlightCreation_noOrigin() {
			new Flight(null, "ORD", 920, "AA", 750);
	} 

	@Test(expected=IllegalArgumentException.class)
	public void testFlightCreation_invalidOriginLength() {
			new Flight("DALLAS", "ORD", 920, "AA", 750);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFlightCreation_invalidDestinationLength() {
			new Flight("ORD", "DALLAS", 920, "AA", 750);
	}
	
	@Test
	public void testFlightCreation_noDestination() {
		try {
			new Flight("ORD", null, 920, "AA", 750);
			fail("Should have thrown an exception!");
		} catch (IllegalArgumentException e) {
			assertEquals("Invalid destination code", e.getMessage());
		}
	}
	
	@Test
	public void testGetFullFlightNumber() {
		// setup
		String expected = "AA750";
		Flight flight = new Flight("DFW", "ORD", 920, "AA", 750);

		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();

		// verify
		assertEquals(expected, fullFlightNumber);
	}

	@Test
	public void testGetFullFlightNumber_NullAirline() {
		// setup
		String expected = "UNKNOWN";
		Flight flight = new Flight("DFW", "ORD", 920, null, 750);

		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();

		// verify
		assertEquals(expected, fullFlightNumber);
	}

	@Test
	public void testGetFullFlightNumber_NoNumber() {
		// setup
		String expected = "UNKNOWN";
		Flight flight = new Flight("DFW", "ORD", 920, "AA", 0);

		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();

		// verify
		assertEquals(expected, fullFlightNumber);
	}
	
	@Test
	public void testGetFullFlightNumber_AF1() {
		String expected = "Air Force One";
		Flight flight = new Flight("WDC", "LAX", 2000, "AF1", 0);

		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();

		// verify
		assertEquals(expected, fullFlightNumber);
	}
	
	@Test
	public void testGetFullFlightNumber_AF1_100_number() {
		String expected = "Air Force One";
		Flight flight = new Flight("WDC", "LAX", 2000, "AF1", 100);

		// exercise
		String fullFlightNumber = flight.getFullFlightNumber();

		// verify
		assertEquals(expected, fullFlightNumber);
	}

}
