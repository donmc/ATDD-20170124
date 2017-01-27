package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class ValidateNewMember {

	MemberDao mm = new FakeMemberDao();

	@Before
	public void setup() {
		mm.createMember("donmc", 1, "donmc@improving.com");

	}

	@Test
	public void testDuplicateMemberThrowsException() {
		try {
			mm.createMember("donmc", 1, "donmc@improving.com");
			fail();
		} catch (Exception ex) {
			assertEquals("Duplicate Member", ex.getMessage());
		}

	}
	
	@Test
	public void testValidEmailThrowsException() {
		try {
			mm.createMember("do", 1, "don-improving.com");
			fail();
		} catch (Exception ex) {
			assertEquals("Invalid EmailId", ex.getMessage());
		}

	}

}
