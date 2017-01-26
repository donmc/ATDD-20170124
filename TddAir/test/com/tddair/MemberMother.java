package com.tddair;

public class MemberMother {
	public Member redGuy;
	public Member greenGuy;
	public Member blueGuy;
	public Member goldGuy;

	public MemberMother() {
		Flight flight = new Flight("DFW", "DFW", 25000, "TEST", 25000);
		redGuy = new Member("red", "dummy@whatver.com");
		greenGuy = new Member("green", "dummy@whatver.com");
		greenGuy.completeFlight(flight);
		blueGuy = new Member("blue", "dummy@whatver.com");
		blueGuy.completeFlight(flight);
		blueGuy.completeFlight(flight);
		goldGuy = new Member("gold", "dummy@whatver.com");
		goldGuy.completeFlight(flight);
		goldGuy.completeFlight(flight);
		goldGuy.completeFlight(flight);
	}
	
	public Member getBlueGuy() {
		return blueGuy;
	}
	
	public Member getGoldGuy() {
		return goldGuy;
	}
	
	public Member getGreenGuy() {
		return greenGuy;
	}
	
	public Member getRedGuy() {
		return redGuy;
	}
}
