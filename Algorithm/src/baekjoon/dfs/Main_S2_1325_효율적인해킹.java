package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S2_1325_효율적인해킹 {
	static int[][] map;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;
	static int M;
	static int maxcnt = Integer.MAX_VALUE;
	static int[] answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/dfs/1325_효율적인해킹.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		answer = new int[N];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[c][r] = 1;
		}
		for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					dfs(i, j);
				}
			}
		}

	}

	private static void dfs(int r, int c) {
//		if()
		LinkedList<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int i = 0; i < N; i++) {
//				if(map[tmp[1][i] ==])
			}
		}

	}
}
