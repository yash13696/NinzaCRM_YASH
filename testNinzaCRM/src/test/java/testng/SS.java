package testng;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class SS {

	public static void main(String[] args) throws IOException, InterruptedException {
			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			driver.get("https://www.facebook.com/");

			Date d = new Date();
			String newDate = d.toString().replace(" ", "_").replace(":", "_");

			TakesScreenshot ts = (TakesScreenshot) driver;
			File temp=ts.getScreenshotAs(OutputType.FILE);
			File perm=new File("./Screenshots/takeSS_"+newDate+".png");
			FileHandler.copy(temp, perm);
			
			Thread.sleep(2000);
			driver.quit();
		}

	}
