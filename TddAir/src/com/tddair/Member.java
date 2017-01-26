package com.tddair;

public class Member {

	private String id;
	private String email;
	private Status status;
	private int ytdMiles;
	private int balanceMiles;
	private int seatUpgradeBalance;

	public Member(String userId, String email) {
		this.id = userId;
		this.email = email;
		this.status = Status.Red;
		this.ytdMiles = 0;
		this.balanceMiles = 10000;
	}

	public String getUserId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public Status getStatus() {
		return status;
	}

	public int getYtdMiles() {
		return ytdMiles;
	}

	public int getBalanceMiles() {
		return balanceMiles;
	}

	public void completeFlight(Flight flight) {
		ytdMiles += flight.getMileage();
		balanceMiles += flight.getMileage();
		status = Status.calculateStatusFor(ytdMiles);
		
	}

	public void purchaseSeatUpgradeWithMiles(int quantity) {
		int cost = status.getSeatUpgradeMilesCost()*quantity;
		
		if (balanceMiles >= cost) {
			seatUpgradeBalance += quantity;
			balanceMiles -= cost;
		}
	}

	public int getSeatUpgradeBalance() {
		return seatUpgradeBalance;
	}

}
