package testng;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleDataProvider {
	
	@Test(dataProvider = "loginDetails")
	public void logInProgram(String UN, String PASS) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8098");
		driver.findElement(By.id("username")).sendKeys(UN);
		driver.findElement(By.id("inputPassword")).sendKeys(PASS);
		Thread.sleep(2000);
		driver.quit();
	}
	@DataProvider
	public Object[][] loginDetails(){
		Object[][] objarr=new Object[3][2];
		objarr[0][0]="varshini";
		objarr[0][1]="v@1234";
		
		objarr[1][0]="amruta";
		objarr[1][1]="a@1234";
		
		objarr[2][0]="yash";
		objarr[2][1]="y@1234";
		
		return objarr;
	}
}
