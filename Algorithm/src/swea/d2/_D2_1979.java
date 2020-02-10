package swea.d2;

import java.util.Scanner;

public class _D2_1979 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int cnt = 0;

			// 배열판 입력받기
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < arr.length; i++) {
//				int cnt1 = 0;
				for (int j = 0; j < arr.length - 2; j++) {
					if (j == arr.length - 3) {
						if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1) {
							cnt++;
						}
					}
					else {
						if (arr[i][j] == 1 && arr[i][j + 1] == 1 && arr[i][j + 2] == 1 && arr[i][j+3]==0) {
							cnt++;
						}
					}
				}
			}
			System.out.println("#" + test_case + " "+ cnt);

			for (int i = 0; i < arr.length-2; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (i == arr.length - 3) {
						if (arr[j][i] == 1 && arr[j][i + 1] == 1 && arr[j][i + 2] == 1) {
							cnt++;
						}
					}
					else {
						if (arr[j][i] == 1 && arr[j][i + 1] == 1 && arr[j][i + 2] == 1 && arr[j][i+3]==0) {
							cnt++;
						}
					}
				}
			}

			System.out.println("#" + test_case + " "+ cnt);
		}
	}
}
