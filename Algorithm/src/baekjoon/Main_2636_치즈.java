package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {
	static boolean[][] visited;
	static int[][] map;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int R, C, cheeseCnt, time;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visited = new boolean[R][C];
		int tmp = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					tmp++;
				}
			}
		}

		while (true) {
			bfs();
			time++;
			boolean flag = true;
			cheeseCnt = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != 0) {
						flag = false;
						cheeseCnt++;
					}
				}
			}
			if (flag)
				break;
			visited = new boolean[R][C];
			tmp = cheeseCnt;
		}
		System.out.println(time);
		System.out.println(tmp);
	}

	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0, 0));
		while (!q.isEmpty()) {
			Point front = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = front.r + dx[d];
				int nc = front.c + dy[d];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc]) {
					if (map[nr][nc] == 0) {
						q.add(new Point(nr, nc));
						visited[nr][nc] = true;
					} else {
						map[nr][nc] = 0;
						visited[nr][nc] = true;
					}
				}
			}
		}
	}

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
}