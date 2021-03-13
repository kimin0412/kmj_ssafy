package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {
	static int R, C, ans;
	static char[][] map;
	static boolean[] visit;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[26];

		for (int i = 0; i < R; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}

		ans = 0;
		visit[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(ans);
	}

	private static void dfs(int r, int c, int cnt) {
		boolean flag = false;
		for (int d = 0; d < 4; d++) {
			int nr = r + dir[d][0];
			int nc = c + dir[d][1];
			if (Isin(nr, nc) && !visit[map[nr][nc] - 'A']) {
				flag = true;
				visit[map[nr][nc] - 'A'] = true;
				dfs(nr, nc, cnt + 1);
				visit[map[nr][nc] - 'A'] = false;
			}
		}

		if (!flag) {
			ans = Math.max(ans, cnt);
		}
	}

	private static boolean Isin(int nr, int nc) {
		return (nr > -1 && nr < R && nc > -1 && nc < C);
	}
}