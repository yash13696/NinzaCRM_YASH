package testng;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.BaseClass;
import genericUtility.ExcelUtility;
import genericUtility.JavaUtility;
import genericUtility.SeleniumUtility;
import pom.AddProductPage;
import pom.HomePage;

public class CreateProduct extends BaseClass {
	
	@Test (priority = 1)
	public void CreateProductWithMandatoryFields() throws IOException {
	
	ExcelUtility elib=new ExcelUtility();
	JavaUtility jlib=new JavaUtility();
	SeleniumUtility slib=new SeleniumUtility();
	
	String PRODUCTNAME=elib.toReadDataFromExcel("product", 1, 0);
	String PRICE=elib.toReadDataFromExcel("product", 1, 1);
	String QUANTITY=elib.toReadDataFromExcel("product", 1, 2);
	String PRODUCTCAT=elib.toReadDataFromExcel("product", 1, 3);
	String VENDOR=elib.toReadDataFromExcel("product", 1, 4);
	
	AddProductPage app=new AddProductPage(driver);
	HomePage hp=new HomePage(driver);
	hp.getProduct().click();
	app.getAddProduct().click();
//	String productName = "YashProduct1";
	app.getProductName().sendKeys(PRODUCTNAME+jlib.randomNumber());
//	WebElement productCat = driver.findElement(By.name("productCategory")).sendKeys(PRODUCTCAT);
	app.getProductCat().sendKeys(PRODUCTCAT);
//	Select prod = new Select(productCat);
//	prod.selectByValue("Electronics");
	WebElement qty = app.getQty();
	qty.clear();
	qty.sendKeys(QUANTITY);
	WebElement price = app.getPrice();
	price.clear();
	price.sendKeys(PRICE);
	WebElement vendor = app.getVendorId();
//	driver.findElement(By.name("vendorId")).sendKeys(VENDOR);
	slib.selectByValue(vendor, VENDOR);
	app.getCreateProduct().click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement toastmsg = hp.getToastmsg();
	wait.until(ExpectedConditions.visibilityOf(toastmsg));
	String msg = toastmsg.getText();
	Assert.assertTrue(msg.contains(PRODUCTNAME));
	
}
}

