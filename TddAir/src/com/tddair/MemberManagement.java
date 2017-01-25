package com.tddair;

public class MemberManagement {

	private MemberDao data;

	public MemberManagement(MemberDao dao) {
		this.data = dao;
	}

	public void createMember(String name, int id, String emailId) {
		data.createMember(name, id, emailId);
	}

	public Member findMember(String name) {
		return data.findMember(name);
	}

}
