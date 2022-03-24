package pages;

import zoho.managers.WebDriverManager;

public class TopMenuComponent {

	WebDriverManager webDriverManager;
	
	public TopMenuComponent(WebDriverManager webDriverManager) {
		this.webDriverManager = webDriverManager;
		
	}
	
	public void load(String menuOption) {
		if(menuOption.equals("Leads")) {
			webDriverManager.click("leads_xpath");
		}
	}
}
