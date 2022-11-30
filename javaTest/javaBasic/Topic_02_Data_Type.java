package javaBasic;

public class Topic_02_Data_Type {
	public static void main(String[] args) {

		// Bài tập 1:
		int a = 6, b = 2;
		int P1 = a + b;
		int P2 = a - b;
		int P3 = a * b;
		int P4 = a / b;
		System.out.println("Bài tập 1:");
		System.out.println(a + "+" + b + "=" + P1);
		System.out.println(a + "-" + b + "=" + P2);
		System.out.println(a + "*" + b + "=" + P3);
		System.out.println(a + "/" + b + "=" + P4);
		System.out.println("");
		// Bài tập 2
		double chieuDai = 7.5;
		double chieuRong = 3.8;
		double dienTich = chieuDai * chieuRong;
		System.out.println("Bài tập 2:");
		System.out.println(chieuDai + "*" + chieuRong + "=" + dienTich);
		System.out.println("");
		// Bài tập 3 
		String name = "Automation Testing";
		System.out.print("Bài tập 3: ");
		System.out.println("Hello " + name);
		System.out.println("");
		//Bài tập 4:
		int oldAge = 10;
		int newAge = oldAge + 15;
		System.out.println("Bài tập 4:");
		System.out.println("After 15 years, age of " + oldAge + " wil be " + newAge);
		System.out.println("");
		//Bài tập 5:
		int a1 = 4, b1 = 2;
		System.out.println("Bài tập 5:");
		System.out.println("Before swapping then a = " + a1 + ", b1 = " + b1);
		a1 = a1 + b1;
		b1 = a1 - b1;
		a1 = a1 - b1;
		System.out.println("After swapping then a1 = " + a1 + ", b1 = " + b1);
		System.out.println("");
		//Bài tập 6:
		System.out.println("Bài tập 6:");
		int a2, b2;
		a2 = 3;
		b2 = 4;
		System.out.println("a = " + a2);
		System.out.println("b = " + b2);
		if (a2 > b2) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
	}

}
