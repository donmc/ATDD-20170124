package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class MemberManagement {

	private Map<String, Member> members = new HashMap<>();

	public static final String RED = "Red";

	public static final String GOLD = "Gold";
	
	public static final String BLUE = "Blue";
	
	public static final String GREEN = "Green";

	public MemberManagement() {
		createMember("Addy", 1, "aby@gmail.com");
		createMember("Danny", 2, "danny@gmail.com");
		createMember("Angel", 3, "angel@gmail.com");
		createMember("donmc", 4, "donmc@improving.com");
	}

	public void createMember(String name, int id, String emailId) {
		Member member = new Member(name, id, emailId);
		members.put(member.getName(), member);
	}

	public Member findMember(String name) {
		return members.get(name);
	}

}
