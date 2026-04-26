package testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WorkingWithHardAssert{
	
	
	@Test
	public void demo() throws InterruptedException {
		String expectedTitle="Facebook";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com/");
		String actualTitle=driver.getTitle();
		
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Step 1");
		System.out.println("Step 2");
		Thread.sleep(2000);
		driver.quit();
	}

}
