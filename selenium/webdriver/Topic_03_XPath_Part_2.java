package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_XPath_Part_2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.get("https://www.facebook.com/");
	}

	@Test
	public void TC_01_ValidateCurrentUrl() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		// HMTL Format
		/*<input class="text form-control" 
		 * id="txtEmail" 
		 * name="txtEmail" 
		 * placeholder="Địa chỉ email" 
		 * type="email" value="">*/
		
		//input[@class="text form-control"]
		//input[@id="txtEmail"] **
		//input[@name="txtEmail"] **
		//input[@placeholder="Địa chỉ email"]
		//input[@type="email"]
		//input[@value=""]
		
		// 1 - < hoặc <>
		// 2 - Tên thẻ (Tagname): input/ html/ head/ body/ form/
		// 3 - Thuộc tính (Attribute name): class/ id/ name/ placeholder/ type/ value 
		// 4 - Giá trị của thuộc tính (Attribuite value): text form-control/ txtEmail/ ...
		// 5 - > hoặc </>
		
		// Tagname - attribute name - attribute value
		
		// XPath format basic:
		// Absolute XPath (Tuyệt đối): /html/body/...
		// Relative XPath (Tương đối): //Tagname[@attribute-name='attribute-value'] 
	    // Relative XPath (Tương đối): //Tagname[@attribute-name="attribute-value"]
		
		// CSS Format basic 
		// Relative CSS (Tương đối): Tagname[attribute-name='attribute-value'] 
	    // Relative CSS (Tương đối): Tagname[attribute-name="attribute-value"]
		
		// Xpath link
		//a[contains(@href,'/cau-hoi-thuong-gap.html')]
		
		
		//Xpath cho 1 noDe cha và 1 node con
		//div[@id='header-account']//a[@title='My Account'] 
		//div[@class='footer']//a[@title='My Account']

		//li[@class='error-msg']//span
		
		
		//Xpath cos constains/starts-with nhưng k có ends-with
				//CSs lại có ends-with
				//https://member.lazada.vn/user/register?spm=a2o4n.home.header.d6.1905e182p9UVwN
				//input[starts-with(@data-spm-anchor-id,'a2o4n.login_signup.0.i0.473e5d0aWVevc0')]
		
	}

	@Test
	public void TC_02_ValidatePageTitle() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
