package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Bai_Tap_Topic_12 {

	Scanner scanner = new Scanner(System.in);

	@Test
	public void bai_1() {
		String text = "Automation FC";
		char textChart[] = text.toCharArray();
		int dem = 0;
		for (char character : textChart) {
			if (character >= 'A' && character <= 'Z') {
				dem++;
			}
		}
		System.out.println(dem);
	}
//		String replaceText = text.replace(" ", "");
//		String[] textSplit = replaceText.split("");
//		for (int i = 0; i < textSplit.length; i++) {
//			if (textSplit[i].equals(textSplit[i].toUpperCase())) {
//				dem = dem + 1;
//				System.out.println(textSplit[i]);
//			}


//	@Test
	public void bai_2() {
		String text = "Automation Testing 012345 Tutorials Online 6789";
		String[] textSplit = text.split("");
		int dem = 0;
		int demSo = 0;

//		Dem so luong ki tu "a"
		for (int i = 0; i < textSplit.length; i++) {
			if (textSplit[i].equals("a") || textSplit[i].equals("A")) {
				dem = dem + 1;
			}
		}
		System.out.println(dem);

//		Kiem tra chuoi co chua tu "Testing"
		String textContains = "Testing";
		System.out.println(text.contains(textContains));

		int indexString = text.indexOf("Tutorials");
		System.out.println(indexString);

		System.out.println(text.startsWith("Automation"));

		System.out.println(text.endsWith("Online"));

		String replaceString = text.replace("Online", "Offline");
		System.out.println(replaceString);

		char textChart[] = text.toCharArray();
		for (int i = 0; i < textChart.length; i++) {
			if (textChart[i] >= '0' && textChart[i] <= '9') {
				demSo++;
			}
		}
		System.out.println("dem so = " + demSo);
	}

//	@Test
	public void bai_3() {
		System.out.print("nhập text : ");
		String textString = scanner.nextLine();
		String newText = new StringBuffer(textString).reverse().toString();
		System.out.println(textString);
		System.out.println(newText);

	}

}
