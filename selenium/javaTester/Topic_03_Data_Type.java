package javaTester;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_03_Data_Type {
	public static void main(String[] args) {
//		Thông tin của 1 nhân viên
//		Tên/ tuổi/ ngày tháng năm sinh/ giới tính/ quê quán/ lương

//		Ánh xạ các thông tin này vào trong lập trình/ phần mềm
		
	//      Cách khai báo 1 biến:
	//		1 -  Kiểu dữ liệu của biến
	//		2 - Tên biến
	//		3 -  Giá trị của biến
	//		
	//		2 cách khai báo và gán giá trị:
	//			1 - Vừa khai báo vừa gán trực tiếp luôn
	//				String name = "Automation Testing";
	//      	2 - khai báo rồi gán sau:
	//				String name;
	//				name = "Automation Testing";
	//				name  = "";

//		2 loại kiểu dữ liệu:
//		I - Kiểu dữ liệu nguyên thủy (Primitive) (int/ long/ double(float)/ boolean)
	//		8 loại:
	//			Số nguyên: byte/ short/ int/ long (Số mà k có phần thập phân)
				
				byte bNumber = 5;
				
				short sNumber = 500;
				
				int iNumber = 6000;
				
				long lNumber = 123456789;
				
	//			Số thực: float/ double
				
				float salary = 15.5f;
				
				double point = 9.9d;
			
	//			Kí tự: char
	//			Dấu nháy đơn
	//			Chứa duy nhất 1 kí tự
				char a = 'a';		
				
	//			Logic: boolean
				boolean marriedStatus = true;
				marriedStatus = false;
		

//		II - Kiểu dữ liệu tham chiếu (Reference)
	//			Chuỗi: String (Chữ, số, Kí tự đặc biệt/ ...)
				//		Dấu nháy đôi
				String emailInvalidString = "abc@123";
				
	//			Class/ interface
				Date date = new Date(a);
				WebDriver driver = new FirefoxDriver();
				
	//			Đối tượng: Object
				Object students;		
		
	//			Array: Mảng (khai báo số lượng dữ liệu trước) - cố định số lượng
				int number[] = {1,2,3,4,5};
				String addresses[] = {"DN", "HN","HCM"};
					
	//			List/ Set/ Queue (Collection) - động
				List<Integer> studentsNumber = new ArrayList<Integer>();
				List<String> studentsString = new ArrayList<String>();
				
				Set<String> studentCity = new LinkedHashSet<String>();
	}
}
