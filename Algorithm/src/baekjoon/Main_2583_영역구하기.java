package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static int N, M, X, Y, cnt;
	static int[][] map;
	static int[] visit;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visit = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			map[x][y] = 1;
			map[y][x] = 1;
		}
		cnt = 0;
		flag = false;
		visit[X] = 1;
		bfs();
		System.out.print(flag ? cnt : -1);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { X, cnt });

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			if (q[0] == Y) {
				cnt = q[1];
				flag = true;
				return;
			}
			for (int i = 1; i <= N; i++) {
				if (map[q[0]][i] == 1 && visit[i] == 0) {
					visit[i] = 1;
					queue.add(new int[] { i, q[1] + 1 });
				}
			}
		}
	}
}