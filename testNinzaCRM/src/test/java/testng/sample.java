package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class sample {
	@Test(invocationCount = 6, priority = 0, threadPoolSize = 2, enabled = true)
	public void test() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.id("APjFqb")).sendKeys("chatgpt");
		Thread.sleep(2000);
		driver.quit();
	}
	@Test(dependsOnMethods = "test")
	public void test1() throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.id("APjFqb")).sendKeys("chatgpt");
		Thread.sleep(2000);
		driver.quit();

	}
	
	@Test
	public void test2() throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.id("APjFqb")).sendKeys("chatgpt");
		Thread.sleep(2000);
		driver.quit();

	}
}
