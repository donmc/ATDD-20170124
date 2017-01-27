package com.tddair;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

public class FakeMemberDao implements MemberDao {

	private Map<String, Member> members = new HashMap<>();

	public FakeMemberDao() {
	}

	/* (non-Javadoc)
	 * @see com.tddair.MemberDao#createMember(java.lang.String, int, java.lang.String)
	 */
	@Override
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

	/* (non-Javadoc)
	 * @see com.tddair.MemberDao#findMember(java.lang.String)
	 */
	@Override
	public Member findMember(String name) {
		return members.get(name);
	}



}
