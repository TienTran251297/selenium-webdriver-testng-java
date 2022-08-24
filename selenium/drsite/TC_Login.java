package drsite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://web-dr.staging.kod-hc.info/");
		
	}

	@Test
	public void TC_01() {
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'ID / メールアドレスを入力してください')]")).getText(), "ID / メールアドレスを入力してください");
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'パスワードを入力してください')]")).getText(), "パスワードを入力してください");
	}
	
	@Test
	public void TC_02() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tien.tran+4@codecomplete.jp");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("tien1234");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='error-txt mb10']")).getText(), "メールアドレスまたはパスワードが正しくありません。(コード: 400 )");
	}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
	
	
}
