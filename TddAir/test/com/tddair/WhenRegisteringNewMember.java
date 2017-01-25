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
		
		app = new TddAirApplication(new FakeFlightDao(), new FakeMemberDao());
		app.registerMember(userId, email);
		member = app.findMemberById(userId);
	} 
	
	@Test
	public void shouldFindByUserId() {
		assertNotNull(member);
	}
	
	@Test 
	public void shouldRegisterMultipleMembers() {
		app.registerMember("bob", "bob@bobco.com");

		Member member2 = app.findMemberById("bob");
		Member member1 = app.findMemberById("donmc");
		assertEquals("bob", member2.getUserId());
		assertEquals("donmc", member1.getUserId());
	}
	
	@Test
	public void shouldHaveProperUserId() {
		assertEquals("donmc", member.getUserId());
	}
	
	@Test
	public void shouldHaveProperEmail() {
		assertEquals("don@improving.com", member.getEmail());
	}
	
	@Test
	public void shouldHaveRedStatus() {
		assertEquals(Status.Red, member.getStatus());
	}
	
	@Test
	public void shouldHave0YtdMiles() {
		assertEquals(0, member.getYtdMiles());
	}
	
	@Test
	public void shouldHave10000BalanceMiles() {
		assertEquals(10000, member.getBalanceMiles());
	}

}
