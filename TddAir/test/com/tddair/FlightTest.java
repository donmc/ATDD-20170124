package com.tddair;

import static org.junit.Assert.*;


import org.junit.Test;

public class FlightTest {

	@Test
	public void testGetFullFlightNumber() {
		
		Flight flight = new Flight("DFW", "ORD", 920, "AA", 750);
		
		//exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		//verify
		assertEquals("AA750", fullFlightNumber);
	}
	
	@Test
	public void testGetFullFlightNumber_NullAirline() {
		//Setup
		Flight flight = new Flight("DFW", "ORD", 920, null, 750);
		
		//exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		//verify
		assertEquals("UNKNOWN", fullFlightNumber);
	}
	
	@Test
	public void testGetFullFlightNumber_NoNumber() {
		//Setup
		Flight flight = new Flight("DFW", "ORD", 920, null, 0);
		
		//exercise
		String fullFlightNumber = flight.getFullFlightNumber();
		//verify
		assertEquals("UNKNOWN", fullFlightNumber);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFlightCreation_noOrigin() {
		new Flight("null", "ORD", 920, "AA", 750);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testFlightCreation_invalidOriginLength() {
		new Flight("DFWA", "ORD", 920, "AA", 750);
	}
	
	@Test
	public void testFlightCreation_noDestination(){
		try {
			new Flight("DFW", "", 920, null, 750);
			fail("Should have thrown exception.");
		} catch(IllegalArgumentException e) {
			assertEquals("Invalid destination code", e.getMessage());
		}
	}
	
	

}
