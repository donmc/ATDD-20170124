package com.tddair;

import org.junit.Before;
import org.junit.Test;

public class ValidateNewMember {

	MemberManagement mm = new MemberManagement(new FakeMemberDao());

	@Before
	public void setup() {
		mm.createMember("donmc", 1, "donmc@improving.com");

	}

	@Test(expected = DuplicateMemberException.class)
	public void testDuplicateMemberThrowsException() {
		mm.createMember("donmc", 1, "donmc@improving.com");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testValidEmailThrowsException() {
		mm.createMember("do", 1, "don-improving.com");

	}

}
