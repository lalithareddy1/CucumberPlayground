package zoho.managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.cucumber.messages.internal.com.google.protobuf.Duration;


public class WebDriverManager {
	
	
	WebDriver driver;
	ExtentTest test;
	Properties prop;
	SoftAssert softAssert;
	
	public WebDriverManager() {
		System.out.println("Calling WebDriver Manager Constructor");
		
		try {
			prop = new Properties();
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\zoho\\project.properties";
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		softAssert = new SoftAssert();
	}
	
	public void init(ExtentTest test) {		
		this.test = test;
	}
	
	public void log(String msg) {		
		test.log(Status.INFO, msg);
	}
	
	public void logFailure(String msg, boolean stopExecution) {
		//Screenshot of the page
		//Fail in Extent Report
		test.log(Status.FAIL, msg);	
		//Fail in Testng
		//Assert.fail(msg);
		
		softAssert.fail(msg);
		
		if(stopExecution)
			softAssert.assertAll();
		
		
	}
	
	public void quit() {
		if(driver != null) {
			driver.quit();
		}
		if(softAssert != null)
			softAssert.assertAll();
	}
	
	public void openBrowser(String browserName) {
		log("Opening Browser" + browserName);
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\driversfolder\\chromedriver_win32\\chromedriver.exe");
		if(browserName.equals("Mozilla")) {			
			driver = new FirefoxDriver();			
		}		
		else if(browserName.equals("Chrome")) {			
			driver = new ChromeDriver();
			
		}				
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}
	
		
	public void navigateUrl(String urlKey) {
		driver.get(getProperty(urlKey));
	}
	
	public void click(String locatorKey) {		
		//driver.findElement(getLocator(locatorKey)).click();
		findElement(locatorKey).click();
	}
	
	public void type(String locatorKey, String data) {		
		//driver.findElement(getLocator(locatorKey)).sendKeys(data);
		System.out.println("============" + data);
		findElement(locatorKey).sendKeys(data);
	}
	
	public String getTextValue(String locatorKey) {
		return findElement(locatorKey).getText();
		
	}
	
	public int getLeadRowNumberWithCellData(String leadName) {
		List<WebElement> leadnames = driver.findElements(getLocator("leadnames_css"));
		System.out.println(leadnames.size());
		System.out.println(leadnames.get(1));
		System.out.println(leadnames.get(5).getText());
		for(int i = 0; i<leadnames.size(); i++) {			
			if(leadName.equalsIgnoreCase(leadnames.get(i).getText())) {
				return (i + 1);
			}
			
		}
		return -1;

		
	}
	
	public void selectLeadCheckBox(int rowNum) {
		driver.findElement(By.cssSelector("lyte-exptable-tr:nth-child("+rowNum+") > lyte-exptable-td:nth-child(2) label")).click();
		
	}

	public WebElement findElement(String locatorKey) {
		
		By locator = getLocator(locatorKey);
		WebElement e = null;
		try {
			//presence and visibility
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
			e = driver.findElement(locator);
		}catch(Exception ex) {
			//report failure
			logFailure("Object is not Found for Locator" + locatorKey , true);

		}
		return e;
				
	}

	public By getLocator(String locatorKey) {
		
		if(locatorKey.endsWith("_xpath")) {
			return By.xpath(getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_id")) {
			System.out.println("Coming into ID Locator");
			return By.id(getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_css")) {
			return By.cssSelector(getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_name")) {
			return By.name(getProperty(locatorKey));
		}
		else
		return By.linkText(getProperty(locatorKey));
		
	}
	
	public String getProperty(String key) {
		return prop.getProperty(key);
		
	}
	
	
	/*---------------- Validations --------------------- */
	public boolean verifyTitle(String expectedTitleKey) {
		
		String expected_title = getProperty(expectedTitleKey);
		String actual_title = driver.getTitle();
		if(expected_title.equals(actual_title))
			return true;
		else
			return false;
					
		
	}
	
	public boolean isElementPresent(String locatorKey) {
		By locator = getLocator(locatorKey);
		try {
			//presence and visibility
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			
		}catch(Exception ex) {
			//report failure
			return false;

		}
		
		return true;
		
	}
	
	
	
}
