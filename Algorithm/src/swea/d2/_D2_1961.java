package swea.d2;

import java.util.Scanner;

public class _D2_1961 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			String[][] arr = new String[n][n];
			String[][] arr90 = new String[n][n];
			String[][] arr180 = new String[n][n];
			String[][] arr270 = new String[n][n];
			
			// 배열판 입력받기
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.next();
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr90[i][j] += arr[j][n-i];
					
				}
			}

			System.out.println("#" + test_case + " ");
		}
	}

}
