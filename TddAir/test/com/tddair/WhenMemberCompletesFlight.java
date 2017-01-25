package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenMemberCompletesFlight {

	private TddAirApplication app;
	private Member member;
	
	@Before
	public void setup() {
		app = new TddAirApplication(new FakeFlightDao(), new FakeMemberDao());
		app.registerMember("don", "don@improving.com");
		member = app.findMemberById("don");
		app.addFlight("DFW", "DFE", 25000, "TEST", 25);
		app.addFlight("DFW", "DFE", 24000, "TEST", 24);
	}
	
	@Test
	public void shouldAccumulateMiles() {
		app.completeFlight("don", "AB38");
		assertEquals(3620, member.getYtdMiles());
		assertEquals(13620, member.getBalanceMiles());
	}
	
	@Test
	public void shouldPromoteToGreen() {
		app.completeFlight("don", "TEST25"); 
		assertEquals(Status.Green, member.getStatus());
	}
	
	@Test
	public void shouldPromoteToBlue() {
		app.completeFlight("don", "TEST25"); 
		app.completeFlight("don", "TEST25"); 
		assertEquals(Status.Blue, member.getStatus());
	}
	
	@Test
	public void shouldPromoteToGold() {
		app.completeFlight("don", "TEST25"); 
		app.completeFlight("don", "TEST25"); 
		app.completeFlight("don", "TEST25"); 
		assertEquals(Status.Gold, member.getStatus());
	}
	
	@Test
	public void shouldStayRed() {
		app.completeFlight("don", "TEST24"); 
		assertEquals(Status.Red, member.getStatus());
	}
	

}
