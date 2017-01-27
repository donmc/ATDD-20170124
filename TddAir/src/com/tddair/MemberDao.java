package com.tddair;

public interface MemberDao {

	String RED = "Red";
	String GOLD = "Gold";
	String BLUE = "Blue";
	String GREEN = "Green";

	void createMember(String name, int id, String emailId);

	Member findMember(String name);

}