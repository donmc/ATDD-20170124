package com.tddair;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenRegisteringNewMember {

	TddAirApplication app;
	private Member member;
	
	@Before
	public void setup() {
		// setup
		app = new TddAirApplication();
		app.addMember("1", "prakash.malluri@realpage.com");
		member = app.findById("1");
	}
	
	@Test
	public void testCheckForNull() {
		assertNotNull(member);
	}
	
	@Test
	public void testValidateId() {
		assertEquals("1", member.getId());
	}
	
	@Test
	public void testValidateEmail() {
		assertEquals("prakash.malluri@realpage.com", member.getEmail());
	}
	
	@Test
	public void testCheckRedStatus() {
		assertEquals("Red", member.getStatus());
	}
	
	@Test
	public void testCheckZeroYtdMiles() {
		assertEquals(0, member.getYtdMiles());
	}
	
	@Test
	public void testCheckBalanceMilesAtRegistration() {
		assertEquals(10000, member.getLifetimeMilesBalance());
	}
	
	@Test(expected=DuplicateMemberException.class)
	public void testDuplicateMember() {
		app.addMember("1", "prakash.malluri@realpage.com");
	}
	
	@Test(expected=InvalidEmailException.class) 
	public void testInvalidEmail() {
		app.setEmail("1", "prakash");
	}

}
