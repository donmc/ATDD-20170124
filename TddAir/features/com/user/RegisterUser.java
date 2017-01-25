package com.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.tddair.MemberManagement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterUser {

	MemberManagement app = new MemberManagement();

	@When("^user register with userid \"([^\"]*)\", email \"([^\"]*)\"$")
	public void user_register_with_userid_email(String userId, String emailId) throws Throwable {
		assertNotNull(app.findMember(userId));
	}

	@Then("^\"([^\"]*)\" should be saved$")
	public void should_be_saved(String arg1) throws Throwable {
		assertNotNull(app.findMember(arg1));
	}

	@Then("^error \"([^\"]*)\" is displayed$")
	public void error_is_displayed(String arg1) throws Throwable {
		assertEquals("", arg1);
		;
	}

}
