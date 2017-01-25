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
		balanceMiles = 10000;
	}

	public Object getStatus() {
		String status = MemberManagement.RED;
		if (ytdMiles > 75000) 
			status = MemberManagement.GOLD;
		else if (ytdMiles > 50000)
			status = MemberManagement.BLUE;
		else if (ytdMiles > 50000)
			status = MemberManagement.GREEN;
		return status;
	}

	public void setYtdMiles(int ytdMiles) {
		this.ytdMiles = ytdMiles;
		
	}

}
