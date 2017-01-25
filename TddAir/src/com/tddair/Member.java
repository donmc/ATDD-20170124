package com.tddair;

public class Member {

	private String id;
	private String email;
	private String status = "Red";
	private long ytdMiles = 0;
	private long lifetimeMilesBalance = 10000;
	
	
	public Member(String id, String email) {
		this.id = id;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return status;
	}

	public long getYtdMiles() {
		return ytdMiles;
	}
	
	public long getLifetimeMilesBalance() {
		return lifetimeMilesBalance;
	}

}
