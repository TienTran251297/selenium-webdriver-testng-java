package drsite;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;S
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_Login_Kanri {
	WebDriver driver;
	WebElement element;
	Select select;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://web-com-kanri.dev.kod-hc.info/");
	}


	@Test
	public void TC_01() {
		driver.findElement(By.xpath("//input[@placeholder='メール']")).sendKeys("sang.ngo@codecomplete.jp");
		driver.findElement(By.xpath("//input[@placeholder='パスワード']")).sendKeys("Zxcv1234");
		sleepInTime(1);
		driver.findElement(By.cssSelector("button.btn-pink")).click();		
		sleepInTime(2);
		driver.findElement(By.xpath("//span[text() = 'マスタ']")).click();			
		sleepInTime(2);	
		driver.findElement(By.cssSelector("div.btn-group-toggle > label:first-child")).click();
		sleepInTime(1);
		driver.findElement(By.xpath("//div/button[@class = 'btn btn btn-primary']")).click();
		sleepInTime(1);
		driver.findElement(By.xpath("//label[text() = '都道府県']//parent::div//span[@role='combobox']")).click();
		List<WebElement> list1 = driver.findElements(By.cssSelector("li.select2-results__option"));
		for (WebElement webElement : list1) {
			System.out.println(webElement.getText());
		}
	}
	
	public void sleepInTime(long time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void AfterClass() {
//		driver.quit();
	}
}
