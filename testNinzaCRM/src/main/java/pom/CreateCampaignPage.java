package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {
	
	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[text()='Create Campaign']")
	private WebElement createCampaign;
	
	@FindBy(name = "campaignName")
	private WebElement campaignName;
	
	@FindBy(name = "targetSize")
	private WebElement target;
	
	@FindBy(name="expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy(name = "campaignStatus")
	private WebElement status;

	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getTarget() {
		return target;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getStatus() {
		return status;
	}
	
	
}
