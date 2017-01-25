package com.tddair;

import java.util.HashMap;
import java.util.Map;

public class FakeMemberDao implements MemberDao {
	private Map<String, Member> members = new HashMap<>();

	public FakeMemberDao() {
	}

	/* (non-Javadoc)
	 * @see com.tddair.MemberDao#addMember(com.tddair.Member)
	 */
	@Override
	public void addMember(Member member) {
	    if(members.containsKey(member.getUserId())) {
	    	throw new DuplicateMemberException();
	    }
		members.put(member.getUserId(), member);
	}

	/* (non-Javadoc)
	 * @see com.tddair.MemberDao#findMemberById(java.lang.String)
	 */
	@Override
	public Member findMemberById(String userId) {
		return members.get(userId);
	}
}