package com.tddair;


public class Flight {
	
	private String origin;
	private String destination;
	private String airline;
	private int number;
	private int mileage; 

	public Flight(String origin, String destination, int mileage, String airline, int number) {
		if(origin == null || origin.length() != 3) {
			throw new IllegalArgumentException("Invalid origin code");
		} 
		if(destination == null || destination.length() != 3) {
			throw new IllegalArgumentException("Invalid destination code");
		} 

		this.origin = origin;
		this.destination = destination;
		this.mileage = mileage;
		this.airline = airline;
		this.number = number;
	}
	
	
	public String getFullFlightNumber() { 
		if (airline == null) {
			return "UNKNOWN";
		} else if (airline.contains("AF")) {
			return "Air Force One";
		}
		
		if (number == 0) { 
			return "UNKNOWN";
		}
		
		return airline + number;
	} 
	
	public String getDestination() {
		return destination;
	}
	public String getOrigin() {
		return origin;
	}
	public int getMileage() {
		return mileage;
	}
	
}
