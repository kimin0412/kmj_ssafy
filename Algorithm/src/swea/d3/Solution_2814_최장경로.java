package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2814_최장경로 {
	static int[][] map;
	static boolean[][] visit;
	static boolean[] selected;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M, maxLength;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d3/2814_최장경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 중접 개수
			M = Integer.parseInt(st.nextToken()); // 간선 정보의 개수
			map = new int[N][N];
			visit = new boolean[N][N];
			selected = new boolean[N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				map[r - 1][c - 1] = 1;
				map[c - 1][r - 1] = 1;
			}
			for (int[] m : map) {
				System.out.println(Arrays.toString(m));
			}

			maxLength = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					visit = new boolean[N][N];
//					selected = new boolean[N];
					if (map[i][j] == 1) {
						System.out.println("i, j 시작 : " + i  + ", " + j);
//						visit[i][j] = true;
						selected[i] = true;
//						selected[j] = true;
						dfs(i, j, 1);
//						visit[i][j] = false;
						selected[i] = false;
//						selected[j] = false;
					}

				}
			}
			if (N == 1)
				System.out.println("#" + tc + " " + 1);
			else
				System.out.println("#" + tc + " " + maxLength);
		}

	}

	private static void dfs(int r, int c, int length) {
//		System.out.println("r, c : " + r + " " + c);

		int nr = c;
		for (int i = 0; i < N; i++) {
//			if (map[nr][i] != 0 && visit[nr][i] == false && selected[i] == false) {
			if (map[nr][i] != 0 && !selected[i] ) {
				System.out.println("nr, i : " + nr + " " + i);
				visit[nr][i] = true;
//				selected[i] = true;
				dfs(nr, i, length + 1);
				visit[nr][i] = false;
//				selected[i] = false;

			}
		}
		System.out.println("length : " + length);
		maxLength = Math.max(maxLength, length);

	}
}
