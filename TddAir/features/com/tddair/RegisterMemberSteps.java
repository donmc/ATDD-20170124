package com.tddair;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {
	
	TddAirApplication app = new TddAirApplication();
	Member member;
	
	@When("^user registers with id \"([^\"]*)\", email \"([^\"]*)\"$")
	public void user_registers_with_id_email(String id, String email) throws Throwable {
	    app.addMember(id, email);;
	}

	@Then("^user with id \"([^\"]*)\" should be saved$")
	public void user_with_id_should_be_saved(String id) throws Throwable {
	    member = app.findById(id);
	    Assert.assertNotNull(member);
	}
	
	@Then("^user has \"([^\"]*)\" status$")
	public void user_has_status(String arg1) throws Throwable {
		assertEquals("Red", member.getStatus());
	}

	@Then("^user has (\\d+) ytdMiles$")
	public void user_has_ytdMiles(int arg1) throws Throwable {
		assertEquals(0, member.getYtdMiles());
	}

	@Then("^user has (\\d+) balance miles$")
	public void user_has_balance_miles(int arg1) throws Throwable {
		assertEquals(10000, member.getLifetimeMilesBalance());
	}

}
