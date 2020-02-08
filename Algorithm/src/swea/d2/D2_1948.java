package D2;

import java.util.Scanner;

public class D2_1948 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] date = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			int m1 = sc.nextInt();
			int d1 = sc.nextInt();
			int m2 = sc.nextInt();
			int d2 = sc.nextInt();
			int date1=0, date2=0;
			
			for (int i = 0; i < m1-1; i++) {
				date1+=date[i];
			}
			date1+=d1;
			
			for (int i = 0; i < m2-1; i++) {
				date2+=date[i];
			}
			date2+=d2;
			
			System.out.println("#"+ test_case+ " " + (date2-date1+1));
		}
	}
}
