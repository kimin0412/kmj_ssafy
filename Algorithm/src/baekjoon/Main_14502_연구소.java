package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소 {
	static int N, M, ans;
	static int[][][] rcArr;
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rcArr = new int[3][N][M];
		for (int rc = 0; rc < 3; rc++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					bfs();
				}
			}
		}

		ans = 0;
		System.out.println(ans);
	}

	private static void bfs() {
		
		
	}
}