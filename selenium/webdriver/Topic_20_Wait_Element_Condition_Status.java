package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Wait_Element_Condition_Status {

	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait explicitWait;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		explicitWait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	@Test
	public void TC_01() {
		driver.get("https://www.facebook.com/");
		
//		1. Có trên UI (Bắt buộc)
//		1. Có trong HTML (Bắt buộc)
		
//		Wait cho email address textbox hiển thị
//		Chờ cho email address textbox hiển thị trong vòng 10s
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		driver.findElement(By.id("email")).sendKeys("test");
	}
	
//	@Test
	public void TC_02_Invisible_undisplayed_Invisibility_I() {
//		2. Không có trên UI (Bắt buộc)
//		1. Có trong HTML
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();

//		chờ cho Re-enter Email textbox không hiển thị trong vong 10s
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name = 'reg_email_confirmation__']")));
	}
	
//	@Test
	public void TC_02_Invisible_undisplayed_Invisibility_II() {
//		2. Không có trên UI (Bắt buộc)
//		2. Không có trong HTML
		
		driver.get("https://www.facebook.com/");
		
//		chờ cho Re-enter Email textbox không hiển thị trong vong 10s
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@name = 'reg_email_confirmation__']")));
	}
	
	@Test
	public void TC_03_Presence_I() {
//		1. Có trên UI (Bắt buộc)
//		1. Có trong HTML
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();

//		chờ cho Re-enter Email textbox không hiển thị trong vong 10s
		
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name = 'reg_email_confirmation__']")));
	}
	
	@Test
	public void TC_03_Presence_2() {
//		2. Không có trên UI 
//		1. Có trong HTML (Bắt buộc)
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();

//		chờ cho Re-enter Email textbox không hiển thị trong vong 10s
		
		explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name = 'reg_email_confirmation__']")));
	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}
