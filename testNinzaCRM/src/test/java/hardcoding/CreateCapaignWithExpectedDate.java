package hardcoding;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateCapaignWithExpectedDate {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://49.249.28.218:8098/");
		driver.findElement(By.id("username")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		String campaignName="NewCamapaignYashq";
		driver.findElement(By.name("campaignName")).sendKeys(campaignName);
		WebElement targetsize = driver.findElement(By.name("targetSize"));
		targetsize.clear();
		targetsize.sendKeys("7");
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-YYYY");
		String currentdate=sim.format(d);
		Calendar cal=sim.getCalendar();
		cal.add(cal.DAY_OF_MONTH, 20);
		String expdate=sim.format(cal.getTime());
		driver.findElement(By.name("expectedCloseDate")).sendKeys(expdate);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement toastmsg=driver.findElement(By.xpath("//div[@role='alert']"));
		wait.until(ExpectedConditions.visibilityOf(toastmsg));
		String msg=toastmsg.getText();
		if(msg.contains(campaignName))
			System.out.println("Capaign Successfully Created");
		else
			System.out.println("Campaign not Created!!!!");
		WebElement user=driver.findElement(By.className("user-icon"));
		Actions act=new Actions(driver);
		act.moveToElement(user).click().perform();
		driver.findElement(By.xpath("//div[@class='dropdown-item logout']")).click();
		driver.quit();
	}

}
