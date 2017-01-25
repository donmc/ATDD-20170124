package com.tddair;

public class Member {

	private String id;
	private String email;

	public Member(String userId, String email) {
		this.id = userId;
		this.email = email;
	}

	public String getUserId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

}
