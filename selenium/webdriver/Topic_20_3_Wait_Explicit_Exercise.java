package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_3_Wait_Explicit_Exercise {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String Anh_01 = "Anh_01.jpg";
	String nameFileImage_1 = projectPath + "\\uploadFilePath\\" + Anh_01;
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 15);
	}

//	@Test
	public void TC_01() {
		driver.get(
				"https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");

		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.RadCalendar")));

		Assert.assertEquals(driver.findElement(By.xpath("//span[text() = 'No Selected Dates to display.']")).getText(),
				"No Selected Dates to display.");

		driver.findElement(By.xpath("//a[text() = '23']")).click();

		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(
				"div#ctl00_ContentPlaceholder1_RadAjaxLoadingPanel1ctl00_ContentPlaceholder1_RadCalendar1>div.raDiv")));

		Assert.assertEquals(driver.findElement(By.cssSelector("span#ctl00_ContentPlaceholder1_Label1")).getText(),
				"Friday, December 23, 2022");
	}

	@Test
	public void TC_02() {
		driver.get("https://gofile.io/uploadFiles");
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text() = 'Add files']")));
		
		driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(nameFileImage_1);
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text() = 'Your files have been successfully uploaded']")));
		
		driver.findElement(By.cssSelector("button#rowUploadSuccess-showFiles")).click();
		
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text() = '" + Anh_01 + "']"))).isDisplayed());
	}
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
