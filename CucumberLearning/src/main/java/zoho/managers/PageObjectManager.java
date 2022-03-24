package zoho.managers;

import pages.ClickCreateLeadPage;
import pages.CreateLeadPage;
import pages.HomePage;
import pages.LeadDescriptionPage;
import pages.LeadDetailPage;
import pages.LoginPage;
import pages.TopMenuComponent;

public class PageObjectManager {
	
	HomePage homePage;
	LoginPage loginpage;
	WebDriverManager webDriverManager;
	TopMenuComponent topMenu;
	ClickCreateLeadPage clickCreateLead;
	LeadDetailPage leadDetailPage;
	CreateLeadPage createLeadPage;
	LeadDescriptionPage leadDescriptionPage;
	
	public PageObjectManager() {
		System.out.println("Calling Page Object Manager Constructor");
		this.webDriverManager = new WebDriverManager();
	}
	
	public WebDriverManager getWebDriverManager() {		
		return webDriverManager;
	}
	
	
	public HomePage getHomePage() {
		
		if(homePage == null) {
			homePage = new HomePage(webDriverManager);
		}
		
		return homePage;
	}
	
	public LoginPage getLoginPage() {
		
		if(loginpage == null) {
			loginpage = new LoginPage(webDriverManager);
		}
		
		return loginpage;
	}
	
	public TopMenuComponent getTopMenu() {
		
		if(topMenu == null) {
			topMenu = new TopMenuComponent(webDriverManager);
		}
		return topMenu;
	}
	
	public ClickCreateLeadPage getClickCreateLead() {
		if(clickCreateLead == null) {
			clickCreateLead = new ClickCreateLeadPage(webDriverManager);
		}
		return clickCreateLead;
		
	}
	
	
	public LeadDetailPage getleadsDetailPage() {
		
		if(leadDetailPage == null) {
			leadDetailPage = new LeadDetailPage(webDriverManager);
		}
		return leadDetailPage;
		
	}
	
	public CreateLeadPage getCreateLeadPage() {
		
		if(createLeadPage == null) {
			createLeadPage = new CreateLeadPage(webDriverManager);
		}
		return createLeadPage;
		
	}
	
	public LeadDescriptionPage getLeadDescriptionPage() {
		if(leadDescriptionPage == null) {
			leadDescriptionPage = new LeadDescriptionPage(webDriverManager);
		}
		return leadDescriptionPage;
		
	}

}
