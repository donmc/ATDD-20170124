package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class WhenRegisteringNewMember {

	private TddAirApplication app;
	private Member member;
	
	@Before
	public void setup() {
		String userId = "donmc";
		String email = "don@improving.com";
		
		app = new TddAirApplication();
		app.registerMember(userId, email);
		member = app.findMemberById(userId);
	}
	
	@Test
	public void shouldFindByUserId() {
		assertNotNull(member);
	}
	
	@Test
	public void shouldHaveProperUserId() {
		assertEquals("donmc", member.getUserId());
	}
	
	@Test
	public void shouldHaveProperEmail() {
		assertEquals("don@improving.com", member.getEmail());
	}
	
	@Ignore @Test
	public void shouldHaveRedStatus() {
		fail("Not yet implemented");
	}
	
	@Ignore @Test
	public void shouldHave0YtdMiles() {
		fail("Not yet implemented");
	}
	
	@Ignore @Test
	public void shouldHave10000BalanceMiles() {
		fail("Not yet implemented");
	}

}
