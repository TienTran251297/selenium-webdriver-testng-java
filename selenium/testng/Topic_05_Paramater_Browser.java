package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_05_Paramater_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	By emailTextbox = By.xpath("//*[@id='email']");
	By passwordTextbox = By.xpath("//*[@id='pass']");
	By loginButton = By.xpath("//*[@id='send2']");

	@Parameters("browser")

	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) {
//		if-else
//		if (browserName.equals("firefox")) {
//			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//			driver = new FirefoxDriver();
//		} else if (browserName.equals("chrome")){
//			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver_110.0.5481.77.exe");
//			driver = new ChromeDriver();
//		} else {
//			throw new RuntimeException("please input with correct browser name.");
//		}

		switch (browserName) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;

		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					projectPath + "\\browserDrivers\\chromedriver_110.0.5481.77.exe");
			driver = new ChromeDriver();
			break;

		default:
			throw new RuntimeException("please input with correct browser name.");
		}

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Parameters("evironment")
	@Test
	public void TC_01_LoginToSystem(@Optional("live") String envName) {
		String envUrlString = getEvironmentURL(envName);
		driver.get(envUrlString + "index.php/customer/account/login/");
		driver.findElement(emailTextbox).sendKeys("selenium_11_01@gmail.com");
		driver.findElement(passwordTextbox).sendKeys("111111");
		driver.findElement(loginButton).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='col-1']//p")).getText()
				.contains("selenium_11_01@gmail.com"));
	}

	public String getEvironmentURL(String envName) {
		if (envName.equals("dev")) {
			return "http://dev.techpanda.org/";
		} else if (envName.equals("test")) {
			return "http://test.techpanda.org/";
		} else if (envName.equals("live")) {
			return "http://live.techpanda.org/";
		}
		return null;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
