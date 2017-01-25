package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringNewMember {

	MemberManagement mm = null;
	Member member = null;

	@Before
	public void setup() {
		mm = new MemberManagement();
		mm.createMember("prakash", 6, "prakash.malluri@realpage.com");

		member = mm.findMember("prakash");

	}

	@Test
	public void testNotNullUserId() {
		assertNotNull(member);
	}

	@Test
	public void testIfNewMemberHasRedStatus() {
		assertEquals(MemberManagement.RED, member.getStatus());
	}

}
