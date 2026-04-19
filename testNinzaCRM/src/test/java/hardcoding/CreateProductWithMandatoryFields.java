package hardcoding;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProductWithMandatoryFields {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		String productName="YashProduct";
		driver.findElement(By.name("productName")).sendKeys(productName);
		WebElement productCat=driver.findElement(By.name("productCategory"));
		Select prod=new Select(productCat);
		prod.selectByValue("Electronics");
		WebElement qty = driver.findElement(By.name("quantity"));
		qty.clear();
		qty.sendKeys("5");
		WebElement price = driver.findElement(By.name("price"));
		price.clear();
		price.sendKeys("500");
		WebElement vendor=driver.findElement(By.name("vendorId"));
		Select ven=new Select(vendor);
		ven.selectByValue("VID_004");
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toastmsg=driver.findElement(By.xpath("//div[@role='alert']"));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg=toastmsg.getText();
		if(msg.contains(productName))
			System.out.println("Product Successfully Created");
		else
			System.out.println("Product not Created!!!!");
		WebElement user=driver.findElement(By.className("user-icon"));
		Actions act=new Actions(driver);
		act.moveToElement(user).click().perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		driver.quit();
	}

}
