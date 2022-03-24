package pages;

import zoho.managers.WebDriverManager;
import zoho.teststeps.data.LeadData;

import java.util.*;

public class CreateLeadPage {
	
	WebDriverManager webDriverManager;
	
	public CreateLeadPage(WebDriverManager webDriverManager) {
		
		this.webDriverManager = webDriverManager;
	}
	
	public void submitLeadDetails(List<LeadData> leadData) {
		webDriverManager.type("firstName_id", leadData.get(0).firstName);
		webDriverManager.type("lastName_id", leadData.get(0).lastName);
		webDriverManager.type("company_id", leadData.get(0).company);
		webDriverManager.type("email_id", leadData.get(0).email);
		webDriverManager.click("savebutton_id");


		
	}

}
