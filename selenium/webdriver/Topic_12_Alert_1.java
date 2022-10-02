package webdriver;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Alert_1 {
	//Khai báo
	WebDriver driver;
	WebElement element;
	Alert alert;
	JavascriptExecutor jsExecutor;
	
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

//	@Test
	public void TC_01_Alert_Accpect() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text() = 'Click for JS Alert']")).click();
		sleepInSecond(3);
		
//		Switch qua alert
		alert = driver.switchTo().alert();

		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		alert.accept();
		
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//p[text() = 'You clicked an alert successfully ']")).getText(), "You clicked an alert successfully");
		
	}

//	@Test
	public void TC_02_Confirm_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text() = 'Click for JS Confirm']")).click();
		sleepInSecond(3);
		
//		Switch qua alert
		alert = driver.switchTo().alert();

		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.dismiss();
		
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//p[text() = 'You clicked: Cancel']")).getText(), "You clicked: Cancel");
		driver.findElement(By.xpath("//button[text() = 'Click for JS Confirm']")).click();
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		alert.accept();
		Assert.assertEquals(driver.findElement(By.xpath("//p[text() = 'You clicked: Ok']")).getText(), "You clicked: Ok");
	}
	
//	@Test
	public void TC_03_Prompt_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']")).click();
		sleepInSecond(3);
		
//		Switch qua alert
		alert = driver.switchTo().alert();

		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		alert.sendKeys("Text");
		alert.dismiss();
		
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//p[text() = 'You entered: null']")).getText(), "You entered: null");
		driver.findElement(By.xpath("//button[text() = 'Click for JS Prompt']")).click();
		sleepInSecond(3);
		
//		Switch qua alert
		alert = driver.switchTo().alert();

		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		alert.sendKeys("Text");
		alert.accept();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//p[text() = 'You entered: Text']")).getText(), "You entered: Text");
	}
	
//	@Test
	public void TC_04_Alert_Login() {
		driver.get("https://demo.guru99.com/v4/");
		driver.findElement(By.xpath("//input[@name = 'btnLogin']")).click();
		sleepInSecond(3);
		alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), "User or Password is not valid");
		alert.accept();
		sleepInSecond(3);
		Assert.assertEquals(driver.getCurrentUrl(), "https://demo.guru99.com/v4/index.php");
	}
	
//	@Test
	public void TC_05_Authentication_Alert_Login() {
		/***
		 * Pass hẳn User/ password vào Url truoncwcs khi open nó ra
		 * Url: http://the-internet.herokuapp.com/basic_auth
		 * Pass: Username/ Password vào url (admin/admin)
		 * http://username:password@the-internet.herokuapp.com/basic_auth
		 */
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		sleepInSecond(3);
		Assert.assertTrue(driver.findElement(By.xpath("//div//p")).getText().contains("Congratulations! You must have the proper credentials."));
	}
	
	@Test
	public void TC_06_Authentication_Alert_Login() {
		driver.get("http://the-internet.herokuapp.com/");
		String urlString = driver.findElement(By.xpath("//a[text() = 'Basic Auth']")).getAttribute("href");
		driver.get(getUrlAuthen(urlString, "admin", "admin"));
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(By.xpath("//div//p")).getText().contains("Congratulations! You must have the proper credentials."));
	}
	
	public void sleepInSecond(long second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public String getUrlAuthen(String urlString, String userName, String passWord) {
		String[] authenUrlArray = urlString.split("//");
		urlString = authenUrlArray[0] + "//" + userName + ":" + passWord + "@" + authenUrlArray[1];
		return urlString;
	}
	
	public void scrollToElement(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(locator)));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
