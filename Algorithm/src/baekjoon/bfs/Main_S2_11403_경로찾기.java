package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S2_11403_경로찾기 {
	static int[][] map;
	static int[][] visit;
	static int[][] answer;
	static int N;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/dfs/11403_경로찾기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		answer = new int[N][N];

		for (int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				answer[n][m] = bfs(n, m);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int bfs(int start, int end) {
		visit = new int[N][N];

		LinkedList<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { start, end });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int j = 0; j < N; j++) {
				if (map[tmp[0]][j] == 1 && visit[tmp[0]][j] == 0) {
					visit[tmp[0]][j] = 1;
					answer[tmp[0]][j] = 1;
					queue.offer(new int[] { j, end });
					if (j == end) {
						return 1;
					}
				}
			}
		}
		return 0;
	}
}
