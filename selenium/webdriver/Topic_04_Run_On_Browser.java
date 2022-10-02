package webdriver;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Topic_04_Run_On_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@Test
	public void Open_Browser_Firefox() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		driver.quit();
		
//		"//label[text()='Employee Id']/parent::div/following-sibling::div/input"
//		Ancestor (Tổ tiên)
//		parent (cha)
//		preceding (bác)
//		following (Chú)
//		preceding-sibling (anh của node hiện tại)
//		following-sibling (em của node hiện tại)
//		child (con)
//		descendant (cháu của node hiện tại)
//			

	}

	@Test
	public void Open_Browser_Chrome() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\Chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.quit();
	}
}
