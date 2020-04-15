package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1753_최단경로 {
	static class Edge implements Comparable<Edge> {
		int v, weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [weight=" + weight + "]";
		}

	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/1753.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		List<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			// 첫번째가 출발지, 두번째가 도착지, 세번째가 가중치
			st = new StringTokenizer(br.readLine(), " ");
			adj[Integer.parseInt(st.nextToken()) - 1]
					.add(new Edge(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken())));
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		boolean[] check = new boolean[V];
		Edge[] D = new Edge[V];
		for (int i = 0; i < V; i++) {
			D[i] = new Edge(i, Integer.MAX_VALUE); // vertex보다 edge가 많으면 pq보다는 그냥 다익스트라 쓰는게 낫다.
			pq.add(D[i]);
		}
		D[K-1] = new Edge(K-1, 0); // edge가 많다면 if/else 쓰지말고 다 초기화해주고 0,0만 바꿔준다.
		check[K-1] = true;
		pq.add(D[K-1]);

		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(edge.weight == Integer.MAX_VALUE) break;
			// 살려주세요 
			// 요기에요......?
			for (Edge next : adj[edge.v]) {
				if (!check[next.v] && D[next.v].weight > D[edge.v].weight + next.weight) {
					D[next.v].weight = D[edge.v].weight + next.weight;
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			check[edge.v] = true;
		}
		for (int i = 0; i < V; i++) {
			sb.append((D[i].weight == Integer.MAX_VALUE ? "INF" : D[i].weight) + "\n");
		}
		System.out.println(sb.toString());
	}

}
