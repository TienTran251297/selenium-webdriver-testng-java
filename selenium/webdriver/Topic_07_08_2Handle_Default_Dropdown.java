package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_08_2Handle_Default_Dropdown {
	WebDriver driver;
	WebElement element;
	String projectPath = System.getProperty("user.dir");
	Select select;
	Random rand;
	String firstName, lastName, emailString, companyString;

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\\\browserDrivers\\\\chromedriver_2.exe");
		driver = new ChromeDriver();
		rand = new Random();
		firstName = "Tien";
		lastName = "Tran";

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TC_01() {
//		Step 01:
		driver.get("https://demo.nopcommerce.com/");
		
//		Step 02:
		driver.findElement(By.xpath("//a[text() ='Register' ]")).click();
		
//		Step 03:
		driver.findElement(By.name("FirstName")).sendKeys(firstName);
		driver.findElement(By.name("LastName")).sendKeys(lastName);
		
//		Khởi tạo select để thao tác với date dropdown
		select = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']")));
		select.selectByValue("25");
		
//		Khởi tạo select để thao tác với Month dropdown		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByValue("12");

//		Khởi tạo select để thao tác với Year dropdown
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		select.selectByValue("1997");
		
		emailString = "trantien"+ rand.nextInt(1000) + "@hostmail.com";
		driver.findElement(By.id("Email")).sendKeys(emailString);
		
		companyString = "Company" + rand.nextInt(1000);
		driver.findElement(By.id("Company")).sendKeys(companyString);
		
		driver.findElement(By.id("Password")).sendKeys("Tien1234");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("Tien1234");
		
//		Step 04:
		driver.findElement(By.id("register-button")).click();
		
//		Step 05:
		Assert.assertEquals(driver.findElement(By.xpath("//div[text() = 'Your registration completed']")).getText(), "Your registration completed");
		
		
//		Step 06:
		driver.findElement(By.cssSelector("a.ico-account")).click();
		
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);
		
		select = new Select(driver.findElement(By.xpath("//select[@name = 'DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getAttribute("value"), "25");
		
		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption().getAttribute("value"), "12");
		
		select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getAttribute("value"), "1997");
				 
		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), emailString);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), companyString);
	
	}
	
//	@Test
	public void TC_02() throws InterruptedException {
		driver.get("https://rode.com/en/support/where-to-buy");
		select = new Select(driver.findElement(By.id("country")));
		
		select.selectByValue("Vietnam");
		
		Thread.sleep(3000);
		
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Vietnam");
		
		List<WebElement> dealers = driver.findElements(By.cssSelector("div#map h4"));
		
		for (WebElement element : dealers) {
			System.out.println(element.getText());
		}
		
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
