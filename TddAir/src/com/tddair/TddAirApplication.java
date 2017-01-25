package com.tddair;

public class TddAirApplication {

	private FlightDao flights = new FlightDao();
	private MemberDao memberDao;

	public TddAirApplication(MemberDao dao) {
		this.memberDao = dao;
	}

	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public Flight findFlight(String flightNumber) {
		return flights.getFlightBy(flightNumber);
	}

	public void createMember(String name, int id, String emailId) {
		memberDao.createMember(name, id, emailId);
	}

	public Member findMember(String name) {
		return memberDao.findMember(name);
	}

	public void addFlightToMember(String memberName, String flightNumber) {
		Flight flight = findFlight(flightNumber);
		memberDao.addFlightToMember(memberName, flight.getMileage());

	}
}
