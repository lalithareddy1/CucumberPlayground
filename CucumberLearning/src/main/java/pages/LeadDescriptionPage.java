package pages;

import zoho.managers.WebDriverManager;

public class LeadDescriptionPage {
	
	WebDriverManager webDriverManager;
	
	public LeadDescriptionPage(WebDriverManager webDriverManager) {
		this.webDriverManager = webDriverManager;
		
	}
	
	public void hasLoaded() {
		
		if(!webDriverManager.isElementPresent("email_id")) {
			webDriverManager.logFailure("Lead Description Page is not loaded", true);
		}
	}
	
	public void verifyDetails() {		
		String leadname_value = webDriverManager.getTextValue("leadname_id");
		System.out.println("Value ===================  " + leadname_value);
		if(!leadname_value.equals("John Alex"))
			webDriverManager.logFailure("Lead Name is not Matching", true);
	}
	
	

}
