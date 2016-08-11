package continuum_automation.cucumber.Page;

import org.openqa.selenium.WebDriver;

import continuum_automation.cucumber.DriverFactory;


public class PageFactory {

       
	//public static WebDriver driver=DriverFactory.getDriver();

	public LoginPage loginPage=new LoginPage();
	
	public HomePage homePage=new HomePage();
	public QuickAccessPage quickAccessPage=new QuickAccessPage();
}
