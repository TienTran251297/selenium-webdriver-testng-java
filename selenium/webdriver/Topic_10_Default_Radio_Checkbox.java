package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_10_Default_Radio_Checkbox {
	// Khai báo
	WebDriver driver;
	WebElement element;

	// Khai báo + khởi tạo
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {

//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_Jotform() {
		driver.get("https://automationfc.github.io/multiple-fields/");

//		Tick Checkbox	
		// input[contains(@value , 'Cancer')]
		// label[contains(text(),'Cancer')]/preceding-sibling::input

//		driver.findElement(By.xpath("//input[@value = 'Cancer']")).click();
//		driver.findElement(By.xpath("//label[contains(text(),'Diabetes')]/preceding-sibling::input")).click();
		checkToCheckBoxOrRadio("//input[@value = 'Cancer']");
		checkToCheckBoxOrRadio("//label[contains(text(),'Diabetes')]/preceding-sibling::input");

//		Verify checkbox selected
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value = 'Cancer']")).isSelected());
		Assert.assertTrue(driver.findElement(By.xpath("//label[contains(text(),'Diabetes')]/preceding-sibling::input"))
				.isSelected());

//		Untick Checkbox
//		driver.findElement(By.xpath("//input[@value = 'Cancer']")).click();
//		driver.findElement(By.xpath("//label[contains(text(),'Diabetes')]/preceding-sibling::input")).click();

		unCheckToCheckBoxOrRadio("//input[@value = 'Cancer']");
		unCheckToCheckBoxOrRadio("//label[contains(text(),'Diabetes')]/preceding-sibling::input");

//		Verify checkbox unselected
		Assert.assertFalse(driver.findElement(By.xpath("//input[@value = 'Cancer']")).isSelected());
		Assert.assertFalse(driver.findElement(By.xpath("//label[contains(text(),'Diabetes')]/preceding-sibling::input"))
				.isSelected());

//		Tick RadioButton
		// input[@value = 'No']
		// label[contains(text(),' 3-4 days ')]/preceding-sibling::input

//		driver.findElement(By.xpath("//input[@value = 'No']")).click();
//		driver.findElement(By.xpath("//label[contains(text(),' 3-4 days ')]/preceding-sibling::input")).click();

		checkToCheckBoxOrRadio("//input[@value = 'No']");
		checkToCheckBoxOrRadio("//label[contains(text(),' 3-4 days ')]/preceding-sibling::input");

//		Verify RadioButton selected
		Assert.assertTrue(verifyCheckboxOrRadio("//input[@value = 'No']"));
		Assert.assertTrue(verifyCheckboxOrRadio("//label[contains(text(),' 3-4 days ')]/preceding-sibling::input"));

//		Bỏ tick RadioButton
		// input[@value = '3-4 days']
		// label[contains(text(),' 3-4 days ')]/preceding-sibling::input

//		driver.findElement(By.xpath("//input[@value , 'No']")).click();
//		driver.findElement(By.xpath("//label[contains(text(),' 3-4 days ')]/preceding-sibling::input")).click();

		unCheckToCheckBoxOrRadio("//input[@value = 'No']");
		unCheckToCheckBoxOrRadio("//label[contains(text(),' 3-4 days ')]/preceding-sibling::input");

//		Verify RadioButton selected
		Assert.assertTrue(verifyCheckboxOrRadio("//input[@value = 'No']"));
		Assert.assertTrue(verifyCheckboxOrRadio("//label[contains(text(),' 3-4 days ')]/preceding-sibling::input"));

	}

	@Test
	public void TC_02_selectAllCheckbox() {
		driver.get("https://automationfc.github.io/multiple-fields/");
		List<WebElement> allItem = driver.findElements(By.xpath("//input[@type = 'checkbox']"));

		/*** C1: Viết code ***/
		for (WebElement item : allItem) {
			if (!item.isSelected()) {
				item.click();
			}
		}

		for (WebElement item : allItem) {
			Assert.assertTrue(item.isSelected());
		}
		for (WebElement item : allItem) {
			if (item.isSelected()) {
				item.click();
			}
		}

		for (WebElement item : allItem) {
			Assert.assertFalse(item.isSelected());
		}

		/*** C2: Dùng hàm ***/
		for (WebElement checkbox : allItem) {
			checkToCheckBoxOrRadio(checkbox);
		}

		for (WebElement checkbox : allItem) {
			Assert.assertTrue(verifyCheckboxOrRadio(checkbox));
		}

		for (WebElement checkbox : allItem) {
			unCheckToCheckBoxOrRadio(checkbox);
		}

		for (WebElement checkbox : allItem) {
			Assert.assertFalse(verifyCheckboxOrRadio(checkbox));
		}
	}
	
    @Test
	public void TC_03_Select_All() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		sleepInSecond(3);
		List<WebElement> allCheckbox = driver.findElements(By.xpath("//ul[@class = 'fieldlist']//input"));
		
//		Vừa chọn vừa verify
		for (WebElement checkbox : allCheckbox) {
			checkToCheckBoxOrRadio(checkbox);
		}
		
		for (WebElement checkbox : allCheckbox) {
			unCheckToCheckBoxOrRadio(checkbox);
		}

	}
    
    @Test
    public void TC_04_Select_All() {
    	driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
    	sleepInSecond(3);
    	List<WebElement> allCheckbox = driver.findElements(By.xpath("//ul[@class = 'fieldlist']//input"));
    	
//		Vừa chọn vừa verify
    	for (WebElement checkbox : allCheckbox) {
    		checkToCheckBoxOrRadio(checkbox);
    	}
    	
    	for (WebElement checkbox : allCheckbox) {
    		unCheckToCheckBoxOrRadio(checkbox);
    	}
    	
    }

	public void checkToCheckBoxOrRadio(String xpathLocater) {
		if (!driver.findElement(By.xpath(xpathLocater)).isSelected()) {
			driver.findElement(By.xpath(xpathLocater)).click();
		}
	}

	public void checkToCheckBoxOrRadio(WebElement element) {
		if (!element.isSelected() && element.isEnabled()) {
			System.out.println("Click to element: " + element);
			element.click();
			Assert.assertTrue(verifyCheckboxOrRadio(element));
		}
	}

	public void unCheckToCheckBoxOrRadio(String xpathLocater) {
		if (driver.findElement(By.xpath(xpathLocater)).isSelected()) {
			driver.findElement(By.xpath(xpathLocater)).click();
		}
	}

	public void unCheckToCheckBoxOrRadio(WebElement element) {
		if (element.isSelected() && element.isEnabled()) {
			System.out.println("Click to element: " + element);
			element.click();
			Assert.assertFalse(verifyCheckboxOrRadio(element));
		}
	}

	public boolean verifyCheckboxOrRadio(String xpathLocater) {
		return driver.findElement(By.xpath(xpathLocater)).isSelected();
	}

	public boolean verifyCheckboxOrRadio(WebElement element) {
		return element.isSelected();
	}

	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterClass
	public void afterClass() {
//		driver.quit();
	}
}
