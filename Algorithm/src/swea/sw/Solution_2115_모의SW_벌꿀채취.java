package swea.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_2115_모의SW_벌꿀채취 {
	static int N, M, C;
	static int[][] box;
	static boolean[] visit;
	static int max1, max2, ans;
	static int order;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/2115_모의SW_벌꿀채취.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			box = new int[N][N]; // 맵
			visit = new boolean[M];
			ans = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					box[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			pickBox();
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void pickBox() {
		boolean[][] selected = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - M + 1; j++) {
				for (int k = j; k < j + M; k++) {
					selected[i][k] = true;
				}

				for (int ii = 0; ii < N; ii++) {
					label: for (int jj = 0; jj < N - M + 1; jj++) {
						for (int kk = 0; kk < M; kk++) {
							if (selected[ii][jj + kk]) {
								continue label;
							}
						}
						cal(i, j, ii, jj, 0);
						ans = Math.max(ans, max1 + max2);
						max1 = 0;
						max2 = 0;
					}
				}

			}
		}
	}

	private static void cal(int i, int j, int ii, int jj, int count) {
		if (count == M) {
			int limit1 = 0, limit2 = 0, cost1 = 0, cost2 = 0;
			for (int a = 0; a < M; a++) {
				if (visit[a]) {
					limit1 += box[i][j + a];
					cost1 += (int) Math.pow(box[i][j + a], 2);
					limit2 += box[ii][jj + a];
					cost2 += (int) Math.pow(box[ii][jj + a], 2);
				}
			}
			if (limit1 <= C)
				max1 = Math.max(max1, cost1);
			if (limit2 <= C)
				max2 = Math.max(max2, cost2);
			return;
		} else {
			visit[count] = true;
			cal(i, j, ii, jj, count + 1);
			visit[count] = false;
			cal(i, j, ii, jj, count + 1);
		}
	}
}
