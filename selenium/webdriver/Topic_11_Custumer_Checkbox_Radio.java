package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Custumer_Checkbox_Radio {
	//Khai báo
	WebDriver driver;
	WebElement element;
	JavascriptExecutor jvExecutor;
	
	//Khai báo + khởi tạo
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		jvExecutor = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_Custumer_Checkbox() {
		driver.get("https://material.angular.io/components/checkbox/overview");
		By locaterClick = By.xpath("//span[text() = 'Check me!']//preceding-sibling::span//input");
		jvExecutor.executeScript("arguments[0].click();", driver.findElement(locaterClick));
		Assert.assertTrue(driver.findElement(locaterClick).isSelected());
	}

	@Test
	public void TC_02_Custumer_Radio() {
		driver.get("https://material.angular.io/components/radio/examples");
		jvExecutor.executeScript("arguments[0].click()", driver.findElement(By.xpath("//span[contains(text(), 'Summer')]//preceding-sibling::span//input")));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(text(), 'Summer')]//preceding-sibling::span//input")).isSelected());
	}
	
	@Test
	public void TC_03_Google_Form() {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		
		By daNangBy = By.xpath("//div[@aria-label = 'Đà Nẵng']");
//		Assert.assertEquals(driver.findElement(daNangBy).getAttribute("aria-checked"), "false");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label = 'Đà Nẵng' and @aria-checked = 'false']")).isDisplayed());		
		driver.findElement(daNangBy).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label = 'Đà Nẵng' and @aria-checked = 'true']")).isDisplayed());	
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
