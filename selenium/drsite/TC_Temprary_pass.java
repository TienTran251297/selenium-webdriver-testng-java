package drsite;

import java.util.concurrent.TimeUnit;

import javax.swing.text.html.Option;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Temprary_pass {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		FirefoxOptions options = new FirefoxOptions();
//		driver = new FirefoxDriver(options);
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(firefoxBinary);
		options.setHeadless(true);  // <-- headless set here
		driver = new FirefoxDriver(options);
//		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("headless");
//		driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		driver.get("https://web-dr.staging.kod-hc.info/");
	}


	@Test
	public void TC_01() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tien.tran+4@codecomplete.jp");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Tien1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(4000);
		for (int i = 0; i < 1000; i++) {
			driver.findElement(By.xpath("//span[text()='患者一覧']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//td[text()='Testmedice']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//span[text()='患者一覧']")).click();
			System.out.println(i);
		}
		driver.quit();
	}
	
	@AfterClass
	public void AfterClass() {
//		driver.quit();
	}
}
