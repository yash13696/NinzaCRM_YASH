package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement USERNAME;
	
	@FindBy(id= "inputPassword")
	private WebElement PASSWORD;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement LoginButton;

	public WebElement getUSERNAME() {
		return USERNAME;
	}

	public WebElement getPASSWORD() {
		return PASSWORD;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	
	
}
