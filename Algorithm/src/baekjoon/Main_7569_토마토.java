package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569_토마토 {
	static int[][][] map;
	static boolean[][][] visited;
	static int M, N, H, time, count, ans, checkCnt;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Queue<int[]> queue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][N][M];
		visited = new boolean[H][N][M];
		queue = new LinkedList<int[]>();
		count = 0;
		checkCnt = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					int a = Integer.parseInt(st.nextToken());
					if (a == 1) {
						queue.add(new int[] { j, k, i, 0 });
						visited[i][j][k] = true;
					} else if (a == 0) {
						count++;
					} else
						checkCnt++;

					map[i][j][k] = a;
				}
			}
		}

		if (count == 0) {
			if (checkCnt == N * M * H)
				ans = -1;
			else
				ans = 0;

		} else
			ans = Integer.MAX_VALUE;

		time = 0;
		bfs();
		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);

	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = q[0] + dir[d][0];
				int nc = q[1] + dir[d][1];
				if (Isin(q[2], nr, nc) && map[q[2]][nr][nc] != -1 && !visited[q[2]][nr][nc]) {
					map[q[2]][nr][nc] = 1;
					queue.add(new int[] { nr, nc, q[2], q[3] + 1 });
					visited[q[2]][nr][nc] = true;
					count--;
				}
			}
			int nh1 = q[2] - 1;
			int nh2 = q[2] + 1;

			if (Isin(nh1, q[0], q[1]) && map[nh1][q[0]][q[1]] != -1 && !visited[nh1][q[0]][q[1]]) {
				map[nh1][q[0]][q[1]] = 1;
				queue.add(new int[] { q[0], q[1], nh1, q[3] + 1 });
				visited[nh1][q[0]][q[1]] = true;
				count--;
			}

			if (Isin(nh2, q[0], q[1]) && map[nh2][q[0]][q[1]] != -1 && !visited[nh2][q[0]][q[1]]) {
				map[nh2][q[0]][q[1]] = 1;
				queue.add(new int[] { q[0], q[1], nh2, q[3] + 1 });
				visited[nh2][q[0]][q[1]] = true;
				count--;
			}

			if (count == 0) {
				ans = Math.min(ans, q[3] + 1);
			}
		}
	}

	private static boolean Isin(int nh, int nr, int nc) {
		return nh > -1 && nh < H && nr > -1 && nr < N && nc > -1 && nc < M;
	}

}