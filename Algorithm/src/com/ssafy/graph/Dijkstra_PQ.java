package com.ssafy.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 인접리스트로 구현 
/**
 *
 * [입력데이타] 6 11 0 1 4 0 2 2 0 5 25 1 3 8 1 4 7 2 1 1 2 4 4 3 5 6 4 0 3 4 3 5 4 5
 * 12
 *
 */
public class Dijkstra_PQ {
	static class Edge implements Comparable<Edge> {
		int v, weight;

		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [weight=" + weight + "]";
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수
		int E = sc.nextInt(); // 간선의 개수
		List<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			// 첫번째가 출발지, 두번째가 도착지, 세번째가 가중치
			adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}
		//
		// Dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] check = new boolean[V];
		Edge[] D = new Edge[V];
		// 0번에서 출발하는 걸로..
		for (int i = 0; i < V; i++) {
			// 원하는 출발지
//			if (i == 0) {
//				D[i] = new Edge(i, 0);
//			} else {
//				D[i] = new Edge(i, Integer.MAX_VALUE);
//			}
			D[i] = new Edge(i, Integer.MAX_VALUE); // vertex보다 edge가 많으면 pq보다는 그냥 다익스트라 쓰는게 낫다.
			pq.add(D[i]);
		}
		D[0] = new Edge(0, 0); // edge가 많다면 if/else 쓰지말고 다 초기화해주고 0,0만 바꿔준다.
		
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			for (Edge next : adj[edge.v]) {
				// check 되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
				if (!check[next.v] && D[next.v].weight > D[edge.v].weight + next.weight) {
					D[next.v].weight = D[edge.v].weight + next.weight;
					// decrease
					pq.remove(D[next.v]);
					pq.add(D[next.v]);
				}
			}
			check[edge.v] = true;
		}
		System.out.println(Arrays.toString(D));
	}
}
