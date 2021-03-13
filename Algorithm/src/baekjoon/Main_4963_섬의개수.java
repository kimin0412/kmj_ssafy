package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_4963_섬의개수 {
	static int W, H, ans;
	static int[][] map;
	static boolean[][] visit;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if (W == 0 && H == 0)
				break;

			map = new int[H][W];
			visit = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 && !visit[i][j]) {
						visit[i][j] = true;
						ans++;
						bfs(i, j);
					}
				}
			}
			System.out.println(ans);
		}
	}

	private static void bfs(int sr, int sc) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { sr, sc });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			for (int d = 0; d < 8; d++) {
				int nr = q[0] + dir[d][0];
				int nc = q[1] + dir[d][1];
				if (Isin(nr, nc) && map[nr][nc] == 1 && !visit[nr][nc]) {
					queue.add(new int[] { nr, nc });
					visit[nr][nc] = true;
				}
			}
		}
	}

	private static boolean Isin(int nr, int nc) {
		return nr > -1 && nr < H && nc > -1 && nc < W;
	}

}