package baseClass;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.SeleniumUtility;
import pom.HomePage;
import pom.LoginPage;

public class BaseClass {
	WebDriver driver= null;
	PropertyUtility plib=new PropertyUtility();
	ExcelUtility elib=new ExcelUtility();
	JavaUtility jlib=new JavaUtility();
	SeleniumUtility slib=new SeleniumUtility();
	
	@BeforeSuite
	public void beforeSuit() throws IOException {
		String BROWSER=plib.toReadDataFromProperties("browser");
		if(BROWSER.equals("chrome"))
		{
			ChromeOptions settings=new ChromeOptions();
			Map<String, Object> prefs=new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver=new ChromeDriver(settings);
		}
		else if(BROWSER.equals("edge"));
			driver=new EdgeDriver();
		slib.maximize(driver);
		slib.implicitWait(driver);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		String URL=plib.toReadDataFromProperties("url");
		String USERNAME=plib.toReadDataFromProperties("username");
		String PASSWORD=plib.toReadDataFromProperties("password");
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		lp.getUSERNAME().sendKeys(USERNAME);
		lp.getPASSWORD().sendKeys(PASSWORD);
		lp.getLoginButton().click();
	}
	
	@AfterMethod
	public void afterMethod() {
		HomePage hp=new HomePage(driver);
		WebElement user=hp.getUsericon();
		slib.clickOnElement(driver, user);
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
	}
	
	public void afterSuit() {
		driver.quit();
	}
	
}
