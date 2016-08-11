package continuum_automation.cucumber.Page;

import continuum_automation.cucumber.Locator;

public class QuickAccessPage {

	
	 WebdriverWrapper wd=new WebdriverWrapper();
	 public Locator quickAccessTab= new Locator("Quick Access tab","//a[@href='/QADashB/QuickAccess/QuickAcessServerDetails']");
	

	public void navigatetoQuickAccess() {
		wd.waitFor(1500);
		wd.clickElement(quickAccessTab);
		
	}
	
	public void verifyServerInformation(String datasheet){
		
	}
	

}
