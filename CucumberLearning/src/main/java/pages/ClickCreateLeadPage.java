package pages;

import zoho.managers.WebDriverManager;

public class ClickCreateLeadPage {
	
	WebDriverManager webDriverManager;
	
	public ClickCreateLeadPage(WebDriverManager webDriverManager) {
	this.webDriverManager = webDriverManager;	
		
	}
	
	public void goToCreateLeadPage() {
		webDriverManager.click("createLeadPage_xpath");
		
	}

}
