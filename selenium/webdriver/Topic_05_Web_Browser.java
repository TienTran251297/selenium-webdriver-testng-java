package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_Browser() {
//		các hàm tương tác với Browser sẽ thông qua biến driver
		
		driver.get("https://web-dr.dev.kod-hc.info/login");
		driver.findElement(By.xpath("//a[contains(text(), 'パスワードを忘れた方')]")).click();
		String webCurrent = driver.getCurrentUrl();
		System.out.println(webCurrent);
		driver.findElement(By.id("")).getText();
 	}

	@Test
	public void TC_02_ValidatePageTitle() {
//		các hàm tương tác với element sẽ thông qua biến element
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
