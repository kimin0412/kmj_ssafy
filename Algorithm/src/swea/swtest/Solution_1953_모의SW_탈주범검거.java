package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_모의SW_탈주범검거 {
	static int[][] map;
	static boolean[][] visit;
	static int[][] dirR = { {}, { -1, 1, 0, 0 }, { -1, 1, 0, 0 }, { 0, 0, 0, 0 }, { -1, 0, 0, 0 }, { 0, 1, 0, 0 },
			{ 0, 1, 0, 0 }, { -1, 0, 0, 0 } };
	static int[][] dirC = { {}, { 0, 0, -1, 1 }, { 0, 0, 0, 0 }, { 0, 0, -1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 },
			{ 0, 0, -1, 0 }, { 0, 0, -1, 0 } };
	static int N, M, R, C, L;
	static int cnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/1953_모의SW_탈주범검거.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 1;
			Queue<int[]> q = new LinkedList<>();
			q.offer(new int[] { R, C, 1 });
			visit[R][C] = true;

			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				int r = tmp[0];
				int c = tmp[1];
				int l = tmp[2];

				if (l == L)
					break;

				for (int d = 0; d < 4; d++) {
					int nr = r + dirR[map[r][c]][d];
					int nc = c + dirC[map[r][c]][d];

					if (-1 < nr && nr < N && -1 < nc && nc < M && !visit[nr][nc] && map[nr][nc] != 0) {
						boolean flag = false;
						for (int dd = 0; dd < 4; dd++) {
							int tmpr = nr + dirR[map[nr][nc]][dd];
							int tmpc = nc + dirC[map[nr][nc]][dd];
							if (tmpr == r && tmpc == c) {
								flag = true;
								break;
							}
						}
						if (flag) {
							q.offer(new int[] { nr, nc, tmp[2] + 1 });
							visit[nr][nc] = true;
							cnt++;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
