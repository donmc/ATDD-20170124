package com.tddair;


public class TddAirApplication {
	
	private FlightDao flights;
	private MemberDao memberDao;
	
	public TddAirApplication() {
	}
		
	public TddAirApplication(FlightDao flights, MemberDao memberDao) {
		super();
		this.flights = flights;
		this.memberDao = memberDao;
	}

	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public void registerMember(String userId, int id, String emailId) {
		memberDao.createMember(userId, id, emailId);				
	}

	public void completeFlight(String userId, String flightNumber) {
		
		Member member = memberDao.findMember(userId);
		Flight flight = flights.getFlightBy(flightNumber);
		member.completeFlight(flight);
	}

	public Member findMember(String userId) {
		return memberDao.findMember(userId);
	}

	public void purchaseSeatUpgrade(String userId, int qty) {
		Member member = memberDao.findMember(userId);
		member.purchaseSeatUpgrade(qty);
		
	}

}
