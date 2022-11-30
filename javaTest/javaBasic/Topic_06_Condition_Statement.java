package javaBasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Topic_06_Condition_Statement {
	static int n, a, b, c, d, f;
	static String nameA, nameB;
	static double diemHS;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

//		Bài 1:
//		n = scanner.nextInt();
//		System.out.println("n = " + n);
//		if (n % 2 == 0) {
//			System.out.println("n là số chẵn");
//		}else {
//			System.out.println("n là số lẻ");
//		}
//		System.out.println("");		
//		Bài 2:
//		a = scanner.nextInt();
//		System.out.println("a = " + a);
//		b = scanner.nextInt();
//		System.out.println("b = " + b);
//		
//		if (a>=b) {
//			System.out.println("a lớn hơn hoặc bằng b");
//		} else {
//			System.out.println("a nhỏ hơn hoặc bằng b");
//		}
//		System.out.println("");	
// 		Bài 3:
//		nameA = scanner.nextLine();
//		System.out.println("nameA = " + nameA);
//		nameB = scanner.nextLine();
//		System.out.println("nameB = " + nameB);
//		
//		if (nameA.equalsIgnoreCase(nameB)) {
//			System.out.println("2 người là cùng tên");
//		}else {
//			
//			System.out.println("2 người là khác tên");
//		}	
//		Bài 4:
//		System.out.println("Nhập 3 Số nguyên bất kỳ:");
//		c = scanner.nextInt();
//		System.out.println("c = " + c);
//		d = scanner.nextInt();
//		System.out.println("d = " + d);
//		f = scanner.nextInt();
//		System.out.println("f = " + f);
//		
//		if (c<d) {
//			if (d<f) {
//				System.out.println(f);
//			} else {
//				System.out.println(d);
//			}
//		} else {
//			System.out.println(c);
//		}
//		Bài 5:
//		System.out.print("Nhập số nguyên a:");
//		int e =  scanner.nextInt();
//		if (e >= 10 && e <= 100) {
//			System.out.println("P nằm trong [10, 100]");
//		}else {
//			System.out.println("P không nằm trong [10, 100]");
//		}
//		Bài 6:
//		System.out.print("Nhập điểm của học sinh: ");
//		diemHS = scanner.nextDouble();
//
//		if (diemHS <= 10 && diemHS >= 8.5) {
//			System.out.println("Điểm A");
//		} else if (diemHS >= 7.5) {
//			System.out.println("Điểm B");
//		} else if (diemHS >= 5) {
//			System.out.println("Điểm C");
//		} else if (diemHS >= 0) {
//			System.out.println("Điểm D");
//		} else {
//			System.out.println("Nhập lại điểm");
//		}

//
		a = scanner.nextInt();
		b = scanner.nextInt();
		String phepTinh;
		phepTinh = scanner.next();
		switch (phepTinh) {
		case "+":
			System.out.println(a + b);
			break;
		case "-":
			System.out.println(a - b);
			break;
		case "*":
			System.out.println(a * b);
			break;
		case "/":
			System.out.println(a / b);
			break;
		case "%":
			System.out.println(a % b);
			break;
		}
	}
}
