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

	public Member(String name, int id, String emailId) {
		super();
		this.name = name;
		this.id = id;
		this.emailId = emailId;
		ytdMiles = 0;
		setBalanceMiles(10000);
		status = Status.getStatus(0);

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

}
