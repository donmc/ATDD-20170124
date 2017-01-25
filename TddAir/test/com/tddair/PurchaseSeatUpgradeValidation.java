package com.tddair;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class PurchaseSeatUpgradeValidation {

	TddAirApplication app = null;

	@Before
	public void setup() {
		app = new TddAirApplication(new FakeMemberDao());

		app.addFlight("DFW", "SFO", 25000, "AA", 12);

		app.createMember("nitin", 1, "nitin@gmail.com");
	}

	@Test
	public void redStatusMemberShouldBeAbleToPurchaseSeatUpgrade() {
		app.purchaseSeatUpgrade("nitin", 1);
		Member member = app.findMember("nitin");
		assertEquals(1, member.getSeatUpgrades());
		assertEquals(0, member.getBalanceMiles());
	}

	@Test
	public void redStatusMemberShouldNotBeAbleToPurchaseSeatUpgrade() {
		try {
			app.purchaseSeatUpgrade("nitin", 2);
			fail();
		} catch (InsufficientUpgradesMiles e) {
			Member member = app.findMember("nitin");
			assertEquals(10000, member.getBalanceMiles());

		}
	}

	@Test
	public void greenStatusMemberShouldBeAbleToPurchaseSeatUpgrade() {
		app.addFlightToMember("nitin", "AA12");
		app.purchaseSeatUpgrade("nitin", 2);
		Member member = app.findMember("nitin");
		assertEquals(2, member.getSeatUpgrades());
		assertEquals(17000, member.getBalanceMiles());
	}

	@Test(expected = InsufficientUpgradesMiles.class)
	public void greenStatusMemberShouldNotBeAbleToPurchaseSeatUpgrade() {
		app.addFlightToMember("nitin", "AA12");
		try {
			app.purchaseSeatUpgrade("nitin", 4);
		} catch (InsufficientUpgradesMiles e) {
			Member member = app.findMember("nitin");
			assertEquals(35000, member.getBalanceMiles());
			throw e;
		}
	}

	@Test
	public void blueStatusMemberShouldBeAbleToPurchaseSeatUpgrade() {
		app.addFlightToMember("nitin", "AA12");
		app.addFlightToMember("nitin", "AA12");
		app.purchaseSeatUpgrade("nitin", 2);
	}

	@Test
	public void goldStatusMemberShouldBeAbleToPurchaseSeatUpgrade() {
		app.addFlightToMember("nitin", "AA12");
		app.addFlightToMember("nitin", "AA12");
		app.addFlightToMember("nitin", "AA12");
		app.purchaseSeatUpgrade("nitin", 2);
	}

	@Test(expected = InsufficientUpgradesMiles.class)
	public void goldStatusMemberShouldNotBeAbleToPurchaseSeatUpgrade() {
		app.addFlightToMember("nitin", "AA12");
		app.addFlightToMember("nitin", "AA12");
		app.addFlightToMember("nitin", "AA12");
		app.purchaseSeatUpgrade("nitin", 15);
	}

}
