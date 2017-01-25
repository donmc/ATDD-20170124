package com.tddair;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddFlightSteps {
	TddAirApplication app = new TddAirApplication(new RealFlightDao(), new RealMemberDao()); 
	private String message;
	
	@When("^adding a flight with origin \"([^\"]*)\", destination \"([^\"]*)\", miles (\\d+), airline \"([^\"]*)\", and number (\\d+)$")
	public void adding_a_flight_with_origin_destination_miles_airline_and_number(String origin, String destination, int miles, String airline, int number) throws Throwable {
	    try {
	    	app.addFlight(origin, destination, miles, airline, number);
	    }catch (Exception e) {
			this.message = e.getMessage();
		}
	}

	@Then("^flight \"([^\"]*)\" exists$")
	public void flight_exists(String flightNumber) throws Throwable {
	    Flight flight = app.findFlightByNumber(flightNumber);
	    Assert.assertNotNull(flight);
	}
	
	@Then("^error \"([^\"]*)\" is displayed$")
	public void error_is_displayed(String message) throws Throwable {
	   Assert.assertEquals(message, this.message);
	}

}
