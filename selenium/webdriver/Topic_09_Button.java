package webdriver;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_09_Button {
	//Khai báo
	WebDriver driver;
	WebElement element;
	
	//Khai báo + khởi tạo
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01() {
		driver.get("https://www.fahasa.com/customer/account/create");
		
		driver.findElement(By.xpath("//a[text() = 'Đăng nhập']")).click();
		
		Assert.assertFalse(driver.findElement(By.xpath("//button[@class = 'fhs-btn-login']")).isEnabled());
		
		driver.findElement(By.xpath("//input[@id = 'login_username']")).sendKeys("Tien@gmail.com");
		driver.findElement(By.xpath("//input[@id = 'login_password']")).sendKeys("Tien1234");
		
		Assert.assertTrue(driver.findElement(By.xpath("//button[@class = 'fhs-btn-login']")).isEnabled());
		
		String rgbaColor = driver.findElement(By.xpath("//button[@class = 'fhs-btn-login']")).getCssValue("background-color");
		
		String hexaColor = Color.fromString(rgbaColor).asHex().toUpperCase();
		
		Assert.assertEquals(hexaColor, "#C92127");
		
	}
	
	public void sleepSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
