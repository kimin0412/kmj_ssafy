package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5987_달리기 {
	static int N, M;
	static int[] needs;
	static int count;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/5987_달리기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			needs = new int[N];
			int f, s;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				f = Integer.parseInt(st.nextToken())-1;
				s = Integer.parseInt(st.nextToken())-1;
				needs[f] |= (1 << s);
			}
			count = 0;
			dfs(0);

			System.out.println("#" + tc + " " + count);
		}
	}

	private static void dfs(int flag) {
		if (flag == (1 << N) - 1) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0) {
				if ((flag & needs[i]) == needs[i]) {
					dfs(flag | 1 << i);
				}
			}
		}
	}
}
