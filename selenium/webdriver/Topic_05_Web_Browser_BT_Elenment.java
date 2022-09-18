package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_BT_Elenment {
	WebDriver driver;
	WebElement element;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_isDisplayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Email Textbox
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
		
		if (emailTextbox.isDisplayed()) {
			emailTextbox.sendKeys("Automation Testing");
			System.out.println("Email textbox is displayed");
		}else {
			System.out.println("Email textbox is not displayed");
		}
		
		WebElement ageSelectBox = driver.findElement(By.xpath("//input[@id='under_18']"));
		
		if (ageSelectBox.isDisplayed()) {
			System.out.println("Age select box is displayed");
			ageSelectBox.click();
		} else {
			System.out.println("Age select box is not displayed");
		}
		
		WebElement educationTextBox = driver.findElement(By.xpath("//textarea[@id='edu']"));
		
		if (educationTextBox.isDisplayed()) {
			System.out.println("Education is displayed");
			educationTextBox.sendKeys("Automation Testing");
		} else {
			System.out.println("Education is not displayed");
		}
		
	}

	@Test
	public void TC_02_isEnabled() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
		
		if (emailTextbox.isEnabled()) {
			System.out.println("Email textbox is enabled");
		}else {
			System.out.println("Email textbox is not disabled");
		}
		
		WebElement ageSelectBox = driver.findElement(By.xpath("//input[@id='under_18']"));
		
		if (ageSelectBox.isDisplayed()) {
			System.out.println("Age select box is enabled");
			ageSelectBox.click();
		} else {
			System.out.println("Age select box is not disable");
		}
	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
