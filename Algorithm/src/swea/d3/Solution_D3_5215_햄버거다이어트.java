package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_5215_햄버거다이어트 {
	static int[][] arr;
	static int max = 0;
	static int N;
	static int L;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/swea/d3/5215_햄버거다이어트.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < T; tc++) {
			max = 0;
			st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			arr = new int[N][2];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0, 0);
			System.out.println("#" + (tc+1) + " " +max);
		}
	}

	private static void dfs(int n, int t, int c) {
		if (c > L) {
			return;
		}
		if (n == N) {
			if (max < t) {
				max = t;
			}			
			return;
		}
		dfs(n + 1, arr[n][0] + t, arr[n][1] + c);
		dfs(n + 1, t, c);
	}
}
