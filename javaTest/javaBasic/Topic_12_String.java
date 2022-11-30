package javaBasic;

import java.security.PublicKey;
import java.util.Iterator;

import org.seleniumhq.jetty9.server.handler.ContextHandler.StaticContext;

import bsh.servlet.BshServlet;

public class Topic_12_String {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String automation = "Automation Testing ";

		/* ==========length========== */
		int length = automation.length();
		System.out.println("Do dai cua chuoi = " + length);

		/* ==========charAt========== */
		String chuoi = "Automation Testing Tutorials";
		char kiTu = chuoi.charAt(0);
		System.out.println("Ki tu = " + kiTu);

		/* ==========Concat========== */
		String testing = automation.concat("Tutorial");
		System.out.println("Noi chuoi = " + testing);

		/* ==========Compare========== */
		boolean compareValue = testing.equals(automation);
		System.out.println("So sanh chuoi = " + compareValue);

		compareValue = automation.equals(automation);
		System.out.println("So sanh chuoi = " + compareValue);

		/* ==========Index========== */
		int index = testing.indexOf("Testing");
		System.out.println("Vi tri chuoi = " + index);

		/* ==========Substring========== */
		String subStringStart = testing.substring(index);
		System.out.println("Chuoi con = " + subStringStart);

		String subStringStartToEndString = testing.substring(11, 18);
		System.out.println("Chuoi con = " + subStringStartToEndString);

		/* ==========Replace========== */
		String money = "$100.00";
		money = money.replace("$", "");
		System.out.println(money);
		double moneyD = Double.parseDouble(money);
		System.out.println("Value Double = " + moneyD);

		/* ==========Split/Substring (Tách chuỗi)========== */
		String text = "Viewing 72 of 1879 results";
		String[] subStrings = text.split(" ");
		for (int i = 0; i < subStrings.length; i++) {
			System.out.println("Vi tri thu " + i + ": " + subStrings[i]);
		}
		System.out.println(extractNumberFromString(text, 1));
		System.out.println(extractNumberFromString(text, 3));
		
		/* ==========Upper/Lower========== */
		String upper = testing.toUpperCase();
		System.out.println("In hoa = " + upper);
		String lower = testing.toLowerCase();
		System.out.println("In thuong = " + lower);
		
		/* ==========Trim========== */
		testing = "\t\n                Automation Testing Tutorials                   \n";
		System.out.println(testing);
		String trim = testing.trim();
		System.out.println("Xoa space = " + trim);
		boolean check = trim.equals("Automation Testing Tutorials");
		System.out.println("Check equal after Trim = " + check);
		
		/* ==========Convert Int/Float/Double to String========== */
		int number = 70;
		String value = String.valueOf(number);
		System.out.println("Value string = " + value);
		value = number + "";
		System.out.println("Value string = " + value);
		
		String price = "1000";
		int priceInt = Integer.parseInt(price);
		System.out.println("value = " + priceInt );
		
	}

	public static int extractNumberFromString(String text, int number) {
		String[] subStrings = text.split(" ");
		int result = Integer.parseInt(subStrings[number]);
		return result;
	}

}
