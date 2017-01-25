package com.tddair;


public class TddAirApplication {
	
	private FlightDao flights = new FlightDao();
	
	public TddAirApplication() {
		
	}
	 
	public void addFlight(String origin, String destination, int mileage, String airline, int number) {
		flights.addFlight(origin, destination, mileage, airline, number);
	}

	public Flight findFlightByNumber(String flightNumber) {
		return flights.getFlightBy(flightNumber);
	}

	public void registerMember(String userId, String email) {
		// TODO Auto-generated method stub
		
	}

	public Member findMemberById(String userId) {
		return new Member(userId); 
	}
}
