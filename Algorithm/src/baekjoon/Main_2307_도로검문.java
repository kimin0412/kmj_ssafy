package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2307_도로검문 {
	static int N, M;
	static int[][] map;
	static int[] dist;
	static boolean[] visit;

	public class Point {
		int r;
		int c;
		int w;

		public Point(int r, int c, int w) {
			super();
			this.r = r;
			this.c = c;
			this.w = w;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			map[a][b] = c;
		}

		dist = new int[N];
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;
		visit[0] = true;
		System.out.println(Arrays.toString(dist));

		for (int i = 0; i < N; i++) {
			int min = Integer.MAX_VALUE; // 가장 작은 값을 기억할 변수
			int index = -1; // 그 위치를 기억할 변수
			for (int j = 0; j < N; j++) { // 아직 처리하지 않았으면서, 가장 짧은 거리면
				if (!visit[j] && min > dist[j]) {
					min = dist[j];
					index = j;
				}
			} // 새로운 친구로부터 갈수있는 경로들을 업데이트
			System.out.println(index);
			
			for (int j = 0; j < N; j++) { // !check[j], adj[index][j] != 0, D[index] + adj[index][j] < D[j]
				if (!visit[j] && map[index][j] != 0 && dist[index] + map[index][j] < dist[j])
					dist[j] = dist[index] + map[index][j];
			} // 처리된놈으로 체크
			visit[index] = true;
		}
		System.out.println(Arrays.toString(dist));
	}
}
