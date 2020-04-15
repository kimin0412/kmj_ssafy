package com.ssafy.graph;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class kruskal {
	static int[] parents;
	static int[] rank;

	// 입력은 첫줄에 정점의 갯수와 간선의 갯수가 들어오고
	// 그 다음줄부터 간선의 정보가 정점1 정점2 가중치로 간선의 갯수만큼 들어옴
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		int[][] edges = new int[E][3];
		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt(); // 가중치
		}

		// 간선들을 가중치 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// o1[2] o2[2]
				return Integer.compare(o1[2], o2[2]);
			}
		});
		// 각 정점에 대해 유니온파인드 연산 준비.
		for (int i = 0; i < V; i++) {
			makeSet(i);
		}
		int result = 0;
		int cnt = 0;
		for (int i = 0; i < V - 1; i++) {
			int a = findSet(edges[i][0]);
			int b = findSet(edges[i][1]);
			if (a == b)
				continue;
			union(a, b);
			// 간선을 선택
			result += edges[i][2];
			// 정점의 갯수 -1번 반복하면서
			cnt++;
			if (cnt == V - 1)
				break;
		}
		System.out.println(result);
		// 간선이 연결하는 두 정점이 같은 팀이 아니라면 한팀으로 합쳐주고 간선 선택
		// 같은 팀이라면 패스
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
