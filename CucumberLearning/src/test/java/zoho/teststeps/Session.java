package zoho.teststeps;

import io.cucumber.java.en.Given;
import pages.HomePage;
import pages.LoginPage;
import zoho.context.TestContext;

public class Session {
	
	public TestContext context;
	public HomePage homepage;
	public LoginPage loginpage;
	
	
	public Session(TestContext context) {
		System.out.println("Calling Session Constructor");
		this.context = context;
		this.homepage = this.context.getPageObjectManager().getHomePage();
		this.loginpage = this.context.getPageObjectManager().getLoginPage();
	}
	
	@Given("I am logged in Zoho.com")
	public void zohoLogin() {
		System.out.println("Iam logged in to the website");
		homepage.load("Chrome");
		homepage.gotoLoginPage();
		loginpage.doLogin();
	}

}
