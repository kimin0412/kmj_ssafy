package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	static int R, C, T, upR, downR;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_17144_미세먼지안녕.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testcase = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < testcase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());

			map = new int[R][C];
			visited = new boolean[R][C];
			boolean flag = true;
			for (int i = 0; i < R; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < C; j++) {
					int n = Integer.parseInt(st.nextToken());
					if (n == -1) {
						if (flag) {
							upR = i;
							flag = false;
						} else {
							downR = i;
						}
					}
					map[i][j] = n;
				}
			}

			count = 0;
			bfs();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					count += map[i][j];
				}
			}
			System.out.println(count + 2);
		}
	}

	private static void bfs() {
		for (int i = 0; i < T; i++) {
			spread();
			blow();
		}
	}

	private static void blow() {
		int order = 1;
		int r = upR;
		int c = 1;
		int nr = upR;
		int nc = 1;
		int[][] bMap = new int[R][C];
		bMap = copy(map);
		bMap[nr][nc] = 0;

		while (true) {
			if (order == 5)
				break;
			if (order == 1)
				nc++;
			else if (order == 2)
				nr--;
			else if (order == 3)
				nc--;
			else if (order == 4)
				nr++;

			if (Isin(nr, nc) && map[nr][nc] != -1) {
				bMap[nr][nc] = map[r][c];
				r = nr;
				c = nc;
			} else {
				nr = r;
				nc = c;
				order++;
			}
		}

		order = 1;
		r = downR;
		c = 1;
		nr = downR;
		nc = 1;
		bMap[nr][nc] = 0;

		while (true) {
			if (order == 5)
				break;
			if (order == 1)
				nc++;
			else if (order == 2)
				nr++;
			else if (order == 3)
				nc--;
			else if (order == 4)
				nr--;

			if (Isin(nr, nc) && map[nr][nc] != -1) {
				bMap[nr][nc] = map[r][c];
				r = nr;
				c = nc;
			} else {
				nr = r;
				nc = c;
				order++;
			}
		}
		map = copy(bMap);
	}

	private static void spread() {
		int[][] left = new int[R][C];
		left = copy(map);
		int[][] plus = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					int a = map[i][j] / 5;
					for (int d = 0; d < 4; d++) {
						int nr = i + dir[d][0];
						int nc = j + dir[d][1];
						if (Isin(nr, nc) && map[nr][nc] != -1) {
							plus[nr][nc] += a;
							left[i][j] -= a;
						}
					}

				}
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = left[i][j] + plus[i][j];
			}
		}
	}

	private static int[][] copy(int[][] tmpMap) {
		int[][] tmp = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tmp[i][j] = tmpMap[i][j];
			}
		}
		return tmp;
	}

	private static boolean Isin(int nr, int nc) {
		if (nr < R && nc < C && nr > -1 && nc > -1)
			return true;
		return false;
	}

}