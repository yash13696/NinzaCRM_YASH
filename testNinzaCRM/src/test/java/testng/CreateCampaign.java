package testng;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import org.openqa.selenium.WebElement;

import org.testng.Reporter;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;

import genericUtility.SeleniumUtility;
import pom.CreateCampaignPage;
import pom.HomePage;

public class CreateCampaign extends BaseClass {

	@Test(priority = 1)
	public void createCampaignWithMandatoryFields() throws EncryptedDocumentException, IOException {
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		SeleniumUtility slib = new SeleniumUtility();

		String CAMPAIGNNAME = elib.toReadDataFromExcel("campaign", 1, 0);
		String TARGETSIZE = elib.toReadDataFromExcel("campaign", 1, 1);

		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		// String campaignName="NewCamapaignYashqwe";
		ccp.getCampaignName().sendKeys(CAMPAIGNNAME + jlib.randomAlphabet());
		WebElement targetsize = ccp.getTarget();
		targetsize.clear();
		targetsize.sendKeys(TARGETSIZE);
		ccp.getCreateCampaign().click();
		WebElement toastmsg = hp.getToastmsg();
		slib.explicitWait(driver, toastmsg);
		String msg = toastmsg.getText();
		if (msg.contains(CAMPAIGNNAME))
			Reporter.log("Capaign Successfully Created");
		else
			Reporter.log("Campaign not Created!!!!");

	}

	@Test(priority = 2)
	public void createCampaignWithStatus() throws EncryptedDocumentException, IOException {

		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		SeleniumUtility slib = new SeleniumUtility();

		String CAMPAIGNNAME = elib.toReadDataFromExcel("campaign", 1, 0);
		String TARGETSIZE = elib.toReadDataFromExcel("campaign", 1, 1);
		String STATUS = elib.toReadDataFromExcel("campaign", 1, 2);

		HomePage hp = new HomePage(driver);
		CreateCampaignPage ccp = new CreateCampaignPage(driver);

		hp.getCreatecampaign().click();
		// String campaignName="NewCamapaignYashqwer";
		ccp.getCampaignName().sendKeys(CAMPAIGNNAME + jlib.randomAlphabet());
		ccp.getStatus().sendKeys(STATUS);
		WebElement targetsize = ccp.getTarget();
		targetsize.clear();
		targetsize.sendKeys(TARGETSIZE);
		ccp.getCreateCampaign().click();
		WebElement toastmsg = hp.getToastmsg();
		slib.explicitWait(driver, toastmsg);
		String msg = toastmsg.getText();
		if (msg.contains(CAMPAIGNNAME))
			Reporter.log("Capaign Successfully Created");
		else
			Reporter.log("Campaign not Created!!!!");
	}

	@Test(priority = 3)
	public void createCampaignWithExpectedDate() throws EncryptedDocumentException, IOException {

		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		SeleniumUtility slib = new SeleniumUtility();

		String CAMPAIGNNAME = elib.toReadDataFromExcel("campaign", 1, 0);
		String TARGETSIZE = elib.toReadDataFromExcel("campaign", 1, 1);

		HomePage hp = new HomePage(driver);
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		hp.getCreatecampaign().click();
		// String campaignName="NewCamapaignYasha";
		ccp.getCampaignName().sendKeys(CAMPAIGNNAME + jlib.randomAlphabet());
		WebElement targetsize = ccp.getTarget();
		targetsize.clear();
		targetsize.sendKeys(TARGETSIZE);
		String expdate = jlib.expectedDate();
		ccp.getExpectedCloseDate().sendKeys(expdate);
		ccp.getCreateCampaign().click();
		WebElement toastmsg = hp.getToastmsg();
		slib.explicitWait(driver, toastmsg);
		String msg = toastmsg.getText();
		if (msg.contains(CAMPAIGNNAME))
			Reporter.log("Capaign Successfully Created");
		else
			Reporter.log("Campaign not Created!!!!");

	}
}
