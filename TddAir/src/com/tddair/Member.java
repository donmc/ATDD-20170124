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

	public Member(String name, int id, String emailId) {
		super();
		this.name = name;
		this.id = id;
		this.emailId = emailId;
		ytdMiles = 0;
		setBalanceMiles(10000);
	}

	public Status getStatus() {
		Status status = Status.RED;
		if (ytdMiles > 75000)
			status = Status.GOLD;
		else if (ytdMiles > 50000)
			status = Status.BLUE;
		else if (ytdMiles > 25000)
			status = Status.Green;
		return status;
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

}
