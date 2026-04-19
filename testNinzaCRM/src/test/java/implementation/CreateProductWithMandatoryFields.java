package implementation;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.PropertyUtility;
import genericUtility.SeleniumUtility;
import pom.AddProductPage;
import pom.HomePage;
import pom.LoginPage;

public class CreateProductWithMandatoryFields {

	public static void main(String[] args) throws IOException {
		PropertyUtility plib=new PropertyUtility();
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		SeleniumUtility slib=new SeleniumUtility();
		String BROWSER=plib.toReadDataFromProperties("browser");
		String URL=plib.toReadDataFromProperties("url");
		String USERNAME=plib.toReadDataFromProperties("username");
		String PASSWORD=plib.toReadDataFromProperties("password");
		
		String PRODUCTNAME=elib.toReadDataFromExcel("product", 1, 0);
		String PRICE=elib.toReadDataFromExcel("product", 1, 1);
		String QUANTITY=elib.toReadDataFromExcel("product", 1, 2);
		String PRODUCTCAT=elib.toReadDataFromExcel("product", 1, 3);
		String VENDOR=elib.toReadDataFromExcel("product", 1, 4);
	
		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			driver = new ChromeDriver(settings);
		} else if (BROWSER.equals("edge"))
			driver = new EdgeDriver();
		slib.maximize(driver);
		slib.implicitWait(driver);
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		HomePage hp =new HomePage(driver);
		AddProductPage app=new AddProductPage(driver);
		lp.getUSERNAME().sendKeys(USERNAME);
		lp.getPASSWORD().sendKeys(PASSWORD);
		lp.getLoginButton().click();
		hp.getProduct().click();
		app.getAddProduct().click();
//		String productName = "YashProduct1";
		app.getProductName().sendKeys(PRODUCTNAME+jlib.randomNumber());
//		WebElement productCat = driver.findElement(By.name("productCategory")).sendKeys(PRODUCTCAT);
		app.getProductCat().sendKeys(PRODUCTCAT);
//		Select prod = new Select(productCat);
//		prod.selectByValue("Electronics");
		WebElement qty = app.getQty();
		qty.clear();
		qty.sendKeys(QUANTITY);
		WebElement price = app.getPrice();
		price.clear();
		price.sendKeys(PRICE);
		WebElement vendor = app.getVendorId();
//		driver.findElement(By.name("vendorId")).sendKeys(VENDOR);
		slib.selectByValue(vendor, VENDOR);
		app.getCreateProduct().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toastmsg = hp.getToastmsg();
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg = toastmsg.getText();
		if (msg.contains(PRODUCTNAME))
			System.out.println("Product Successfully Created");
		else
			System.out.println("Product not Created!!!!");
		WebElement user = hp.getUsericon();
		slib.clickOnElement(driver, user);
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		driver.quit();
	}

}
