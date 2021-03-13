package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1261_알고스팟 {
	static int[][] map, dist;
	static boolean[][] visited;
	static int N, M, min;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		min = Integer.MAX_VALUE;

		solve();
		System.out.println(dist[N - 1][M - 1]);
	}

	private static void solve() {
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.offer(new Point(0, 0, map[0][0]));
		dist[0][0] = map[0][0];

		while (!pq.isEmpty()) {

			Point p = pq.poll();
			int r = p.r;
			int c = p.c;
			int cost = p.cnt;

			if (dist[r][c] < cost)
				continue;

			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if (dist[nr][nc] > dist[r][c] + (map[nr][nc])) {
					dist[nr][nc] = dist[r][c] + (map[nr][nc]);
					pq.offer(new Point(nr, nc, dist[nr][nc]));
				}
			}
		}
	}

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int cnt;

		public Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.cnt, o.cnt);
		}
	}
}
