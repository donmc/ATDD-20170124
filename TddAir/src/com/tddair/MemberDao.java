package com.tddair;

public interface MemberDao {

	void addMember(Member member);

	Member findMemberById(String userId);

}