package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_3124_최소스패닝트리 {
	static StringBuilder sb = new StringBuilder();
	static int[] parents;
	static int[] rank;
	static boolean[] visit;
	static ArrayList<int[]> mst;
	static PriorityQueue<int[]> pq;

	public static void main(String[] args) throws Exception {
		
		System.setIn(new FileInputStream("res/swea/d4/3124_최소스패닝트리.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			visit = new boolean[V+1];
			parents = new int[V + 1];
			rank = new int[V + 1];
			
			pq = new PriorityQueue<>(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					return Integer.compare(o1[2], o2[2]);
				}
			});
			mst = new ArrayList<>();

//			int[][] edges = new int[E][3];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				pq.add(new int[] { start, end, cost });
			}

			for (int i = 1; i <= V; i++) { // 일단 모든 정점들은 각각 다 대표로 만들어진다
				parents[i] = i;
			}

			for (int i = 0; i < E; i++) {
				int[] edge = pq.poll(); // 가중치 작은 순서대로 간선이 나옴
				if (findSet(edge[0]) == findSet(edge[1])) { // 간선의 대표자가 같으면 사이클이 생기므로 스킵.
					continue;
				}
				union(edge[0], edge[1]); // 사이클이 안생기는 간선의 양 접점을 하나로 합병
				mst.add(edge);// 선택된 간선을 mst에 추가
			}

			long sum = 0;
			for (int i = 0; i < mst.size(); i++) {
				sum += mst.get(i)[2];
			}

			sb.append(sum);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void makeSet(int x) {
		parents[x] = x;
	}

	static int findSet(int x) {
		if (x == parents[x])
			return x;
		else {
			parents[x] = findSet(parents[x]);
			return parents[x];
		}
	}

	static void union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		if (rank[px] > rank[py]) {
			parents[py] = px;
		} else {
			parents[px] = py; // 어느곳에나 붙여도 상관
			if (rank[px] == rank[py]) {
				rank[py]++;
			}
		}
	}
}
