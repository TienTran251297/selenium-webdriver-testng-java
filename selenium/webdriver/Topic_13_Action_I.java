package webdriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Action_I {
	//Khai báo
	WebDriver driver;
	WebElement element;
	JavascriptExecutor jsExecutor;
	Actions action;
	
	//Khai báo + khởi tạo
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		action = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_Hover_Tooltip() {
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
		sleepInSecond(1);
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class= 'ui-tooltip-content']")).getText(), "We ask for your age only for statistical purposes.");
	}

//	@Test
	public void TC_02_Hover_To_Link_1() {
		driver.get("https://www.myntra.com/");
		action.moveToElement(driver.findElement(By.xpath("//header[@id = 'desktop-header-cnt']//a[text() = 'Kids']"))).perform();
		sleepInSecond(1);
		action.click(driver.findElement(By.xpath("//li//a[text() = 'Home & Bath']"))).perform();
		sleepInSecond(2);
		Assert.assertEquals(driver.findElement(By.xpath("//div//h1[text() = 'Kids Home Bath']")).getText(), "Kids Home Bath");
	}
	
//	@Test
	public void TC_03_Hover_To_Link_2() {
		driver.get("https://www.fahasa.com/");
		action.moveToElement(driver.findElement(By.xpath("//span[@class = 'icon_menu']"))).perform();
		sleepInSecond(1);
		action.moveToElement(driver.findElement(By.xpath("//a//span[text() = 'VPP - Dụng Cụ Học Sinh']"))).perform();
		sleepInSecond(1);
		driver.findElement(By.xpath("//div[@class = 'fhs_column_stretch']//a[text() = 'Thước']")).click();
		sleepInSecond(2);
		
		// Hàm getText() sẽ get text ở trên UI mà User nhìn thấy
		Assert.assertEquals(driver.findElement(By.xpath("//strong[text() = 'Thước']")).getText(), "THƯỚC");
		
		// Hàm isDisplayed() sẽ dùng text ở dưới html
		Assert.assertTrue(driver.findElement(By.xpath("//strong[text() = 'Thước']")).isDisplayed());
	}
	
//	@Test
	public void TC_04_Click_And_Hover() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
//		Đang cần thao tác với tất cả 12 số
		List<WebElement> listNumber = driver.findElements(By.xpath("//ol[@id = 'selectable']//li"));
		System.out.println("Tổng:" + listNumber.size());
		
//		get element theo thứ tự list
//		listNumber.get(0);
		
		action.clickAndHold(listNumber.get(0)).moveToElement(listNumber.get(9)).release().perform();
		sleepInSecond(5);
		
//		Verify số lượng element đã chọn
		List<WebElement> listNumberSelected = driver.findElements(By.xpath("//ol[@id = 'selectable']//li[@class = 'ui-state-default ui-selectee ui-selected']"));
		Assert.assertEquals(listNumberSelected.size(), 6);
		
//		Tạo 1 mảng chứa các text mình cần verify 
		String[] listNumberSelectedActual = {"1", "2", "5", "6", "9", "10"};
		
//		Tạo 1 list để lưu các giá trị sẽ được get trong list các số dc chọn
		ArrayList<String> listNumberSelectedExpected = new ArrayList<>();
		
//		Tạo 1 vòng lặp để lấy các số đã chọn bên trên để lưu vào list
		for (WebElement number : listNumberSelected) {
			listNumberSelectedExpected.add(number.getText());
		}
		
//		Ép kiểu Array (mảng) qua List = cách Arrays.asList()
		Assert.assertEquals(listNumberSelectedExpected, Arrays.asList(listNumberSelectedActual));
	}
	
//	@Test
	public void TC_05_Click_And_Hold_Random() {
		driver.get("https://automationfc.github.io/jquery-selectable/");
		List<WebElement> listNumber = driver.findElements(By.xpath("//ol[@id = 'selectable']//li"));
		
//		Nhấn phím ctrl 
		action.keyDown(Keys.CONTROL).perform();
		action.click(listNumber.get(1)).click(listNumber.get(3)).click(listNumber.get(4)).perform();
		
//		Nhả phím ctrl ra
		action.keyDown(Keys.CONTROL).perform();
		
		List<WebElement> listNumberSelected = driver.findElements(By.xpath("//ol[@id = 'selectable']//li[@class = 'ui-state-default ui-selectee ui-selected']"));
		Assert.assertEquals(listNumberSelected.size(), 3);
		
		String[] listNumberSelectActual = {"2", "4", "5"};
		
		ArrayList<String> listNumberSelectExpected = new ArrayList<>();
		
		for (WebElement number : listNumberSelected) {
			listNumberSelectExpected.add(number.getText());
		}
		
		Assert.assertEquals(listNumberSelectExpected, Arrays.asList(listNumberSelectActual));
	}
	
	@Test
	public void TC_06_Double_Click() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
//		scrollToElement("//a[@title = 'Hooray!']");
		
//		Nếu mở bằng firefox thì sẽ scroll xún
		if (driver.toString().contains("firefox")) {
			jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//button[text() = 'Double click me']")));
		}
		
		
		sleepInSecond(2);
		action.doubleClick(driver.findElement(By.xpath("//button[text() = 'Double click me']"))).perform();
		Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public void scrollToElement(String locator) {
//		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(locator)));
//	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
