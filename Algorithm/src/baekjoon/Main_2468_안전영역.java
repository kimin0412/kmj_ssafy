package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2468_안전영역 {

	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int max = 0;
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				if (max < map[i][j]) {
					max = map[i][j];
				}
			}
		}

		int maxCount = 1;
		int cnt = 0;
		for (int c = 1; c <= max; c++) {
			visited = new boolean[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > c && visited[i][j] == false) {
						cnt++;
						dfs(i, j, c);
					}
				}
			}
			if (maxCount < cnt)
				maxCount = cnt;
		}
		System.out.println(maxCount);
	}

	public static void dfs(int r, int c, int cnt) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
				if (visited[nr][nc] == false && map[nr][nc] > cnt) {
					dfs(nr, nc, cnt);
				}
			}
		}
	}
}