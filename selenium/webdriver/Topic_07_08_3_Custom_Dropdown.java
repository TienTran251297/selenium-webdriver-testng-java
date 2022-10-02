package webdriver;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_08_3_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait expliciWait;
	WebElement element;
	Select select;
	String projectPath = System.getProperty("user.dir");
	JavascriptExecutor jsExecutor;

	@BeforeClass
	public void beforeClass() {
		
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver", projectPath + "\\\\browserDrivers\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		
		expliciWait = new WebDriverWait(driver, 30);
		
//		Khởi tạo k cần new mà ép kiểu:
		jsExecutor =  (JavascriptExecutor) driver;
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

//	@Test
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
//		Gọi hàm: 1 hàm có thể gọi 1 hàm khác để dùng trong 1 class
		
		selectItemDropdown("//span[@id = 'number-button']", "//ul[@id= 'number-menu']//div", "7");
		sleepSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//span[@id= 'number-button']//span[@class = 'ui-selectmenu-text']")).getText(), "7"); 
		
//		change_2
		
//		1 - Click vào phần tử nào đó thuộc dropdown để cho nó xổ ra
//		driver.findElement(By.xpath("//span[@id = 'number-button']")).click();
		
//		2- Chờ cho tất cả các item trong dropdown được load ra xong
//		Lưu ý: không dùng sleep cứng
//		Phải có 1 hàm wait nào đó để nó linh động
//		Nếu như chưa tìm thấy sẽ tìm lại trong khoảng time được set
//		Nếu như tìm thấy rồi thì không cần phải chờ hết khoảng thời gian
		
//		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id= 'number-menu']//div")));
		
//		3.1 - Nếu item cần chọn đang hiển thị
//		3.2 - Nếu item cần chọn không hiển thị thì cần cuộn chuột xuống - sroll down
		
//		Duyệt qua từng item 
//		Lưu trữ tất cả các item lại thì mới duyệt qua
		
//		List<WebElement> allItems = driver.findElements(By.xpath("//ul[@id= 'number-menu']//div"));
		
//		Duyệt qua từng item
//		Vòng lặp
		
//		for (WebElement item : allItems) {
			
//			Dùng biến item để thao tác trong vòng lặp
//			Lấy text:
//			String textItem = item.getText();
			
//			4 - Kiểm tra text của item - nếu đúng với cái mình cần thì click vào
//			if (textItem.equals("7")) {
//				item.click();
//			}		
//		}	
	}

//	@Test
	public void TC_02_Honda() {
		driver.get("https://www.honda.com.vn/o-to/du-toan-chi-phi");
		
		scrollToElement("//img[@class = 'image-background']");
		sleepSecond(3);
		
//		Chọn Xe:
		selectItemDropdown("//button[@id = 'selectize-input']", "//button[@id = 'selectize-input']/following-sibling::div/a", "ACCORD Ghi Bạc/Đen");
		sleepSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//button[@id = 'selectize-input']")).getText(), "ACCORD Ghi Bạc/Đen");
		
		scrollToElement("//div[@class = 'div-cost-estimates']");
		sleepSecond(3);
		
//		Chọn tỉnh thành:
//		C1: chọn theo value
//		new Select(driver.findElement(By.xpath("//select[@id = 'province']"))).selectByValue("17");
		
//		C2: chọn theo text
		select = new Select(driver.findElement(By.xpath("//select[@id = 'province']")));
		select.selectByVisibleText("Đà Nẵng");
		sleepSecond(3);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Đà Nẵng");
		
		
//		Chọn khu vực:
		select = new Select(driver.findElement(By.xpath("//select[@id = 'registration_fee']")));
		select.selectByVisibleText("Khu vực II");
		sleepSecond(3);
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Khu vực II");
		
		driver.findElement(By.cssSelector("input.btn-cost-estimates"));
		
		
	}
	
//	@Test
	public void TC_03_ReactJS() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
//		driver.findElement(By.xpath("//div[@role='listbox']")).click();
		selectItemDropdown("//div[@role='listbox']", "//div[@class= 'visible menu transition']//span", "Elliot Fu");
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class= 'divider text']")).getText(), "Elliot Fu");
		
	}
	
//	@Test
	public void TC_04_VueJS() {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		selectItemDropdown("//li[@class = 'dropdown-toggle']", "//ul[@class = 'dropdown-menu']//a", "First Option");
		Assert.assertEquals(driver.findElement(By.xpath("//li[@class = 'dropdown-toggle']")).getText(), "First Option");
	}
	
//	@Test
	public void TC_05_React_SelectTable() {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		selectItemDropdown("//div[@class = 'ui fluid search selection dropdown']", "//div[@class = 'visible menu transition']//div//span", "Algeria");
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'ui fluid search selection dropdown']")).getText(), "Algeria");
	}
	
	@Test
	public void TC_06_React_editTable() {
		
//		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
//		enterItemDropdown("//input[@class = 'search']", "//div[@class = 'visible menu transition']//div//span", "Algeria");
//		Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'ui fluid search selection dropdown']")).getText(), "Algeria");
		
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		enterItemDropdown("//input[@class = 'search']", "//div[@class = 'visible menu transition']//div//span", "Be");
		sleepSecond(3);
//		driver.findElement(By.xpath("//div[@class = 'visible menu transition']//div//span")).click();
		
		List<WebElement> searchItem = driver.findElements(By.xpath("//div[@class = 'visible menu transition']//div//span"));
		for (WebElement item : searchItem) {
			String itemSearch = item.getText();
			if (itemSearch.equals("Benin")) {
				item.click();
				break;
			}
		}
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class = 'ui fluid search selection dropdown']")).getText(), "Benin");
		Assert.assertEquals(false, false);
	}
	
	public void selectItemDropdown(String parentLocater, String childLocater, String textExpecterItem) {
//		Click  vào thẻ nào đó (parent) để cho nó xổ ra tất cả các item
		driver.findElement(By.xpath(parentLocater)).click();
		
//		Wait cho tất cả các item này có xuất hiện ở trong cây HTML/ DOM
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocater)));
		
//		Tìm lưu lại hết tất cả các item vào 1 list để cho step tiếp theo
		List<WebElement> allItems = driver.findElements(By.xpath(childLocater));
		
//		Duyệt qua từng phần tử(element) trong list trên
		for (WebElement item : allItems) {
			
//			Dùng biến item để thao tác trong vòng lặp
//			Lấy text:
			String textActualItem = item.getText();
			
//			4 - Kiểm tra text của item - nếu đúng với cái mình cần thì click vào
			if (textActualItem.equals(textExpecterItem)) {
				item.click();
				
//				Khi đã tìm thấy và thỏa mãn điều kiện rồi thì không cần duyệt tiếp nữa
				break;
			}
		}
	}
	
	public void enterItemDropdown(String parentLocater, String childLocater, String textExpecterItem) {
//		Click  vào thẻ nào đó (parent) để cho nó xổ ra tất cả các item
		driver.findElement(By.xpath(parentLocater)).sendKeys(textExpecterItem);
		
//		Wait cho tất cả các item này có xuất hiện ở trong cây HTML/ DOM
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocater)));
		
		sleepSecond(3);
		
//		driver.findElement(By.xpath(childLocater)).click();
		
//		Tìm lưu lại hết tất cả các item vào 1 list để cho step tiếp theo
		List<WebElement> allItems = driver.findElements(By.xpath(childLocater));
		
//		Duyệt qua từng phần tử(element) trong list trên
		for (WebElement item : allItems) {
			
//			Dùng biến item để thao tác trong vòng lặp
//			Lấy text:
			String textActualItem = item.getText();
			
//			4 - Kiểm tra text của item - nếu đúng với cái mình cần thì click vào
			if (textActualItem.equals(textExpecterItem)) {
				item.click();
				
//				Khi đã tìm thấy và thỏa mãn điều kiện rồi thì không cần duyệt tiếp nữa
				break;
			}
		}
	}
	
	public void scrollToElement(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(locator)));
	}
	
//	Slep cứng (Static wait)
	public void sleepSecond(long time) {
		try {
			Thread.sleep(time * 1000);
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
