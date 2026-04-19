package genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	public void explicitWait(WebDriver diver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(diver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void selectByIndex(WebElement address, int index) {
		Select sel = new Select(address);
		sel.selectByIndex(index);
	}

	public void selectByValue(WebElement address, String value) {
		Select sel = new Select(address);
		sel.selectByValue(value);
	}

	public void selectByVisibleText(WebElement address, String text) {
		Select sel = new Select(address);
		sel.selectByVisibleText(text);
	}

	public void moveToElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
	}

	public void clickOnElement(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}
	
	//add more methods 

}
