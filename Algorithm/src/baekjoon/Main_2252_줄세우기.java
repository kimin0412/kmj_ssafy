package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2252_줄세우기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int indegree[] = new int[N + 1];
		LinkedList<Integer> graph[] = new LinkedList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			graph[i] = new LinkedList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			indegree[b]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				q.offer(i);
				System.out.print(i + " ");
			}
		}

		while (!q.isEmpty()) {
			int front = q.poll();
			for (int node : graph[front]) {
				indegree[node]--;
				if (indegree[node] == 0) {
					q.add(node);
					System.out.print(node + " ");
				}
			}

		}
	}
}
