package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S1_1012_유기농배추 {
	static int M;
	static int N;
	static int K;
	static int map[][];
	static int visit[][];
	LinkedList<int[]> queue;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/bfs/1012_유기농배추.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visit = new int[N][M];
			for (int n = 0; n < K; n++) {
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				map[Y][X] = 1;
			} // map입력받기 끝

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && visit[i][j] == 0) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}

	private static void bfs(int x, int y) {
		LinkedList<int[]> queue = new LinkedList<>();

		if (map[x][y] == 1 && visit[x][y] == 0) {
			queue.offer(new int[] { x, y });
			visit[x][y] = 1;
		}

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = tmp[0] + dir[i][0];
				int ny = tmp[1] + dir[i][1];

				if (ny > -1 && ny < M && nx > -1 && nx < N && map[nx][ny] == 1) {
					if (visit[nx][ny] == 0) {
						queue.offer(new int[] { nx, ny });
						visit[nx][ny] = 1;
					}
				}
			}
		}
	}
}
