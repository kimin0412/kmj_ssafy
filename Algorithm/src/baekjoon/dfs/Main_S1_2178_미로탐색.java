package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_S1_2178_미로탐색 {
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;
	static int M;
	static int mincnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/dfs/2178_미로탐색.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = s.charAt(m) - '0';
			}
		}
		long start = System.currentTimeMillis();
		map[0][0] = 0;
		dfs(0, 0, 0);
		System.out.println(mincnt);
		long end = System.currentTimeMillis();
		System.out.println((end-start)/1000);
		
	}

	private static void dfs(int r, int c, int cnt) {
		if (cnt >= mincnt) {
			return;
		}
		
		if (r == N - 1 && c == M - 1) {
			cnt++;
			mincnt = Math.min(mincnt, cnt);
			return;
		}


		for (int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];

			if (nr > -1 && nr < N && nc > -1 && nc < M && map[nr][nc] == 1) {
				map[nr][nc] = 0;
				dfs(nr, nc, ++cnt);
				map[nr][nc] = 1;
				cnt--;
			}
		}
	}
}
