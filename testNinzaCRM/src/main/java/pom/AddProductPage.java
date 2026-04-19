package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProductPage {

	public AddProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Add Product']")
	private WebElement addProduct;
	
	@FindBy(name = "productName")
	private WebElement productName;
	
	@FindBy(name = "productCategory")
	private WebElement productCat;
	
	@FindBy(name = "quantity")
	private WebElement qty;
	
	@FindBy(name = "price")
	private WebElement price;
	
	@FindBy(name = "vendorId")
	private WebElement vendorId;
	
	@FindBy(xpath = "//button[text()='Add']")
	private WebElement createProduct;

	public WebElement getAddProduct() {
		return addProduct;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCat() {
		return productCat;
	}

	public WebElement getQty() {
		return qty;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVendorId() {
		return vendorId;
	}

	public WebElement getCreateProduct() {
		return createProduct;
	}
	
	
}
