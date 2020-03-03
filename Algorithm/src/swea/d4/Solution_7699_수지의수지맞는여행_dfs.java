package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_7699_수지의수지맞는여행_dfs {
	static int[][] map;
	static boolean[][] visit;
	static boolean[] selected;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R, C, maxCnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/7699_수지의수지맞는여행.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R + 2][C + 2];
			visit = new boolean[R + 2][C + 2];
			selected = new boolean[27];
			for (int i = 1; i <= R; i++) {
				String line = br.readLine();
				for (int j = 1; j <= C; j++) {
					map[i][j] = line.charAt(j - 1) - 64;
				}
			}
			maxCnt = 0;
			visit[1][1] = true;
			selected[map[1][1]] = true;
			dfs(1, 1, 1);
			System.out.println("#" + tc + " " + maxCnt);
		}
	}

	private static void dfs(int r, int c, int cnt) {
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if (map[nr][nc] != 0 && !visit[nr][nc] && !selected[map[nr][nc]]) {
				visit[nr][nc] = true;
				selected[map[nr][nc]] = true;
				dfs(nr, nc, cnt + 1);
				visit[nr][nc] = false;
				selected[map[nr][nc]] = false;
			}
		}
		maxCnt = Math.max(maxCnt, cnt);
	}
}
