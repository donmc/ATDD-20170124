package com.tddair;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMemberSteps {
	private TddAirApplication app = new TddAirApplication(new RealFlightDao(), new RealMemberDao());
	private Member member;
	 
	@When("^user register with userid \"([^\"]*)\", email \"([^\"]*)\"$")
	public void user_register_with_userid_email(String userId, String email) throws Throwable {
	    app.registerMember(userId, email);
	}

	@Then("^\"([^\"]*)\" should be saved$")
	public void should_be_saved(String userId) throws Throwable {
	    member = app.findMemberById(userId);
	    Assert.assertNotNull(member);
	}
	
	@Then("^that member should have \"([^\"]*)\" status$")
	public void that_member_should_have_status(String status) throws Throwable {
	    Assert.assertEquals(status, member.getStatus().toString());
	}

}
