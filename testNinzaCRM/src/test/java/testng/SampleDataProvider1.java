package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider1 {
	@Test(dataProvider = "searchDetails")
	public void logInProgram(String search) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://demowebshop.tricentis.com/");
		driver.findElement(By.id("small-searchterms")).sendKeys(search);
		Thread.sleep(2000);
		driver.quit();
	}
	@DataProvider
	public Object[] searchDetails(){
		Object[] objarr=new Object[4];
		
		objarr[0]="sunglasses";
		
		objarr[1]="mobile";
		
		objarr[2]="iphone";
		
		objarr[3]="laptop";
		
		return objarr;
	}

}
