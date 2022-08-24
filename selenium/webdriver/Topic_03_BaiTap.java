package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_03_BaiTap {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void Register_01() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("");
		driver.findElement(By.id("txtEmail")).sendKeys("");
		driver.findElement(By.id("txtCEmail")).sendKeys("");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.id("txtCPassword")).sendKeys("");
		driver.findElement(By.id("txtPhone")).sendKeys("");
		driver.findElement(By.xpath("//div[@class='columm login_col_8']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
	}
	
	@Test
	public void Register_02() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("dang ky");
		driver.findElement(By.id("txtEmail")).sendKeys("dang-ky@123@");
		driver.findElement(By.id("txtCEmail")).sendKeys("dang-ky@123@");
		driver.findElement(By.id("txtPassword")).sendKeys("Tien1234");
		driver.findElement(By.id("txtCPassword")).sendKeys("Tien1234");
		driver.findElement(By.id("txtPhone")).sendKeys("0905123123");
		driver.findElement(By.xpath("//div[@class='columm login_col_8']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void Register_03() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("dang ky");
		driver.findElement(By.id("txtEmail")).sendKeys("dang-ky@123@");
		driver.findElement(By.id("txtCEmail")).sendKeys("dang-ky@123");
		driver.findElement(By.id("txtPassword")).sendKeys("Tien1234");
		driver.findElement(By.id("txtCPassword")).sendKeys("Tien1234");
		driver.findElement(By.id("txtPhone")).sendKeys("0905123123");
		driver.findElement(By.xpath("//div[@class='columm login_col_8']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
	}
	
	@Test
	public void Register_04() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("dang ky");
		driver.findElement(By.id("txtEmail")).sendKeys("dang-ky@123@");
		driver.findElement(By.id("txtCEmail")).sendKeys("dang-ky@123");
		driver.findElement(By.id("txtPassword")).sendKeys("Tien1");
		driver.findElement(By.id("txtCPassword")).sendKeys("Tien1");
		driver.findElement(By.id("txtPhone")).sendKeys("0905123123");
		driver.findElement(By.xpath("//div[@class='columm login_col_8']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
	}
	
	@Test
	public void Register_05() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("dang ky");
		driver.findElement(By.id("txtEmail")).sendKeys("dang-ky@123@");
		driver.findElement(By.id("txtCEmail")).sendKeys("dang-ky@123");
		driver.findElement(By.id("txtPassword")).sendKeys("Tien123");
		driver.findElement(By.id("txtCPassword")).sendKeys("Tien12345");
		driver.findElement(By.id("txtPhone")).sendKeys("0905123123");
		driver.findElement(By.xpath("//div[@class='columm login_col_8']//button[text()='ĐĂNG KÝ']")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
	}
	
	@Test
	public void Register_06() {
		driver.get("https://alada.vn/tai-khoan/dang-ky.html");
		
		driver.findElement(By.id("txtFirstname")).sendKeys("dang ky");
		driver.findElement(By.id("txtEmail")).sendKeys("dang-ky@12345");
		driver.findElement(By.id("txtCEmail")).sendKeys("dang-ky@12345");
		driver.findElement(By.id("txtPassword")).sendKeys("Tien123");
		driver.findElement(By.id("txtCPassword")).sendKeys("Tien123");
		
//		<10 charater
		driver.findElement(By.id("txtPhone")).sendKeys("09051");
		driver.findElement(By.xpath("//div[@class='columm login_col_8']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
//		>11 charater
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("09051231211231231231");
		driver.findElement(By.xpath("//div[@class='columm login_col_8']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
		
//		>11 charater
		driver.findElement(By.id("txtPhone")).clear();
		driver.findElement(By.id("txtPhone")).sendKeys("9051231211");
		driver.findElement(By.xpath("//div[@class='columm login_col_8']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
