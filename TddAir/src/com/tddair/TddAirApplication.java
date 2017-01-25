package com.tddair;

import java.util.HashMap;

public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	private HashMap<String, Member> members = new HashMap<>();
	
	public TddAirApplication() {
	}
	
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void addMember(String id, String email) throws DuplicateMemberException {
		if (members.get(id) != null) {
			throw new DuplicateMemberException();
		}
		members.put(id, new Member(id, email));
	}

	public Member findById(String id) {
		return members.get(id);
	}
}
