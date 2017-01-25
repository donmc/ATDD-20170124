package com.tddair;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class WhenRegisteringInvalidMember {

	@Test(expected=DuplicateMemberException.class)
	public void shouldNotAllowDuplicateUserId() {
		TddAirApplication app = new TddAirApplication(new FakeFlightDao(), new FakeMemberDao());
		app.registerMember("bob", "bob@bobco.com");
		app.registerMember("bob", "bob@bobco.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldNotAllowInvalidEmail() {
		TddAirApplication app = new TddAirApplication(new FakeFlightDao(), new FakeMemberDao());
		app.registerMember("bob", "bobbobco.com");
	}

}
