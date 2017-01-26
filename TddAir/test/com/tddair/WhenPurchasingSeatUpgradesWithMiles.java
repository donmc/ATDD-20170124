package com.tddair;

import static org.junit.Assert.*;
import static com.tddair.MemberMother.*;

import org.junit.Ignore;
import org.junit.Test;

public class WhenPurchasingSeatUpgradesWithMiles {
	
	private MemberMother mom = new MemberMother();

	@Test
	public void shouldIncreaseUpgradeBalance() {
		int quantity = 1;
		mom.redGuy.purchaseSeatUpgradeWithMiles(quantity);
		
		assertEquals(1, mom.redGuy.getSeatUpgradeBalance());
	}
	
	@Test
	public void shouldDecreaseMilesBalance() {
		int quantity = 1;
		Member member = new Member("don", "don@improving.com");
		member.purchaseSeatUpgradeWithMiles(quantity);
		
		assertEquals(0, member.getBalanceMiles());
	}
	
	@Test
	public void shoudNotPurchaseUpgradesWhenBroke() {
		int quantity = 2;
		mom.redGuy.purchaseSeatUpgradeWithMiles(quantity);

		assertEquals(0, mom.redGuy.getSeatUpgradeBalance());
		assertEquals(10000, mom.redGuy.getBalanceMiles());
	}
	
	@Test
	public void shouldPay9000IfGreen() {
		mom.greenGuy.purchaseSeatUpgradeWithMiles(1);

		assertEquals(1, mom.greenGuy.getSeatUpgradeBalance());
		assertEquals(26000, mom.greenGuy.getBalanceMiles());
	}
	
	@Test
	public void shouldPay8000IfBlue() {
		int initialBalance = mom.blueGuy.getBalanceMiles();
		mom.blueGuy.purchaseSeatUpgradeWithMiles(1);
		int difference = initialBalance - mom.blueGuy.getBalanceMiles();
		
		assertEquals(1, mom.blueGuy.getSeatUpgradeBalance());
		assertEquals(8000, difference);
	}
	

}
