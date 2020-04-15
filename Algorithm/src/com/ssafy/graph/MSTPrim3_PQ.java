package com.ssafy.graph;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// PriorityQuery 사용시 E log V
public class MSTPrim3_PQ {
	static class Edge implements Comparable<Edge>{
		int start;
		int dest; 
		int cost;
		Edge(int s, int d, int c){
			start = s;
			dest = d;
			cost = c;
		}
		@Override    		// 누구세요 ㅠ 
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.cost - o.cost;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner("7 11\n" + "0 1 31\r\n" + "0 2 31\r\n" + "0 6 31\r\n" + "0 5 60\r\n" + "1 2 21\r\n"
				+ "2 4 46\r\n" + "2 6 25\r\n" + "3 4 34\r\n" + "4 6 51\r\n" + "5 3 18\r\n" + "5 4 40\r\n");
		int V = sc.nextInt();
		int E = sc.nextInt();
		//각 정점별로 인접리스트 참조변수
		ArrayList<Edge>[] adj = new ArrayList[V];
		for(int i = 0; i < V; i++) {
			adj[i] = new ArrayList<>();
		}
		//입력되어지는 간선 배열을 인접리스트에 저장
		for(int i = 0; i < E; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			adj[a].add(new Edge(a,b,c));
			adj[b].add(new Edge(b,a,c));
		}
		boolean[] visited = new boolean[V];
		PriorityQueue<Edge> queue = new PriorityQueue<>();
		int[] p = new int[V];
		p[0] = -1;
		int[] dist = new int[V];
		//0번을 방문하거로 체크하고, 0번에서 이어지는 모든 간선을 queue에 삽입.
		visited[0] = true;
		queue.addAll(adj[0]);
		//확보한 정점의 개수
		int cnt = 1;
		int result = 0;
		//모든 정점을 확보할때까지
		while( cnt != V ) {
			Edge edge = queue.poll();
			//이미 확보된 정점이 나오면 다시.
			if( visited[edge.dest] )
				continue;
			p[edge.dest] = edge.start;
			//확보되지 않는 놈이 나오면. 방문체크하고, 그놈에서부터 나가는 간선을 큐에 추가
			result += edge.cost;
			queue.addAll(adj[edge.dest]);
			visited[edge.dest] = true;
			cnt++;
		}
		System.out.println(result);
		System.out.println(Arrays.toString(p));
	}
}

























