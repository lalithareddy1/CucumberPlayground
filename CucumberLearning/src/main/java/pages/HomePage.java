package pages;

import zoho.managers.WebDriverManager;

public class HomePage {
	
	WebDriverManager webDriverManager;
	
	public HomePage(WebDriverManager webDriverManager) {
		
		this.webDriverManager = webDriverManager;
	}
	
	public void load(String browserName) { // open browser and navigate to Home page
		
		webDriverManager.openBrowser(browserName);
		webDriverManager.navigateUrl("url");
		if(!webDriverManager.verifyTitle("homepage_title"))
			webDriverManager.logFailure("Titles Do not Match", false);
		
	}
	
	
	public void gotoLoginPage(){
		webDriverManager.click("sigin_link_css");
		//verify whether login page is loaded
		if(!webDriverManager.isElementPresent("username_id"))
			webDriverManager.logFailure("Login Page did not loaded", true);
		
	}
}
