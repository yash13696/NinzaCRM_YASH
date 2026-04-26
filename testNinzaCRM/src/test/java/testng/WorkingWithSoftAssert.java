package testng;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WorkingWithSoftAssert {
	
	@Test
	public void demo() throws InterruptedException {
		String expectedTitle="Faceboo";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.facebook.com/");
		String actualTitle=driver.getTitle();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(expectedTitle, actualTitle);
		System.out.println("Step 1");
		System.out.println("Step 2");
		Thread.sleep(2000);
		driver.quit();
		soft.assertAll();
	}

}
