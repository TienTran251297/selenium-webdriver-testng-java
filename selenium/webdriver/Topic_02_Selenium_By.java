package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_By {

	// Khai báo 1 biến để đại diện cho thử viện Selenium WebDriver
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {

		// Bước 1: Open brower lên
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();

		// Bấm cho maximize brower lên
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		
		// Bước 2: Nhập vào Url
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
		
		// Bước 3: Click Vào My Account để mở trang login ra
		
//		HTML của element (Email Textbox)
// 		<input type="email" 
//				autocapitalize="off" 
//				autocorrect="off" 
//				spellcheck="false" 
//				name="login[username]" 
//				value="" 
//				id="email" 
//				class="input-text required-entry validate-email" 
//				title="Email Address">
//		
		
		// HTML của element (Email Textbox)
		// input - thẻ của elenment này (tagname)
		// attribute name -  type autocapitalize autocorrect spellcheck name value id class title
		// attribute value - email none off ...\
		
		// Xpath
		//tagname[@attribute-name='attribute-value']
		//input[@type='email']
		//input[@autocapitalize='none']
		//input[@autocorrect='off']
		//input[@spellcheck='false']
		//input[@name='login[username]'] => *
		//input[@id='email'] => *
		//input[@class='input-text required-entry validate-email']
		//input[@title='Email Address'] => *
		
		// CSS Format: tagname[ attribute-name='attribute-value']
		
		// ID 
		driver.findElement(By.id("email"));
		
		// Cách gõ code ít bị lỗi:
		// K dc dư kí tự: ()
		// Thiếu kí tự: ;
		// ctrl space hiển thị gợi ý 

		// Class - New User form
		// 1 - Giá trị k có khoảng trắng -> lấy hết
		// 2 - Giá trị chứa khoảng trắng -> lấy 1 phần
		
		driver.findElement(By.className("new-users"));
		
		// Name - Email Textbox
		driver.findElement(By.name("login[username]"));
		
		// Tagname
		driver.findElement(By.tagName("a"));
		
		// Linktext (Link) - Text tuyệt đối
		driver.findElement(By.linkText("SEARCH TERMS"));
		
		// Partial LinkText (Link) - Text tương đối/ tuyệt đối
		driver.findElement(By.partialLinkText("SEARCH TERMS"));
		
		// Css - Cover đc 6 loại trên
		driver.findElement(By.cssSelector("input[id='email']"));
		
		// Xpath
		driver.findElement(By.xpath("//input[@id='email']"));
		
		// k bị lỗi cú pháp
		// Code đúng
		// COde tối ứu sau
		
		// Tìm nhiều Element
		//driver.findElements(null)
				
		// Click lên
		
	}

	@Test
	public void TC_02_ValidatePageTitle() {

	}

	@AfterClass
	public void afterClass() {
		// Bước 6: Đóng browser
		driver.quit();
	}
}
