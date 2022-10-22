package webdriver;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Popup {
	//Khai báo
	WebDriver driver;
	WebElement element;
	JavascriptExecutor jsExecutor;
	
	//Khai báo + khởi tạo
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01() {
		driver.get("https://ngoaingu24h.vn/");
		
		Assert.assertFalse(driver.findElement(By.xpath("(//div[@id='modal-login-v1'])[1]")).isDisplayed());
		
		driver.findElement(By.xpath("//div[@id = 'button-login-dialog']/button[text() = 'Đăng nhập']")).click();
		sleepInSecond(2);
		
		Assert.assertTrue(driver.findElement(By.xpath("(//div[@id='modal-login-v1'])[1]")).isDisplayed());
		
		driver.findElement(By.xpath("//div[@id = 'modal-login-v1' and @style]//input[@id ='account-input']")).sendKeys("Automation");
		driver.findElement(By.xpath("//div[@id = 'modal-login-v1' and @style]//input[@id ='password-input']")).sendKeys("Automation");
		driver.findElement(By.xpath("//div[@id = 'modal-login-v1' and @style]//button[text() ='Đăng nhập']")).click();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'modal-login-v1' and @style]//div[text() ='Tài khoản không tồn tại!']")).getText(), "Tài khoản không tồn tại!");		
	}

//	@Test
	public void TC_02() {
		driver.get("https://kyna.vn/");
		driver.findElement(By.xpath("//a[@title = 'Close']")).click();
		sleepInSecond(1);
		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='k-popup-account-login']")).isDisplayed());
		sleepInSecond(1);
		driver.findElement(By.xpath("//a[@class = 'login-btn']")).click();
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='k-popup-account-login']")).isDisplayed());
		
		driver.findElement(By.xpath("//input[@id = 'user-login']")).sendKeys("automation@gmail.com");
		driver.findElement(By.xpath("//input[@id = 'user-password']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='remember']")).click();
		sleepInSecond(1);
		driver.findElement(By.xpath("//button[@id = 'btn-submit-login']")).click();
		sleepInSecond(1);
//		String byString = driver.findElement(By.xpath("//div[@id = 'password-form-login-message']")).getText();
//		System.out.println(byString);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id = 'password-form-login-message']")).getText(),"Sai tên đăng nhập hoặc mật khẩu");
	}
	
//	@Test
	public void TC_03() {
		driver.get("https://tiki.vn/");
		Assert.assertEquals(driver.findElements(By.xpath("//div[@role= 'dialog']")).size(),0);
		driver.findElement(By.xpath("//span[text() = 'Đăng Nhập / Đăng Ký']")).click();
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@role= 'dialog']")).isDisplayed());
		sleepInSecond(1);
		driver.findElement(By.xpath("//p[text() = 'Đăng nhập bằng email']")).click();
		sleepInSecond(1);
		driver.findElement(By.xpath("//button[text() = 'Đăng nhập']")).click();
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//div//span[text() = 'Email không được để trống']")).getText(), "Email không được để trống");
		Assert.assertEquals(driver.findElement(By.xpath("//div//span[text() = 'Mật khẩu không được để trống']")).getText(), "Mật khẩu không được để trống");
		driver.findElement(By.xpath("//img[@class='close-img']")).click();
		sleepInSecond(1);
		Assert.assertEquals(driver.findElements(By.xpath("//div[@role= 'dialog']")).size(), 0);
	}
	
//	@Test
	public void TC_04() {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//a[text() = 'Create New Account']")).click();
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//div[text() = 'Sign Up']/parent::div/parent::div")).isDisplayed());
		driver.findElement(By.xpath("//div[text() = 'Sign Up']/parent::div/parent::div/img")).click();
		sleepInSecond(1);
		Assert.assertEquals(driver.findElements(By.xpath("//div[text() = 'Sign Up']/parent::div/parent::div")).size(),0);
	}
	
//	@Test
	public void TC_05_Random_In_DOM() {
		driver.get("https://www.javacodegeeks.com/");
		sleepInSecond(10);		
		WebElement popup = driver.findElement(By.xpath("//div[@class= 'lepopup-popup-container']/div[not(contains(@style, 'display:none'))]"));		
		if (popup.isDisplayed()) {
			driver.findElement(By.xpath("//div//a[text() = '×']")).click();
		} 
	}	
	
//	@Test
	public void TC_06_Random_IN_DOM_2() {
		driver.get("https://kmplayer.com/");
		sleepInSecond(10);
		WebElement popup = driver.findElement(By.xpath("//div/img[@id = 'support-home']"));
		if (popup.isDisplayed()) {
			jsExecutor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//area[@id = 'btn-r']")));
			sleepInSecond(1);
			driver.findElement(By.xpath("//div/a[@class = 'mb_sp mb_btn2 support-layer']")).click();
			sleepInSecond(1);
		}
	}
	
	@Test
	public void TC_07_Random_NO_IN_DOM() {
		driver.get("https://dehieu.vn/");
		sleepInSecond(10);
		List<WebElement> popup = driver.findElements(By.xpath("//div[@class = 'popup-content']"));
		if (popup.size()>0 && popup.get(0).isDisplayed()) {
			driver.findElement(By.xpath("//button[@id = 'close-popup']")).click();
			sleepInSecond(1);
			Assert.assertEquals(driver.findElement(By.xpath("//h2[text() = 'KHÓA HỌC NHIỀU NGƯỜI MUA NHẤT']")).getText(), "KHÓA HỌC NHIỀU NGƯỜI MUA NHẤT");
			sleepInSecond(1);
		}
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void scrollToElement(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(locator)));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
