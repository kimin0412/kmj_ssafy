package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1992_쿼드트리 {
	static int[][] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = s.charAt(j) - 48;
			}
		}
		divide(0, 0, N);
		System.out.println(sb.toString());
	}

	public static boolean check(int x, int y, int n) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (arr[x][y] != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void divide(int r, int c, int n) {
		if (check(r, c, n)) {
			sb.append(arr[r][c]);
		} else {
			sb.append("(");
			int nn = n / 2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					divide(r + nn * i, c + nn * j, nn);
				}
			}
			sb.append(")");
		}
	}
}
