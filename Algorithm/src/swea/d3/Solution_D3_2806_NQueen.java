package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_2806_NQueen {
	static int cnt;
	static int[] visit;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d3/2806_NQueen.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			N = Integer.parseInt(br.readLine());
			visit = new int[N];
			dfs(0);
			System.out.println(cnt);
		}
	}

	private static void dfs(int Q) {
		if (Q == N) {
			cnt++;
			return;
		}

		label: for (int i = 0; i < N; i++) {
			for (int j = 0; j < Q; j++) {
				if (i == visit[j] || Math.abs(i - visit[j]) == Q - j)
					continue label;
			}
			visit[Q] = i;
			dfs(Q + 1);
		}
	}
}
