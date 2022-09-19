package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_08_3_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait expliciWait;
	WebElement element;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
		
//		System.setProperty("wevdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver_2.exe");
//		driver = new ChromeDriver();

		System.setProperty("webdriver.chrome.driver", projectPath + "\\\\browserDrivers\\\\chromedriver_2.exe");
		driver = new ChromeDriver();
		
		expliciWait = new WebDriverWait(driver, 30);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void TC_01_JQuery() {
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
//		Gọi hàm: 1 hàm có thể gọi 1 hàm khác để dùng trong 1 class
		
		selectItemDropdown("//span[@id = 'number-button']", "//ul[@id= 'number-menu']//div", "7");
		sleepSecond(3);
		
		
//		change
		
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

	@Test
	public void TC_02() {
		
	}
	
	public void selectItemDropdown(String parentLocater, String childLocater, String textExpecterItem) {
		driver.findElement(By.xpath("//span[@id = 'number-button']")).click();
		expliciWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@id= 'number-menu']//div")));
		List<WebElement> allItems = driver.findElements(By.xpath("//ul[@id= 'number-menu']//div"));
		for (WebElement item : allItems) {
			
//			Dùng biến item để thao tác trong vòng lặp
//			Lấy text:
			String textActualItem = item.getText();
			
//			4 - Kiểm tra text của item - nếu đúng với cái mình cần thì click vào
			if (textActualItem.equals(textExpecterItem)) {
				item.click();
			}
		}
	}
	
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
		driver.quit();
	}
}
