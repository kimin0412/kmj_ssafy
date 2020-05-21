package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2146_다리만들기 {
	// 사방탐색
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int n, m; // 1 ≤ N, M ≤ 10
	static int[][] map, graph;
	static boolean[][] visitedGraph;
	static int islandIdx, min; // 섬의 번호
	static int INF = 987654321; // 그래프에서 사용할 초기화 값

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/2146_다리만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);

		map = new int[n][n];
		visitedGraph = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
		islandIdx = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 땅을 발견하면 거기를 기점으로 BFS 탐색 --> 연결된 지점들을 표시
				if (map[i][j] == 1) {
					bfs(i, j); // 한번의 BFS --> 섬 하나가 발견되었다!
					islandIdx++;
				}
			}
		}
		for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}

		min = Integer.MAX_VALUE;
		// 각 섬별로 거리(간선 가중치) 찾아보기
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (map[r][c] > 1) {
					visitedGraph[r][c] = true;
					dfs(r, c, map[r][c], 0);
					visitedGraph[r][c] = false;
				}
			}
		}

		// MST 구하기 및 출력
		System.out.println(min);

	}

	private static void dfs(int row, int col, int base, int cnt) {
		int nr = row;
		int nc = col;
		if (cnt >= min)
			return;
		for (int d = 0; d < 4; d++) {
			nr = nr + dx[d];
			nc = nc + dy[d];
			System.out.println(nr + " " + nc);
			if (isIn(nr, nc) && !visitedGraph[nr][nc]) {
				// 바다면 쭉 간다...
				if (map[nr][nc] == 0) {
					visitedGraph[nr][nc] = true;
					dfs(nr, nc, base, cnt + 1);
					visitedGraph[nr][nc] = false;
				}
				// 내륙 - 그만..
				else if (map[nr][nc] == base) {
					visitedGraph[nr][nc] = true;
				}
				// 아니면 다른 섬
				else {
					// 드디어 다리를 만들 수 있는 곳에 왔음...
					min = Math.min(min, cnt);
					return;
				}
			}
		}
	}

	private static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col));
		// 방문 표시 - map 자체에다가 islandIdx로 표시한다.
		map[row][col] = islandIdx;

		while (!q.isEmpty()) {
			Point front = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = front.row + dx[d];
				int nc = front.col + dy[d];

				// map[nr][nc]==1 --> 아직 방문하지 않은 땅이라면...
				if (isIn(nr, nc) && map[nr][nc] == 1) {
					map[nr][nc] = islandIdx;
					q.offer(new Point(nr, nc));
				}
			}
		}
	}

	static boolean isIn(int row, int col) {
		return 0 <= row && row < n && 0 <= col && col < n;
	}

	static class Point {
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}
	}
}
