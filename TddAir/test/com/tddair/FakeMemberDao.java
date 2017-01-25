package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class FakeMemberDao implements MemberDao {
	public Map<String, Member> members = new HashMap<String, Member>();;

	public FakeMemberDao() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tddair.MemberDao#createMember(java.lang.String, int,
	 * java.lang.String)
	 */
	@Override
	public void createMember(String name, int id, String emailId) {
		if (findMember(name) == null) {
			if (!emailId.contains("@")) {
				throw new IllegalArgumentException();
			}
			Member member = new Member(name, id, emailId);
			members.put(member.getName(), member);
		} else
			throw new DuplicateMemberException();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tddair.MemberDao#findMember(java.lang.String)
	 */
	@Override
	public Member findMember(String name) {
		return members.get(name);
	}

	@Override
	public void addFlightToMember(String memberName, int miles) {
		Member member = findMember(memberName);
		member.setBalanceMiles(member.getBalanceMiles() + miles);
		member.setYtdMiles(member.getYtdMiles() + miles);
		member.setStatus(Status.getStatus(member.getYtdMiles()));
	}

}