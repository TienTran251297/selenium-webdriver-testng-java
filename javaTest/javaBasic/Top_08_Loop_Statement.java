package javaBasic;

import java.lang.Math;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.testng.annotations.Test;

public class Top_08_Loop_Statement {

	Scanner scanner = new Scanner(System.in);

//	@Test
	public void TC_01() {
		System.out.print("Nhập N:");
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

//	@Test
	public void TC_02() {
		System.out.print("Nhập a:");
		int a = scanner.nextInt();
		System.out.print("Nhập b:");
		int b = scanner.nextInt();

		for (int i = a; i <= b; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

//	@Test
	public void TC_03() {
		int i;
		int tong = 0;
		for (i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				tong = tong + i;
			}
		}
		System.out.println(tong);
	}

//	@Test
	public void TC_04() {
		System.out.print("Nhap a:");
		int a = scanner.nextInt();
		System.out.print("Nhap b:");
		int b = scanner.nextInt();
		int tong = 0;
		for (int i = a; i <= b; i++) {
			tong = tong + i;
		}
		System.out.println(tong);
	}

//	@Test
	public void TC_05() {
		System.out.print("Nhap n: ");
		int n = scanner.nextInt();
		int tong = 0;
		for (int i = 1; i <= n; i++) {
			if (i % 2 != 0) {
				tong = tong + i;
			}
		}
		System.out.println(tong);
	}

//	@Test
	public void TC_06() {
		System.out.print("Nhap a:");
		int a = scanner.nextInt();
		System.out.print("Nhap b:");
		int b = scanner.nextInt();
		for (int i = a; i <= b; i++) {
			if (i % 3 == 0) {
				System.out.println(i);
			}
		}
	}

//	@Test
	public void TC_07() {
		System.out.print("Nhap n:");
		int n = scanner.nextInt();
		int gia_thua = 1;
		for (int i = 1; i <= n; i++) {
			gia_thua = gia_thua * i;
		}
		System.out.println(gia_thua);
	}

//	@Test
	public void bai_Tap_Ngoai_1() {
		for (int i = 10; i <= 200; i++) {
			if ((i % 7 == 0) && (i % 5 != 0)) {
				System.out.print(i + ", ");
			}
		}
	}

//	@Test
	public void phuong_Trinh_Bac_2() {
		int a, b, c;
		double detal;
		System.out.print("a = ");
		a = scanner.nextInt();
		System.out.print("b = ");
		b = scanner.nextInt();
		System.out.print("c = ");
		c = scanner.nextInt();

		detal = (b * b) - (4 * (a) * (c));

		if (detal > 0) {
			System.out.println("phương trình (1) có 2 nghiệm phân biệt, ta dùng công thức nghiệm sau:");
			System.out.println("x1 = " + ((-b + Math.sqrt(detal)) / (2 * a)));
			System.out.println("x2 = " + ((-b - Math.sqrt(detal)) / (2 * a)));

		} else if (detal == 0) {
			System.out.println("phương trình (1) có nghiệm kép : X1=x2=" + (-b / 2 * a));
		} else {
			System.out.println("phương trình (1) vô nghiệm");
		}
	}

//	@Test
	public void uocSo() {
		System.out.print("n = ");
		int n = scanner.nextInt();
		for (int i = 1; i <= n; i++) {
			if (i % 5 == 0) {
				System.out.println(i + " la boi cua 5");
				System.out.println("5 la uoc cua " + i);
			}
		}
	}

//	@Test
	public void while_Bai_1() {
		int n = 90;
//		while (n <= 100) {
//			if (n % 2 == 0) {
//				System.out.println(n);
//			}
//			n++;
//		}
		do {
			if (n % 2 == 0) {
				System.out.println(n);
			}
			n++;
		} while (n <= 100);
	}

//	@Test
	public void while_Bai_2() {
		System.out.print("a = ");
		int a = scanner.nextInt();
		System.out.print("b = ");
		int b = scanner.nextInt();

		while (a <= b) {
			if ((a % 3 == 0) && (a % 5 == 0)) {
				System.out.println(a);
			}
			a++;
		}
	}

//	@Test
	public void while_Bai_3() {
		int i = 1;
		System.out.print("n = ");
		int n = scanner.nextInt();
		int tong = 0;

//		while (i <= n) {
//			if (i % 2 != 0) {
//				tong = tong + i;
//			}
//			i++;
//		}
		do {
			if (i % 2 != 0) {
				tong = tong + i;
			}
			i++;
		} while (i <= n);
		System.out.println(tong);
	}

//	@Test
	public void while_Bai_4() {
		System.out.print("a = ");
		int a = scanner.nextInt();
		System.out.print("b = ");
		int b = scanner.nextInt();

//		while (a <= b) {
//			if (a % 3 == 0) {
//				System.out.println(a);
//			}
//			a++;
//		}

		do {
			if (a % 3 == 0) {
				System.out.println(a);
			}
			a++;
		} while (a <= b);
	}

//	@Test
	public void while_Bai_5() {
		System.out.print("a = ");
		int a = scanner.nextInt();
		int i = 1;
		int tich = 1;
//		while (i <= a) {
//			tich = tich * i;
//			i++;
//		}
		do {
			tich = tich * i;
			i++;
		} while (i <= a);
		System.out.println(tich);
	}

//	@Test
	public void while_Bai_6() {
		System.out.print("a = ");
		int a = scanner.nextInt();
		int tich = 0;
		int i = 1;

//		while (i <= a) {
//			if (i % 2 == 0) {
//				tich = tich + i;
//			}
//			i++;
//		}

		do {
			if (i % 2 == 0) {
				System.out.println(i);
				tich = tich + i;
			}
			i++;
		} while (i <= a);
		System.out.println("Tong = " + tich);
	}

//	@Test
	public void baitap_ArrayList_1() {
		int[] list = { 1, 6, 7, 5, 9, 3, 6, 10 };
		int max = 0;
		for (int i = 0; i < list.length; i++) {
			if (max < list[i]) {
				max = list[i];
			}
		}
		System.out.println(max);
	}

//	@Test
	public void baitap_ArrayList_2() {
		int[] list = { 1, 6, 7, 5, 9, 3, 6, 10 };
		int tongList = 0;
		tongList = list[0] + list[list.length - 1];
		System.out.println(tongList);
	}

//	@Test
	public void baitap_ArrayList_3() {
		int[] list = { 1, 6, 7, 4, 9, 3, 2, 10 };
		for (int i = 0; i < list.length; i++) {
			if (list[i] % 2 == 0) {
				System.out.println(list[i]);
			}
		}
	}

//	@Test
	public void baitap_ArrayList_4() {
		int[] list = { 1, 6, 7, -4, 9, -3, 2, 10, 0 };
		int tong = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] >= 0 && list[i] % 2 != 0) {
				tong = tong + list[i];
			}
		}
		System.out.println(tong);
	}

//	@Test
	public void baitap_ArrayList_5() {
		int[] list = { 1, 6, 7, -4, 9, -3, 2, 10, 0, 12, -1, 11, 100 };
		for (int i = 0; i < list.length; i++) {
			if (list[i] >= 0 && list[i] <= 10) {
				System.out.println(list[i]);
			}
		}
	}

	@Test
	public void baitap_ArrayList_6() {
		int[] list = { -1, -2, -3, 2, 4, 6, 8 };
		int tong = 0;
		int dem = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] > 0) {

				dem = dem + 1;
				System.out.println(list[i]);
				tong = tong + list[i];
			}
		}
		System.out.println(tong);
		System.out.println(dem);
		System.out.println("TBC= " + (tong / dem));
	}

//	@Test
	public void sort_Array() {
		int[] list = { 1, 6, 7, -4, 9, -3, 2, 10, 0, 12, -1, 11, 100 };
		Arrays.sort(list);
		for (int lists : list) {
			System.out.println(lists);
		}
		String listString = Arrays.toString(list);
		System.out.println(listString);
	}

//	@Test
	public void arrray_List() {
		int[] list = new int[5];
		Arrays.fill(list, 100);
		for (int i : list) {
			System.out.println(i);
		}
	}
}