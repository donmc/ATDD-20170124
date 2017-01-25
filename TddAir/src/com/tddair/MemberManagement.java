package com.tddair;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

public class MemberManagement {

	private Map<String, Member> members = new HashMap<>();

	public static final String RED = "Red";

	public static final String GOLD = "Gold";

	public static final String BLUE = "Blue";

	public static final String GREEN = "Green";

	public MemberManagement() {
	}

	public void createMember(String name, int id, String emailId) {
		if (findMember(name) == null) {
			if (!emailId.contains("@")){
				throw new RuntimeException("Invalid EmailId");
			}
			Member member = new Member(name, id, emailId);
			members.put(member.getName(), member);
		} else
			throw new RuntimeException("Duplicate Member");
	}

	public Member findMember(String name) {
		return members.get(name);
	}

}
