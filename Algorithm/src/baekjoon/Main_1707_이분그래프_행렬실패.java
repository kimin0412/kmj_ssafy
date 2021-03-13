package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707_이분그래프_행렬실패 {
	static int[][] map;
	static int[] color;
	static boolean[] visited;
	static int K, V, E;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			map = new int[V + 1][V + 1];
			visited = new boolean[V + 1];
			color = new int[V + 1];
			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				map[a][b] = 1;
				map[b][a] = 1;
			}

			flag = true;
			bfs();
			System.out.println(flag ? "YES" : "NO");
		}
	}

	private static void bfs() {
		for (int v = 1; v <= V; v++) {
			if(!flag)
				return;
			visited = new boolean[V + 1];
			color = new int[V + 1];

			Queue<Integer> queue = new LinkedList<Integer>();
			queue.add(v);
			visited[v] = true;
			for (int i = 1; i <= V; i++) {
				if (map[v][i] == 1) {
					color[v] = 1; // Red는 1
				}
			}

			while (!queue.isEmpty()) {
				int q = queue.poll();
				visited[q] = true;
				
				for (int i = 1; i <= V; i++) {
					if (map[q][i] == 1 && !visited[i]) {
						if (color[i] == 0) {
							queue.add(i);
							color[i] = color[q] * -1;
						} else if (color[i] == color[q] * -1) {
							queue.add(i);
							continue;
						} else {
							flag = false;
							break;
						}
					}
				}
			}
		}

	}
}