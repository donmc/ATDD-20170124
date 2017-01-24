import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterMember {
	@When("^user registers with id \"([^\"]*)\", email \"([^\"]*)\"$")
	public void user_registers_with_id_email(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user with id \"([^\"]*)\" should be saved$")
	public void user_with_id_should_be_saved(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user registers with preexistingId \"([^\"]*)\",  email \"([^\"]*)\"$")
	public void user_registers_with_preexistingId_email(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Error \"([^\"]*)\" is displayed$")
	public void error_is_displayed(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user enters invalid Email \"([^\"]*)\"$")
	public void user_enters_invalid_Email(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
