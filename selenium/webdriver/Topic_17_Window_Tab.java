package webdriver;

import java.util.Set;
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

public class Topic_17_Window_Tab {

	WebDriver driver;
	WebElement element;
	JavascriptExecutor jsExecutor;
	Alert alert;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		jsExecutor = (JavascriptExecutor) driver;
	}

//	@Test
	public void TC_01_Window_ID() {
//		Parent Page 
		driver.get("https://automationfc.github.io/basic-form/");

//		Lấy ra được cái ID của tab hiện tại
		String basicFormID = driver.getWindowHandle();
		System.out.println("Parent window ID = " + basicFormID);

//		Click vào Google Link để bật ra 1 tab mới
		driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();
		sleepInSecond(5);

		switchToWindow(basicFormID);
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com.vn/");

		String googleWindowID = driver.getWindowHandle();
		switchToWindow(googleWindowID);
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/");
	}

//	@Test
	public void TC_02_Window_Title() {
		driver.get("https://automationfc.github.io/basic-form/index.html");

		driver.findElement(By.xpath("//a[text() = 'GOOGLE']")).click();
		switchToTitle("Google");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Google");

		switchToTitle("SELENIUM WEBDRIVER FORM DEMO");

		driver.findElement(By.xpath("//a[text() = 'FACEBOOK']")).click();
		switchToTitle("Facebook – log in or sign up");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");

		switchToTitle("SELENIUM WEBDRIVER FORM DEMO");

		driver.findElement(By.xpath("//a[text() = 'TIKI']")).click();
		switchToTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");

		switchToTitle("SELENIUM WEBDRIVER FORM DEMO");

	}

//	@Test
	public void TC_03_Window_Kyna() {
		driver.get("https://skills.kynaenglish.vn/");
		scrollToElement("div#k-footer");
		driver.findElement(By.xpath("//div[@id = 'k-footer']//img[@alt = 'facebook']")).click();

		switchToTitle("Kyna.vn - Home | Facebook");
		System.out.println(driver.getTitle());
		sleepInSecond(1);
		Assert.assertEquals(driver.getTitle(), "Kyna.vn - Home | Facebook");
		sleepInSecond(1);
		switchToTitle("Kyna.vn - Học online cùng chuyên gia");
		sleepInSecond(1);
		driver.findElement(By.xpath("//div[@id = 'k-footer']//img[@alt = 'youtube']")).click();

		switchToTitle("Kyna.vn - YouTube");
		System.out.println(driver.getTitle());
		sleepInSecond(1);
		Assert.assertEquals(driver.getTitle(), "Kyna.vn - YouTube");
		sleepInSecond(1);

		driver.close();
		switchToTitle("Kyna.vn - Home | Facebook");
		driver.close();
	}

//	@Test
	public void TC_04_Window_Tab_Techpanda() {
		driver.get("http://live.techpanda.org/");
		driver.findElement(By.xpath("//div//a[text() = 'Mobile']")).click();
		sleepInSecond(1);
		driver.findElement(By.xpath("(//div//a[@class = 'link-compare'])[2]")).click();
		sleepInSecond(1);
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[contains(text(), 'added to comparison list')]")).getText(),
				"The product Sony Xperia has been added to comparison list.");
		driver.findElement(By.xpath("(//div//a[@class = 'link-compare'])[1]")).click();
		sleepInSecond(1);
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[contains(text(), 'added to comparison list')]")).getText(),
				"The product Samsung Galaxy has been added to comparison list.");
		driver.findElement(By.xpath("//span[text() ='Compare']")).click();
		sleepInSecond(1);
		switchToTitle("Products Comparison List - Magento Commerce");
		Assert.assertEquals(driver.getTitle(), "Products Comparison List - Magento Commerce");
		driver.close();
		switchToTitle("Mobile");
		sleepInSecond(1);
		driver.findElement(By.xpath("//a[text() = 'Clear All']")).click();
		driver.switchTo().alert().accept();
		sleepInSecond(2);
		Assert.assertEquals(
				driver.findElement(By.xpath("//span[contains(text() , 'The comparison list was cleared.')]")).getText(),
				"The comparison list was cleared.");

	}

	@Test
	public void TC_05_Window_Tab_Dictionary() {
		driver.get("https://dictionary.cambridge.org/vi/");
		driver.findElement(By.xpath("//span//span[text() =  'Đăng nhập']")).click();
		switchToTitle("Login");
		sleepInSecond(1);
		driver.findElement(By.xpath("//input[@value = 'Log in']")).click();
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@data-bound-to = 'loginID' and @role]")).getText(),
				"This field is required");
		Assert.assertEquals(driver.findElement(By.xpath("//span[@data-bound-to = 'password' and @role]")).getText(),
				"This field is required");
		driver.findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys("automationfc.com@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password *']")).sendKeys("Automation000***");
		sleepInSecond(1);
		driver.findElement(By.xpath("//input[@value = 'Log in']")).click();
		sleepInSecond(1);
		switchToTitle("Cambridge Dictionary | Từ điển tiếng Anh, Bản dịch & Từ điển từ đồng nghĩa");
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text() =  'Automation FC']")).isDisplayed());
	}

	public void switchToTitle(String titleWindow) {
		Set<String> windowID = driver.getWindowHandles();

		for (String ID : windowID) {
			driver.switchTo().window(ID);
			sleepInSecond(1);
			String actualTitle = driver.getTitle();
			if (titleWindow.equals(actualTitle)) {
				sleepInSecond(1);
				break;
			}

		}
	}

	public void scrollToElement(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(locator)));
	}

	public void sleepInSecond(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void switchToWindow(String otherID) {
//		Lấy hết tất cả các ID ra
		Set<String> allWindowIDs = driver.getWindowHandles();

//		Sau đó dùng vòng lặp duyệt qua và kiểm tra
		for (String ID : allWindowIDs) {
			if (!ID.equals(otherID)) {
				driver.switchTo().window(ID);
				sleepInSecond(2);
			}
		}
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}

}
