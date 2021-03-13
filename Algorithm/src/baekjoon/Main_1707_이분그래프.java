package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {
/*
 * 참고 : https://gmlwjd9405.github.io/2018/08/23/algorithm-bipartite-graph.html
 */
	
//	static ArrayList<ArrayList<Integer>> arrayLists;
	static List<Integer>[] lists;
	static int[] color;
	static int K, V, E;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

//			arrayLists = new ArrayList<>();
			lists = new ArrayList[V + 1];
			color = new int[V + 1];

			for (int i = 1; i <= V; i++) {
//				arrayLists.add(new ArrayList<Integer>());
				lists[i] = new ArrayList<Integer>();
			}

			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
//				arrayLists.get(a).add(b);
//				arrayLists.get(b).add(a);
				lists[a].add(b);
				lists[b].add(a);
			}

			flag = true;
			bfs();
			System.out.println(flag ? "YES" : "NO");
		}
	}

	private static void bfs() {
		for (int v = 1; v <= V; v++) {
			if (color[v] == 0) {
				Queue<Integer> queue = new LinkedList<Integer>();
				queue.add(v);
				color[v] = 1;

				while (!queue.isEmpty()) {
					int q = queue.poll();
					for (int e : lists[q]) {
						if (color[e] == 0) {
							queue.add(e);
							color[e] = color[q] * -1;
						} else if (color[e] != color[q] * -1) {
							flag = false;
							return;
						}
					}
				}
			}
		}
	}
}
