package com.tddair;

public interface FlightDao {

	Flight getFlightBy(String flightNumber);

	void addFlight(String origin, String destination, int mileage, String airline, int number);

}