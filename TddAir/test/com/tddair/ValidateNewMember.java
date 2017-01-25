package com.tddair;

import org.junit.Before;
import org.junit.Test;

public class ValidateNewMember {

	TddAirApplication app = new TddAirApplication(new FakeMemberDao());

	@Before
	public void setup() {
		app.createMember("donmc", 1, "donmc@improving.com");

	}

	@Test(expected = DuplicateMemberException.class)
	public void testDuplicateMemberThrowsException() {
		app.createMember("donmc", 1, "donmc@improving.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidEmailThrowsException() {
		app.createMember("do", 1, "don-improving.com");

	}

}
