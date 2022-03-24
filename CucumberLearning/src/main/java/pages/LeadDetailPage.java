package pages;

import zoho.managers.WebDriverManager;

public class LeadDetailPage {
	
	WebDriverManager webDriverManager;
	
	public LeadDetailPage(WebDriverManager webDriverManager) {
		
		this.webDriverManager = webDriverManager;
	}
	
//	public void goToCreateLeadPage() {
//		webDriverManager.click("createLeadPage_xpath");
//		
//	}
	
	public void validateLeadPresent(String leadName) {
		int rowNum = webDriverManager.getLeadRowNumberWithCellData(leadName);
		if(rowNum == -1)
			webDriverManager.logFailure("Lead not found inlead list", true);

	
	}
	
	public void validateLeadNotPresent(String leadName) {
		int rowNum = webDriverManager.getLeadRowNumberWithCellData(leadName);
		if(rowNum != -1)
			webDriverManager.logFailure("Lead  found in lead list", true);

	}
	
	public void selectLead(String leadName) {
		int rowNum = webDriverManager.getLeadRowNumberWithCellData(leadName);
		if(rowNum == -1)
			webDriverManager.logFailure("Lead not found in lead list", true);
		
		webDriverManager.log(leadName +" lead Row Number is "+rowNum);
         
		// locator will be dynamic		
		webDriverManager.selectLeadCheckBox(rowNum);
		webDriverManager.click("action_id");
		webDriverManager.click("delete_xpath");
		webDriverManager.click("delete_alert_xpath");
	}

   
  


}
