package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class WhenPurchasingSeatUpgradeWithMiles {
	
	TddAirApplication app = new TddAirApplication(new FlightDao(), new FakeMemberDao());
	Member member;
	
	@Before
	public void setup() {
		app.registerMember("bob", 1, "bob@test.com");
		member = app.findMember("bob");
	}
	
	@Test
	public void shouldIncreaseUpgradeBalance() {
		app.purchaseSeatUpgrade("bob", 1);
		assertEquals(1, member.getSeatUpgradeBalance());

	}
	
	@Test
	public void shouldDecreaseMilesBalanceBy10000ForRed() {
		app.purchaseSeatUpgrade("bob", 1);
		assertEquals(0, member.getBalanceMiles());

	}
	
	@Test(expected=IllegalArgumentException.class)
	public void shouldErrorForInsufficientBalance() {
		app.purchaseSeatUpgrade("bob", 2);

	}

}
