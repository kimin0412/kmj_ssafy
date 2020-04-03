package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5987_달리기2 {
	static int N, M;
	static int[] needs;
	static long[] memo;
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
			memo = new long[(1 << N)];
			int f, s;
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				f = Integer.parseInt(st.nextToken()) - 1;
				s = Integer.parseInt(st.nextToken()) - 1;
				needs[f] |= (1 << s);
			}
			count = 0;
			long r = dfs(0);

			System.out.println("#" + tc + " " + r);
		}
	}

	private static long dfs(int flag) {
		if (flag == (1 << N) - 1) {
			// count++;
			return 1;
		}
		if (memo[flag] > 0) {
			return memo[flag];
		}
		// 순열
		for (int i = 0; i < N; i++) {
			// 순열
			if ((flag & 1 << i) == 0) {
				//
				System.out.println("flag : " + flag);
				System.out.println("flag : " + Integer.toBinaryString(flag));
				System.out.println((flag & needs[i]) + " " + needs[i]);
				System.out.println(Integer.toBinaryString(flag & needs[i]) + " " + Integer.toBinaryString(needs[i]));
				
				if ((flag ) == needs[i]) {
					System.out.println("!" + Integer.toBinaryString(flag) + " " + Integer.toBinaryString(needs[i]));
				}
				if ((flag & needs[i]) == needs[i]) {
//				if ((flag ) == needs[i]) {
					System.out.println((flag & needs[i]) + " " + needs[i]);
					System.out.println(Integer.toBinaryString(flag & needs[i]) + " " + Integer.toBinaryString(needs[i]));
					System.out.println();
					// 순열
					memo[flag] += dfs(flag | 1 << i);
				}
			}
		}
		//
		return memo[flag];
	}
}
