package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MemberFlightStatusChange {

	TddAirApplication app = new TddAirApplication(new FakeMemberDao());

	@Before
	public void setup() {
		app.addFlight("DFW", "SFO", 25000, "AA", 12);
		app.addFlight("DFW", "LAX", 20000, "AA", 13);
		app.addFlight("DFW", "MNP", 15000, "AA", 14);
		app.addFlight("DFW", "TNS", 40000, "AA", 15);
		app.addFlight("DFW", "NYK", 30000, "AA", 16);
		app.addFlight("DFW", "NEV", 50000, "AA", 17);
		app.addFlight("DFW", "DAL", 5000, "AA", 18);

		app.createMember("nitin", 1, "nitin@gmail.com");
	}

	@Test
	public void shouldNewMemberHaveRedStatus() {
		Member member = app.findMember("nitin");
		assertEquals(Status.RED, member.getStatus());
	}

	@Test
	public void shouldMemberHaveGreenStatus() {
		app.addFlightToMember("nitin", "AA12");
		Member member = app.findMember("nitin");
		assertEquals(Status.Green, member.getStatus());
	}

	@Test
	public void shouldMemberHaveBlueStatus() {
		app.addFlightToMember("nitin", "AA12");
		Member member = app.findMember("nitin");
		assertEquals(Status.Green, member.getStatus());
	}

	@Test
	public void shouldMemberHaveGoldStatus() {
		app.addFlightToMember("nitin", "AA12");
		Member member = app.findMember("nitin");
		assertEquals(Status.Green, member.getStatus());
	}
}
