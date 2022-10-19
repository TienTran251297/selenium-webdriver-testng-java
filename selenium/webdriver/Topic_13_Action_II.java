package webdriver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_13_Action_II {
	//Khai báo
	WebDriver driver;
	WebElement element;
	Actions action;
	JavascriptExecutor jsExecutor;

	//Khai báo + khởi tạo
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
				
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		action = new Actions(driver);
		jsExecutor = (JavascriptExecutor) driver;
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_Right_Click() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		action.contextClick(driver.findElement(By.xpath("//span[text() = 'right click me']"))).perform();
		sleepInSecond(2);
		
		action.moveToElement(driver.findElement(By.xpath("//span[text() = 'Quit']"))).perform();
		Assert.assertTrue(driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-quit context-menu-hover context-menu-visible']")).isDisplayed());
		driver.findElement(By.xpath("//span[text() = 'Quit']")).click();
		sleepInSecond(1);
		driver.switchTo().alert().accept();
		sleepInSecond(1);
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']")).isDisplayed());
	}
	
//	@Test 
	public void TC_02_Drag_And_Drop_HTML4() {
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		
		WebElement nguon = driver.findElement(By.xpath("//div[@id = 'draggable']")); 
		WebElement dich = driver.findElement(By.xpath("//div[@id = 'droptarget']"));
		
		action.dragAndDrop(nguon, dich).perform();
		
		Assert.assertEquals(dich.getText(), "You did great!");
		
		String rgbaColor = dich.getCssValue("background-color");
		
		String hexaColor = Color.fromString(rgbaColor).asHex();
		
		Assert.assertEquals(hexaColor, "#03a9f4");
		
	}
	
	@Test 
	public void TC_03_Drag_And_Drop_HTML5_CSS3_JS6() throws IOException  {
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		String jsContentFile = getContentFile(projectPath + "/dragAndDrop/drag_and_drop_helper.js");
		jsExecutor.executeScript(jsContentFile + "$('div#column-a').simulateDragDrop({dropTarget: 'div#column-b'})");
		sleepInSecond(2);
	}
	
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	Hàm để gọi tới file khác
	public String getContentFile(String filePath) throws IOException {
		Charset cs = Charset.forName("UTF-8");
		FileInputStream stream = new FileInputStream(filePath);
		try {
			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			return builder.toString();
		} finally {
			stream.close();
		}
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
