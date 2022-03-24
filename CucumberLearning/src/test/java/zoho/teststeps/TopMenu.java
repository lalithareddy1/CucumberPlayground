package zoho.teststeps;

import io.cucumber.java.en.When;
import pages.TopMenuComponent;
import zoho.context.TestContext;

public class TopMenu {
	
	public TestContext context;
	public TopMenuComponent topMenu;
	
	public TopMenu(TestContext context) {
		System.out.println("Calling TopMenu Constructor");
		this.context = context;
		this.topMenu = context.getPageObjectManager().getTopMenu();
	}
	
	
	@When("I click on {string} in top menu")
	public void loadPage(String TopmenuName) {
		context.log("I click on " + TopmenuName + "in top menu");
		topMenu.load(TopmenuName);
		
		
		
	}

}
