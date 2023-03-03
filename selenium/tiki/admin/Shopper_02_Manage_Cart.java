package tiki.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Shopper_02_Manage_Cart {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
	@BeforeClass(alwaysRun = true)
	public void initBrowser() {
		System.out.println("---------------------- Open browser and driver ----------------------");
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(groups = {"admin","Cart"})
	public void Cart_01_Create_Cart() {

	}

	@Test(groups = {"admin","Cart"})
	public void Cart_02_View_Cart() {

	}

	@Test(groups = {"admin","Cart"})
	public void Cart_03_Upadte_Cart() {

	}

	@Test(groups = {"admin","Cart"})
	public void Cart_04_Delete_Cart() {

	}
	
	@AfterClass(alwaysRun = true)
	public void cleanBrowser() {
		System.out.println("---------------------- Clean browser and driver ----------------------");
		driver.quit();
	}
}
