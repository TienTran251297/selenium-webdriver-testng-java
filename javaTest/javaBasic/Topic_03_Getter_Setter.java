package javaBasic;

import org.openqa.selenium.WebDriver;

public class Topic_03_Getter_Setter {
	WebDriver driver;
	private String nameStudent;
	
	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public static void main(String[] args) {
		Topic_03_Getter_Setter topic_03 =  new Topic_03_Getter_Setter();
		System.out.println(topic_03.getNameStudent());
		
	}
}
