package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringNewMember {

	MemberDao mm = null;
	Member member = null;

	@Before
	public void setup() {
		mm = new FakeMemberDao();
		mm.createMember("prakash", 6, "prakash.malluri@realpage.com");

		member = mm.findMember("prakash");

	}

	@Test
	public void testNotNullUserId() {
		assertNotNull(member);
	}

	@Test
	public void testIfNewMemberHasRedStatus() {
		assertEquals(Status.RED, member.getStatus());
	}
	
	@Test
	public void testIfYtdMilesIsZero() {
		assertEquals(0, member.getYtdMiles());
	}
	
	@Test
	public void testIfBalanceMiles() {
		assertEquals(10000, member.getBalanceMiles());
	}

}
