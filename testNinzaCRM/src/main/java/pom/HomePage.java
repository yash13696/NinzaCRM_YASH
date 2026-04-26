package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Create Campaign']")
	private WebElement createcampaign;
	
	@FindBy(linkText = "Products")
	private WebElement product;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement toastmsg;
	
	@FindBy(className = "user-icon")
	private WebElement usericon;
	
	@FindBy(xpath = "//div[@class='dropdown-item logout']")
	private WebElement logout;

	public WebElement getCreatecampaign() {
		return createcampaign;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getToastmsg() {
		return toastmsg;
	}

	public WebElement getUsericon() {
		return usericon;
	}

	public WebElement getLogout() {
		return logout;
	}

}
