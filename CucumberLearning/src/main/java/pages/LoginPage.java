package pages;

import zoho.managers.WebDriverManager;

public class LoginPage {
	
	WebDriverManager webDriverManager;
	
	
	public LoginPage(WebDriverManager webDriverManager) {
		this.webDriverManager = webDriverManager;

	}
	
	public void doLogin() {
		webDriverManager.type("username_id", "lalitha517.sudireddy@gmail.com");
		webDriverManager.click("nextbutton_id");
		webDriverManager.type("password_name", "Frenchstreet@3010");
		webDriverManager.click("sigin_id");
		webDriverManager.click("crm_xpath");
		
	}

}
