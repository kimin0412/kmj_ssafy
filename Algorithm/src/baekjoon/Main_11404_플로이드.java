package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11404_플로이드 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/11404_플로이드.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] D = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				D[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			if (D[a][b] > c)
				D[a][b] = c;
		}

		final int MAX = Integer.MAX_VALUE;

		for (int k = 0; k < D.length; k++) { // 경유 정점
			for (int i = 0; i < D.length; i++) { // 출발 정점
				if (k == i)
					continue;
				for (int j = 0; j < D.length; j++) { // 도착 정점
					if (k == j || i == j)
						continue;

					if (D[i][k] != MAX && D[k][j] != MAX && D[i][j] > D[i][k] + D[k][j]) {
						D[i][j] = D[i][k] + D[k][j];
					}
				}
			}
		}

		for (int i = 0; i < D.length; i++) {
			for (int j = 0; j < D.length; j++) {
				if (D[i][j] == Integer.MAX_VALUE)
					System.out.print(0 + " ");
				else
					System.out.print(D[i][j] + " ");
			}
			System.out.println();
		}

	}

}
