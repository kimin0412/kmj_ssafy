package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16234_인구이동2 {
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int N, L, R;
	static int[][] map;
	static boolean[][] visited;
	static int[][] open;
	static int count = 0;
	static int sum = 0;
	static int flag_count = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		L = Integer.parseInt(str[1]);
		R = Integer.parseInt(str[2]);

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		loop: while (true) {
			visited = new boolean[N][N];
			open = new int[N][N];
			flag_count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 각 좌표들에 대해 국경을 열 수 있는지 체크
					castleOpen(new dot(i, j));
				}
			}
			// 연결할 나라가 없다면 break 해준다.
			if (flag_count == 0) {
				break loop;
			} else {
				count++;
			}
			// 연결된 나라들에 대해서 인구를 분배해준다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (open[i][j] == 1 && !visited[i][j]) {
						bfs(new dot(i, j));
					}
				}
			}

		}

		System.out.println(count);
	}

	public static void castleOpen(dot d) {
		int x = d.x;
		int y = d.y;

		for (int i = 0; i < 4; i++) {
			int x1 = d.x + dx[i];
			int y1 = d.y + dy[i];
			// L 이상 R이하의 범위이면 두 나라를 연결시켜준다.
			if (x1 >= 0 && x1 < N && y1 >= 0 && y1 < N) {
				if (Math.abs(map[x][y] - map[x1][y1]) >= L && Math.abs(map[x][y] - map[x1][y1]) <= R) {
					open[x][y] = 1;
					open[x1][y1] = 1;
					flag_count++;
				}
			}
		}
	}

	public static void bfs(dot d) {
		Queue<dot> q = new LinkedList<dot>();
		ArrayList<dot> save = new ArrayList<dot>();
		int tmp_count = 0;
		sum = 0;
		visited[d.x][d.y] = true;
		q.add(d);
		// 상하좌우에 1이라면 q에 더해준다.
		while (!q.isEmpty()) {
			dot t = q.poll();
			save.add(t);
			int x = t.x;
			int y = t.y;
			sum += map[x][y];
			tmp_count++;

			for (int i = 0; i < 4; i++) {
				int x1 = x + dx[i];
				int y1 = y + dy[i];

				if (x1 >= 0 && x1 < N && y1 >= 0 && y1 < N && Math.abs(map[x][y] - map[x1][y1]) >= L
						&& Math.abs(map[x][y] - map[x1][y1]) <= R && !visited[x1][y1]) {
					q.add(new dot(x1, y1));
					visited[x1][y1] = true;
				}
			}
		}
		// 나눠줄 인구를 구한 후 큐를 돌며 좌표를 구해 인구를 나누어준다.
		int divide = sum / tmp_count;

		for (int i = 0; i < save.size(); i++) {
			dot t = save.get(i);
			map[t.x][t.y] = divide;
		}

	}
}

class dot {
	int x;
	int y;

	public dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}