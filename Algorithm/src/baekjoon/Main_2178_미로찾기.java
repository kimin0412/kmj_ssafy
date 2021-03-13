package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로찾기 {
	static int[][] map;
	static boolean[][] visited;
	static int N, M, ans;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());


		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				int a = s.charAt(j) - '0';
				map[i][j] = a;
			}
		}
		
		ans = Integer.MAX_VALUE;

		bfs();
		System.out.println(ans);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { 0, 0, 1 });
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[0] == (N - 1) && q[1] == (M - 1)) {
				ans = Math.min(ans, q[2]);
			}

			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dir[d][0];
				int nc = q[1] + dir[d][1];
				if (Isin(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
					queue.add(new int[] { nr, nc, q[2] + 1 });
					visited[nr][nc] = true;
				}

			}
		}

	}

	private static boolean Isin(int r, int c) {
		return r > -1 && r < N && c > -1 && c < M;
	}

}
