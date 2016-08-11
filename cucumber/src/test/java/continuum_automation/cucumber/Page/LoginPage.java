package continuum_automation.cucumber.Page;

import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import continuum_automation.cucumber.Locator;

public class LoginPage {
	
	 WebdriverWrapper wd=new WebdriverWrapper();

	public Locator emailId= new Locator("Login email id textbox", "user_txt","id");
	public Locator password= new Locator("Login password text box", "user_pass","id");
	public Locator loginBtn= new Locator("Login button", "//button[@value='Submit']//em[contains(.,'Login')]");
	public Locator rememberMeCheckbox=new Locator("Remember me checkbox","//span[@class='cust_checkbox checkbox cust_checkbox_off']");
	
	public void loginToITSPortal(String emaild, String pwd){
		//System.out.println("lp driver id:"+ wd.driver);
		wd.waitFor(3000);
	  Reporter.log("Enter login credentials  to ITS portal");
	    wd.waitForElementToBeClickable(emailId,3000);
		wd.clearandSendKeys(emaild, emailId);
		wd.clearandSendKeys(pwd, password);
		wd.changeCheckboxStatus( rememberMeCheckbox,"check");
		wd.clickElement(loginBtn);
		 if(wd.isAlertPresent())
			    wd.acceptAlert();
		
			 wd.clearandSendKeys(emaild, emailId);
			 wd.clearandSendKeys(pwd, password);
   			wd.clickElement(loginBtn);
	  
				
	}

	

}
