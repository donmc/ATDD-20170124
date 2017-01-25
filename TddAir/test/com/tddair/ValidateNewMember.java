package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ValidateNewMember {

	MemberManagement mm = new MemberManagement();

	@Before
	public void setup() {
		mm.createMember("donmc", 1, "donmc@improving.com");

	}

	@Test
	public void testDuplicateMemberThrowsException() {
		try {
			mm.createMember("donmc", 1, "donmc@improving.com");
			// fail();
		} catch (Exception ex) {
			assertEquals("Duplicate Member", ex.getMessage());
		}

	}

}
