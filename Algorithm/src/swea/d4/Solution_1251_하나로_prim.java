package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로_prim {
	static class Edge implements Comparable<Edge> {
		int start;
		int dest;
		long cost;

		Edge(int s, int d, long c) {
			start = s;
			dest = d;
			cost = c;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return (int) (this.cost-o.cost);
		}
	}

	static int N;
	static double E;
	static int[][] islands;
	static long[][] graph; // 정점들 간의 거리 그래프

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1251_하나로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			// 정점의 개수 (1≤N≤1,000)
			N = Integer.parseInt(br.readLine());
			islands = new int[N][2];
			// N개의 x, y 좌표를 입력받아서 저장해둘 배열
			StringTokenizer xLine = new StringTokenizer(br.readLine());
			StringTokenizer yLine = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				islands[i] = new int[] { Integer.parseInt(xLine.nextToken()), Integer.parseInt(yLine.nextToken()) };
			}
			double E = Double.parseDouble(br.readLine());
			
			// x 좌표
//			int[][] arr = new int[N][2];
//			for (int i = 0; i < N; i++) {
//				arr[i][0] = Integer.parseInt(xLine.nextToken());
//				arr[i][1] = Integer.parseInt(yLine.nextToken());
//			}


			// 정점1 정점2 가중치
			ArrayList<Edge>[] adj = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<>();
			}

//			Edges[] edges = new Edges[N * (N - 1) / 2];
			int cnt = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					adj[i].add(new Edge(i, j, dist(islands[i][0], islands[j][0], islands[i][1], islands[j][1])));
					cnt++;
				}
			}
			
			
			boolean[] visited = new boolean[N];
			PriorityQueue<Edge> queue = new PriorityQueue<>();
			int[] p = new int[N];
			p[0] = -1;
			int[] d = new int[N];
			visited[0] = true;
			queue.addAll(adj[0]);
			// 확보한 정점의 개수
			cnt = 1;
			long result = 0;
			// 모든 정점을 확보할때까지
			while (cnt != N) {
//			for (int i = 0; i < adj.length; i++) {
				Edge edge = queue.poll();
				// 이미 확보된 정점이 나오면 다시.
				if (visited[edge.dest])
					continue;
				p[edge.dest] = edge.start;
				// 확보되지 않는 놈이 나오면. 방문체크하고, 그놈에서부터 나가는 간선을 큐에 추가
				result += edge.cost;
				queue.addAll(adj[edge.dest]);
				visited[edge.dest] = true;
				cnt++;
				
			}
//			System.out.println(result);
//			System.out.println(Arrays.toString(p));

			System.out.println("#" + tc + " " + Math.round(result * E));
		}
	}

	static long dist( int x1, int x2, int y1, int y2) {
        return (long)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
}
