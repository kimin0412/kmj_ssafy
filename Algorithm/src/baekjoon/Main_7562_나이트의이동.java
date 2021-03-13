package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동 {
	static int[][] map;
	static boolean[][] visited;
	static int N, ans, si, sj, ei, ej;
//							  왼위1  		   왼위2      오른위1      오른위2      왼아래1     왼아래2     오른아래1   오른아래2
	static int[][] dir = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			si = Integer.parseInt(st.nextToken());
			sj = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			ei = Integer.parseInt(st.nextToken());
			ej = Integer.parseInt(st.nextToken());

			visited = new boolean[N][N]; // 벽을 부쉈을때, 안부쉈을때 두가지로 생각!

			ans = Integer.MAX_VALUE;
			bfs();
			System.out.println(ans);
		}
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { si, sj, 0 });
		visited[si][sj] = true;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[0] == ei && q[1] == ej) {
				ans = Math.min(ans, q[2]);
			}

			for (int d = 0; d < 8; d++) {
				int nr = q[0] + dir[d][0];
				int nc = q[1] + dir[d][1];
				if (Isin(nr, nc) && !visited[nr][nc]) {
					queue.add(new int[] { nr, nc, q[2] + 1 });
					visited[nr][nc] = true;
				}
			}
		}
	}

	private static boolean Isin(int nr, int nc) {
		return nr > -1 && nr < N && nc > -1 && nc < N;
	}
}
