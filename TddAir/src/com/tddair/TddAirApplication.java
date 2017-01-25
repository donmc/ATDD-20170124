package com.tddair;

public class TddAirApplication {

	private FlightDao flights;
	private MemberDao members;

	public TddAirApplication(FlightDao flightDao, MemberDao memberDao) {
		flights = flightDao;
		members = memberDao;
	}

	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public Flight findFlightByNumber(String flightNumber) {
		return flights.getFlightBy(flightNumber);
	}

	public void registerMember(String userId, String email) {
		validateEmail(email);
		Member member = new Member(userId, email);
		members.addMember(member);
	}

	private void validateEmail(String email) {
		if (!email.contains("@")) {
			throw new IllegalArgumentException();
		}
	}

	public Member findMemberById(String userId) {
		return members.findMemberById(userId);
	}

	public void completeFlight(String userId, String flightNo) {
		Flight flight = flights.getFlightBy(flightNo);
		Member member = members.findMemberById(userId);
		member.completeFlight(flight);
	}
}
