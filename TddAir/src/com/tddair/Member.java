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
	}


}
