package zoho.context;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import zoho.managers.PageObjectManager;
import zoho.reports.ExtentManager;

public class TestContext {
	
	ExtentReports reports;
	ExtentTest test;
	
	private PageObjectManager pageObjectManager;
	
	
	public TestContext() {
		System.out.println("Calling Test Context Constructor");
		reports = ExtentManager.getReports();
		this.pageObjectManager = new PageObjectManager();
	}
	
	public PageObjectManager getPageObjectManager() {		
		return pageObjectManager;
	}
	
	public void createScenario(String scenatioName) {
		
		test = reports.createTest(scenatioName);
		//log("Creating Scenario");
		this.pageObjectManager.getWebDriverManager().init(test);;
	}

	public void endScenario() {
		this.pageObjectManager.getWebDriverManager().quit();
		reports.flush();
		
	}
	
	public void log(String msg) {
		this.pageObjectManager.getWebDriverManager().log(msg);
		//test.log(Status.INFO, msg);
		}
}
