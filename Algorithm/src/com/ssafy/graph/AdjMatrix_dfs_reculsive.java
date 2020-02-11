package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

//bfs는 끝날 때 딱 끝나는데 dfs는 넣었던걸 계속 넣었기 때문에 시간초과가 날 가능성이 커진다.
public class AdjMatrix_dfs_reculsive {
	static int[][] map;
	static boolean[] visit;
	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/lecture/graph/AdjMatrix.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			visit = new boolean[N];
			map = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 깊이 우선 탐색
			dfs(0);
			System.out.println();
		}
	}

	private static void dfs(int cur) {
		visit[cur] = true;
		System.out.printf("%c -> ", cur + 65);

//		stack을 사용하지 않고 재귀로 풀면 D가 제일 마지막에 나온다.
		for (int ad = 0; ad < N; ad++) {
			if (!visit[ad] && map[cur][ad] == 1) { // 인접한곳이 방문하지 않았고 현재위치의 인접이
				dfs(ad);
			}

		}

	}
}