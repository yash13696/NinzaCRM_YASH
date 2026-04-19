package implementation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import baseClass.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.SeleniumUtility;
import pom.CreateCampaignPage;
import pom.HomePage;
import pom.LoginPage;

public class CreateCampaignWithMandatoryFields extends BaseClass {

	public static void main(String[] args) throws IOException {
		PropertyUtility plib=new PropertyUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		SeleniumUtility slib=new SeleniumUtility();
		String BROWSER=plib.toReadDataFromProperties("browser");
		String URL=plib.toReadDataFromProperties("url");
		String USERNAME=plib.toReadDataFromProperties("username");
		String PASSWORD=plib.toReadDataFromProperties("password");
		
		String CAMPAIGNNAME=elib.toReadDataFromExcel("campaign", 1, 0);
		String TARGETSIZE=elib.toReadDataFromExcel("campaign", 1, 1);
		
		WebDriver driver=null;
		
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
		driver.get(URL);
		LoginPage lp=new LoginPage(driver);
		HomePage hp=new HomePage(driver);
		CreateCampaignPage ccp =new CreateCampaignPage(driver);
		
		lp.getUSERNAME().sendKeys(USERNAME);
		lp.getPASSWORD().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		hp.getCreatecampaign().click();
		//String campaignName="NewCamapaignYashqwe";
		ccp.getCampaignName().sendKeys(CAMPAIGNNAME+jlib.randomAlphabet());
		WebElement targetsize = ccp.getTarget();
		targetsize.clear();
		targetsize.sendKeys(TARGETSIZE);
		ccp.getCreateCampaign().click();
		WebElement toastmsg=hp.getToastmsg();
		slib.explicitWait(driver, toastmsg);
		String msg=toastmsg.getText();
		if(msg.contains(CAMPAIGNNAME))
			System.out.println("Capaign Successfully Created");
		else
			System.out.println("Campaign not Created!!!!");
		WebElement user=hp.getUsericon();
		slib.clickOnElement(driver, user);
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		driver.quit();
		
	}

}
