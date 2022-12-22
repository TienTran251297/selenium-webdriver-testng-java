package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Handle_Frame_Iframe {

	WebDriver driver;
	Actions actions;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

//	@Test
	public void TC_01_Kyna_Iframe() {
		driver.get("https://skills.kynaenglish.vn/");
		Assert.assertTrue(driver.findElement(By.xpath("//iframe[contains(@src, 'kyna.vn')]")).isDisplayed());
//		driver.switchTo().frame(0);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'kyna.vn')]")));
		String fbLike = driver.findElement(By.xpath("//a[text() ='Kyna.vn']/parent::div/following-sibling::div"))
				.getText();
		Assert.assertEquals(fbLike, "165K likes");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("cs_chat_iframe");
		driver.findElement(By.cssSelector("div.button_bar")).click();
		driver.findElement(By.xpath("//div[contains(@class,'available_types')]//input[1]")).sendKeys("Join wick");
		driver.findElement(By.xpath("//div[contains(@class,'available_types')]//input[2]")).sendKeys("0909444555");
		new Select(driver.findElement(By.xpath("//select[@id = 'serviceSelect']")))
				.selectByVisibleText("TƯ VẤN TUYỂN SINH");
		driver.findElement(By.cssSelector("textarea.meshim_widget_widgets_TextArea")).sendKeys("test input character");
		driver.findElement(By.cssSelector("input.submit")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("input.live-search-bar")).sendKeys("Excel");
		actions.sendKeys(Keys.ENTER).perform();
	}

	@Test
	public void TC_02_Frame() {
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name = 'login_page']")));
		driver.findElement(By.cssSelector("input.form-control")).sendKeys("trantien972512@gmail.com");
		driver.findElement(By.cssSelector("a.btn-primary")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input#fldPasswordDispId")).isDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
