package continuum_automation.cucumber.stepDefinations;

import continuum_automation.cucumber.Page.PageFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DashBoardStepDefinations extends PageFactory {
	@Given("^User can Login to ITS portal \"([^\"]*)\" and  \"([^\"]*)\"$")
	public void user_can_Login_to_ITS_portal(String emailId, String pwd) throws Throwable {
        loginPage.loginToITSPortal(emailId, pwd);
	}

	@When("^User should navigate to QuickAccess->Site -> Server$")
	public void user_should_navigate_to_QuickAccess_Site_Server() throws Throwable {
		quickAccessPage.navigatetoQuickAccess();
		
	}

	@Then("^Validate details of server table from Datasheet \"([^\"]*)\"$")
	public void validate_details_of_server_table(String Datasheet) throws Throwable {
		quickAccessPage.verifyServerInformation(Datasheet);
	}

	@Then("^ Validate total server count$")
	public void validateServerCount() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

}
