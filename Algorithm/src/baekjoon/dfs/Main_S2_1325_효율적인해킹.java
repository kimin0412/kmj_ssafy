package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S2_1325_효율적인해킹 {
	static int[][] map;
	static int[][] visit;
	static int N;
	static int M;
	static int maxcnt = 0;
	static int[] answer;
	static int idx = 0;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/dfs/1325_효율적인해킹.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visit = new int[N][N];
		answer = new int[N];
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[c][r] = 1;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1) {
					visit = new int[N][N];
					dfs(i, j);
				}
			}
		}
		Arrays.sort(answer);
		for (int i = 0; i < N; i++) {
			if (answer[i] != 0) {
				System.out.print(answer[i] + " ");
			}
		}

	}

	private static void dfs(int r, int c) {
		visit[r][c] = 1;
		boolean flag = false;
		int cnt = 1;
		LinkedList<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r, c });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			flag = false;
			for (int i = 0; i < N; i++) {
				if (map[tmp[1]][i] >= 1 && visit[tmp[1]][i] == 0) {
					flag = true;
					cnt++;
					queue.add(new int[] { tmp[1], i, cnt });
				}
			}
		}
		cnt++;

		if (maxcnt < cnt) {
			maxcnt = Math.max(maxcnt, cnt);
			idx = 0;
			answer[idx] = r + 1;
			answer = new int[N];
			answer[idx] = r + 1;
		} else {
			idx++;
			answer[idx] = r + 1;
		}
//		map[r][c] = cnt;

	}
}
