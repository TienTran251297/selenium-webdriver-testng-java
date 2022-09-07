package drsite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
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
		driver = new FirefoxDriver();
		
//		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
//		driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		driver.get("https://web-dr.staging.kod-hc.info/");
	}


	@Test
	public void TC_01() throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'ID / メールアドレスを入力してください')]")).getText(), "ID / メールアドレスを入力してください");
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'パスワードを入力してください')]")).getText(), "パスワードを入力してください");
	}
	
	@Test
	public void TC_02() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tien.tran+4@codecomplete.jp");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("tien1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//p[@class='error-txt mb10']")).getText(), "メールアドレスまたはパスワードが正しくありません。(コード: 400 )");
	}
	
	@Test
	public void TC_03() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tien.tra@codecomplete.jp");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Tien1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'メールアドレスまたはパスワードが正しくありません。(コード: 404 )')]")).getText(), "メールアドレスまたはパスワードが正しくありません。(コード: 404 )");
		}
	@Test
	
	public void TC_04() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tien.tracodecomplete.jp");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Tien1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'メールアドレスの形式が違います。')]")).getText(), "メールアドレスの形式が違います。");
		}
	
	@Test
	public void TC_05() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Tien1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'ID / メールアドレスを入力してください')]")).getText(), "ID / メールアドレスを入力してください");
		}
	
	@Test
	public void TC_06() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tien.tran+4@codecomplete.jp");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'パスワードを入力してください')]")).getText(), "パスワードを入力してください");
		}
	
	@Test
	public void TC_07() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tien.tran+4@codecomplete.jp");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Tien1234");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'患者さまのnanacaraアプリで発行した、ワンタイムパスワードを確認してください。')]")).getText(), "患者さまのnanacaraアプリで発行した、ワンタイムパスワードを確認してください。");
		}
	
	@Test
	public void TC_08() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(By.xpath("//span[contains(text(),'ログアウト')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[contains(text(), 'OK')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='text']")).clear();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("tien.tran+5@codecomplete.jp");
		driver.findElement(By.xpath("//input[@type='password']")).clear();
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("YFSwmQffY1");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.xpath("//p[contains(text(),'正式なパスワードを入力してください')]")).getText(), "正式なパスワードを入力してください");
		}
	
	@AfterClass
	public void AfterClass() {
		driver.quit();
	}
}
