package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_08_1Textbox_TextArea {
	WebDriver driver;
	WebElement element;
	String projectPath = System.getProperty("user.dir");
	String employee_ID, firstName, lastName, editFirstName, editLastName;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		firstName = "Tran";
		lastName = "Tien";
		editFirstName = "Nguyen";
		editLastName = "Van";
	}
	
	
	
	@Test
	public void TC_01_Textbox_Textarea() throws InterruptedException {
		
//		Step 1:
		driver.get("https://opensource-demo.orangehrmlive.com/ ");
		Thread.sleep(5000);
		
//		Step 2:
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
//		Step 3:
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Add Employee']")).click();
		Thread.sleep(5000);
		String urlString = driver.getCurrentUrl();
		Assert.assertEquals(urlString, "https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		
//		Step 4:
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		employee_ID = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following::div/input")).getAttribute("value");
		
//		Step 5:
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
				
//		Step 6:
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following::div/input")).getAttribute("value"), employee_ID);
		
//		Step 7:
		
//		Step 8:
		Thread.sleep(5000);
		driver.findElement(By.name("firstName")).clear();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(editFirstName);
		
		driver.findElement(By.name("lastName")).clear();
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(editLastName);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
//		Step 9:
		Thread.sleep(5000);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"), lastName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following::div/input")).getAttribute("value"), employee_ID);
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
