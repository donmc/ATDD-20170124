package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WhenCompletingFlight {
	
	TddAirApplication app = new TddAirApplication(new FlightDao(), new FakeMemberDao());
	Member member;
	
	@Before
	public void setup() {
		app.registerMember("bob", 1, "bob@test.com");
		member = app.findMember("bob");
		app.addFlight("DFW", "ADD", 15000, "EA", 1);

	}
	
	@Test
	public void shouldAccumulateMiles() {
		app.completeFlight("bob","AA242");
		assertEquals(924, member.getYtdMiles());
		assertEquals(10924, member.getBalanceMiles());

	}

	
	@Test
	public void shouldEarnGreen() {
		app.completeFlight("bob","EA1");
		app.completeFlight("bob","EA1");
		assertEquals(Status.GREEN, member.getStatus());
	}
	
	@Test
	public void shouldEarnBlue() {
		app.completeFlight("bob","EA1");
		app.completeFlight("bob","EA1");
		app.completeFlight("bob","EA1");
		app.completeFlight("bob","EA1");

		assertEquals(Status.BLUE, member.getStatus());
	}
	
	@Test
	public void shouldEarnGold() {
		app.completeFlight("bob","EA1");
		app.completeFlight("bob","EA1");
		app.completeFlight("bob","EA1");
		app.completeFlight("bob","EA1");
		app.completeFlight("bob","EA1");
		app.completeFlight("bob","EA1");
		assertEquals(Status.GOLD, member.getStatus());
	}
	
	@Test
	public void shouldStayRed() {
		assertEquals(Status.RED, member.getStatus());
	}

}
