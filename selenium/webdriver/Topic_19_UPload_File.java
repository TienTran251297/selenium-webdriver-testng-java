package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_UPload_File {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;

	String anh1 = "Anh_01.jpg";
	String anh2 = "Anh_02.jpg";
	String anh3 = "Anh_03.jpg";

	String nameFileImage_1 = projectPath + "\\uploadFilePath\\" + anh1;
	String nameFileImage_2 = projectPath + "\\uploadFilePath\\" + anh2;
	String nameFileImage_3 = projectPath + "\\uploadFilePath\\" + anh3;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		jsExecutor = (JavascriptExecutor) driver;
	}

//	@Test
	public void TC_01_Single_Image() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(nameFileImage_1);
		sleepInSecond(1);
		driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(nameFileImage_2);
		sleepInSecond(1);
		driver.findElement(By.xpath("//input[@type = 'file']")).sendKeys(nameFileImage_3);
		sleepInSecond(1);

		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + anh1 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + anh2 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + anh3 + "'] ")).isDisplayed());

		List<WebElement> locatorStart = driver.findElements(By.xpath("//span[text()= 'Start']"));
		for (WebElement buttonStart : locatorStart) {
			buttonStart.click();
			sleepInSecond(1);
		}

		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + anh1 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + anh2 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + anh3 + "'] ")).isDisplayed());

		sleepInSecond(2);

		Assert.assertTrue(isImageLoaded("//img[contains(@src, '" + anh1 + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src, '" + anh2 + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src, '" + anh3 + "')]"));
	}

	@Test
	public void TC_02_Mutiple_Image() {
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		driver.findElement(By.xpath("//input[@type = 'file']"))
				.sendKeys(nameFileImage_1 + "\n" + nameFileImage_2 + "\n" + nameFileImage_3);
		sleepInSecond(1);

		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + anh1 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + anh2 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[text() = '" + anh3 + "'] ")).isDisplayed());

		List<WebElement> locatorStart = driver.findElements(By.xpath("//span[text()= 'Start']"));
		for (WebElement buttonStart : locatorStart) {
			buttonStart.click();
			sleepInSecond(1);
		}

		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + anh1 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + anh2 + "'] ")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//a[text() = '" + anh3 + "'] ")).isDisplayed());

		sleepInSecond(2);

		Assert.assertTrue(isImageLoaded("//img[contains(@src, '" + anh1 + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src, '" + anh2 + "')]"));
		Assert.assertTrue(isImageLoaded("//img[contains(@src, '" + anh3 + "')]"));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(locator));
		return status;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
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
		driver.quit();
	}
}
