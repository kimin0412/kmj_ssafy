package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1949_모의SW_등산로조성 {
	static int[][] map;
	static int[][] tmpMap;
	static boolean[][] visit;
	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };
	static int N, K;
	static int maxCnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/1949_모의SW_등산로조성.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			tmpMap = new int[N][N];
			visit = new boolean[N][N];
			int max = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}

			Queue<int[]> maxRC = new LinkedList<int[]>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						maxRC.add(new int[] { i, j });
					}
				}
			}

			maxCnt = 0;
			boolean f = false;
			while (!maxRC.isEmpty()) {
				int[] tmp = maxRC.poll();
				tmpMap = map;
				System.out.println(Arrays.toString(tmp));
				visit[tmp[0]][tmp[1]] = true; // 방문체크
				dfs(tmp, max, 1, f);
				visit[tmp[0]][tmp[1]] = false;
			}

			System.out.println("#" + tc + " " + maxCnt);
		}
	}

	private static void dfs(int[] tmp, int now, int cnt, boolean flag) {
		int r = tmp[0];
		int c = tmp[1];

		for (int d = 0; d < 4; d++) {
			int nr = r + dirR[d];
			int nc = c + dirC[d];
			if (-1 < nr && nr < N && -1 < nc && nc < N && !visit[nr][nc]) {
				int x = map[nr][nc];
				if (map[nr][nc] >= now) {
					if (flag == false) {
						for (int k = 1; k <= K; k++) {
							x--;
							if (x == now - 1) {
								break;
							}
						}
						if (x >= now) {
							continue;
						} else {
							flag = true;
							visit[nr][nc] = true; // 방문체크
							dfs(new int[] { nr, nc }, x, cnt + 1, flag);
							flag = false;
							visit[nr][nc] = false;
						}
					} else {
						continue;
					}
				} else {
					visit[nr][nc] = true; // 방문체크
					dfs(new int[] { nr, nc }, x, cnt + 1, flag);
					visit[nr][nc] = false;
				}
			} else {
				if (maxCnt < cnt) {
				}
				maxCnt = Math.max(maxCnt, cnt);
			}
		}
	}
}
