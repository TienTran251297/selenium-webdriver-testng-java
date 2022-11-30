package javaBasic;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class TOpic_04_Access_Modifier {

	public static void main(String[] args) {
		
	}

	@Test
	public void TC_01() {
		String[] studentName = {};
		ArrayList<String> nameList = new ArrayList<String>();
		for (String std : studentName) {
			nameList.add(std);
		} 
		System.out.println(studentName);
	}
	
}
