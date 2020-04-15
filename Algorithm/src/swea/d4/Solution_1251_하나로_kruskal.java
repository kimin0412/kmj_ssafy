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

public class Solution_1251_하나로_kruskal {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static double E;
	static long[][] islands;
	static long[][] graph; // 정점들 간의 거리 그래프
	static int[] parents;
	static int[] rank;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1251_하나로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			N = Integer.parseInt(br.readLine());
			StringTokenizer xLine = new StringTokenizer(br.readLine());
			StringTokenizer yLine = new StringTokenizer(br.readLine());
			parents = new int[N];
			rank = new int[N];
			islands = new long[N][2];
			for (int i = 0; i < N; i++) {
				islands[i] = new long[] { Long.parseLong(xLine.nextToken()), Long.parseLong(yLine.nextToken()) };
			}
			
			E = Double.parseDouble(br.readLine());
			List<double[]> costs = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == j) continue;
					double cost = E
							* (Math.pow(islands[i][0] - islands[j][0], 2) 
									+ Math.pow(islands[i][1] - islands[j][1], 2));
					costs.add(new double[] {i, j, cost});
				}
			}
			
			Collections.sort(costs, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					return Double.compare(o1[2], o2[2]);
				}
			});
			
			for (int i = 0; i < N; i++) {
				makeSet(i);
			}
			
			double result = 0;
			int cnt = 0;
			for (int i = 0; i < costs.size(); i++) {
				int a = findSet((int)costs.get(i)[0]);
				int b = findSet((int)costs.get(i)[1]);
				if (a == b)
					continue;
				union(a, b);
				result += costs.get(i)[2];
				cnt++;
				if (cnt == N - 1)
					break;
			}
			sb.append(Math.round(result));
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
