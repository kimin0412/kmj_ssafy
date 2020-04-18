package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_4012_모의SW_요리사 {
	static int N, min;
	static int[][] S;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/4012_모의SW_요리사.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];
			visit = new boolean[N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					S[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			min = Integer.MAX_VALUE;
			comb(0, 0);

			System.out.println("#" + tc + " " + min);
		}
	}

	static void comb(int cnt, int cur) {
		if (cur >= N)
			return;
		if (cnt == N / 2) {
			int sum1 = 0; // true일때 합
			int sum0 = 0; // false일때 합
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visit[i] != visit[j])
						continue;
					if (visit[i])
						sum1 += S[i][j] + S[j][i];
					else
						sum0 += S[i][j] + S[j][i];

				}
			}
			min = Math.min(min, Math.abs(sum1 - sum0));
			return;
		}
		for (int i = cur; i < N; i++) {
			visit[i] = true;
			comb(cnt + 1, i + 1);
			visit[i] = false;
		}

	}
}
