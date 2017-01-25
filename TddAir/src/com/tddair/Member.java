package com.tddair;

public class Member {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private int id;
	private String emailId;
	private int ytdMiles;
	private int balanceMiles;
	private Status status;
	private int seatUpgrades;

	public Member(String name, int id, String emailId) {
		super();
		this.name = name;
		this.id = id;
		this.emailId = emailId;
		ytdMiles = 0;
		setBalanceMiles(10000);
		status = Status.getStatus(this.ytdMiles);
		seatUpgrades = 0;

	}

	public Status getStatus() {

		return this.status;
	}

	public void setYtdMiles(int ytdMiles) {
		this.ytdMiles = ytdMiles;

	}

	public int getYtdMiles() {
		return this.ytdMiles;
	}

	public int getBalanceMiles() {
		return balanceMiles;
	}

	public void setBalanceMiles(int balanceMiles) {
		this.balanceMiles = balanceMiles;
	}

	public void setStatus(Status status) {
		this.status = status;

	}

	public int getSeatUpgrades() {
		return seatUpgrades;
	}

	public void addFlightToMember(Flight flight) {
		setBalanceMiles(this.getBalanceMiles() + flight.getMileage());
		setYtdMiles(this.getYtdMiles() + flight.getMileage());
		setStatus(Status.getStatus(this.getYtdMiles()));
	}

	public void purchaseSeatUpgrade(int qty) {
		int milesForSeatUpgrade = this.status.getPurchaseSeatUpgradeMiles();
		int reqdMilesForSeatUpgrade = qty * milesForSeatUpgrade;
		if (reqdMilesForSeatUpgrade <= this.balanceMiles) {
			this.balanceMiles = this.balanceMiles - reqdMilesForSeatUpgrade;
			this.seatUpgrades = this.seatUpgrades + qty;
		} else {
			throw new InsufficientUpgradesMiles();
		}

	}

}
