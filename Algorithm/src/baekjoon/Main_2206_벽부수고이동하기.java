package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_벽부수고이동하기 {
	static int[][] map;
	static boolean[][][] visited;
	static int N, M, ans;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2]; // 벽을 부쉈을때, 안부쉈을때 두가지로 생각!

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			char[] c = s.toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = c[j] - '0';
			}
		}

		ans = Integer.MAX_VALUE;
		bfs();
		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>(); // flag, r, c, cnt
		queue.add(new int[] { 0, 0, 0, 1 });
		visited[0][0][0] = true;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			int flag = q[0]; // 아직 벽을 부순적이 없으면 0, 있으면 1
			if (q[1] == (N - 1) && q[2] == (M - 1)) {
				ans = Math.min(ans, q[3]);
			}

			for (int d = 0; d < 4; d++) {
				int nr = q[1] + dir[d][0];
				int nc = q[2] + dir[d][1];
				if (Isin(nr, nc) && !visited[nr][nc][flag]) {
					if (map[nr][nc] == 0) {
						queue.add(new int[] { flag, nr, nc, q[3] + 1 });
						visited[nr][nc][flag] = true;
					} else {
						if (flag == 0) {
							flag = 1;
							queue.add(new int[] { flag, nr, nc, q[3] + 1 });
							visited[nr][nc][flag] = true;
							flag = 0;
						}
					}
				}
			}
		}
	}

	private static boolean Isin(int nr, int nc) {
		return nr > -1 && nr < N && nc > -1 && nc < M;
	}
}
