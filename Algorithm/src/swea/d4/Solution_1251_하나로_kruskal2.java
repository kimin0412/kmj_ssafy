package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1251_하나로_kruskal2 {
	static class Edges implements Comparable<Edges> {
		int v1;
		int v2;
		long cost;

		public Edges(int v1, int v2, long cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edges o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}

	}

	static int[] parents;
	static int[] rank;

	static StringBuilder sb = new StringBuilder();
	static int N;
	static double E;
	static long[][] islands;
	static long[][] graph; // 정점들 간의 거리 그래프

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1251_하나로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			// 정점의 개수 (1≤N≤1,000)
			N = Integer.parseInt(br.readLine());

			// N개의 x, y 좌표를 입력받아서 저장해둘 배열
			StringTokenizer xLine = new StringTokenizer(br.readLine());
			StringTokenizer yLine = new StringTokenizer(br.readLine());
			int[][] arr = new int[N][2];

			// x 좌표
			for (int i = 0; i < N; i++)
				arr[i][0] = Integer.parseInt(xLine.nextToken());

			// y 좌표
			for (int i = 0; i < N; i++)
				arr[i][1] = Integer.parseInt(yLine.nextToken());

			double E = Double.parseDouble(br.readLine());

			// 정점1 정점2 가중치
			Edges[] edges = new Edges[N * (N - 1) / 2];
			int cnt = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = 0; j < N; j++) {
					edges[cnt] = new Edges(i, j, dist(arr[i][0], arr[j][0], arr[i][1], arr[j][1]));
					cnt++;
				}
			}
			// 정렬
			Arrays.sort(edges);
			// union find 연산을 위한 준비
			parents = new int[N];
			rank = new int[N];
			for (int i = 0; i < N; i++) {
				makeSet(i);
			}
			// 크루스칼 동작
			int result = 0;
			cnt = 0;
			for (int i = 0; i < (N * (N - 1) / 2); i++) {
				int v1 = findSet(edges[i].v1);
				int v2 = findSet(edges[i].v2);
				if (v1 == v2)
					continue;
				result += edges[i].cost;
				union(v1, v2);
				cnt++;
				if (cnt == N - 1)
					break;
			}
			System.out.println(Math.round(result * E));

		}
	}

	static long dist(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
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
