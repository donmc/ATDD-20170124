package com.tddair;

public interface MemberDao {

	void createMember(String name, int id, String emailId);

	Member findMember(String name);

	void addFlightToMember(String memberName, int flight);

}