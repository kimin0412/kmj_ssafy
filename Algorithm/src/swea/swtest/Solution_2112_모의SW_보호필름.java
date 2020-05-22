package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112_모의SW_보호필름 {
	static int[][] map;
	static int[][] tmpMap;
	static int[] visit;
	static int[] dirR = { -1, 1, 0, 0 };
	static int[] dirC = { 0, 0, -1, 1 };
	static int D, W, K;
	static int minCnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/2112_모의SW_보호필름.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int[D][W];
			tmpMap = new int[D][W];
			visit = new int[D];
			int max = 0;

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			for (int[] m : map) {
				System.out.println(Arrays.toString(m));
			}
			minCnt = Integer.MAX_VALUE;
			subset(0, 0);

			System.out.println("#" + tc + " " + minCnt);
		}
	}

	private static void subset(int cnt, int cur) {
		if (cnt >= minCnt)
			return;

		if (checkMap()) {
			minCnt = Math.min(minCnt, cnt);
			System.out.println("!!! " + cnt);
			return;
		}

		if (cur == D + 1) {
			for (int i = 0; i < D; i++)
				for (int j = 0; j < W; j++)
					tmpMap[i][j] = map[i][j];
			for (int i = 0; i < D; i++) {
				if (visit[i] != -1) {
					for (int j = 0; j < W; j++) {
						tmpMap[i][j] = visit[i];
					}
				}
			}
			return;
		}

		visit[cur] = -1;
		subset(cur + 1, cnt);
		if (cur == D)
			return;
		visit[cur] = 0;
		subset(cur + 1, cnt + 1);
		visit[cur] = 1;
		subset(cur + 1, cnt + 1);
	}

	private static boolean checkMap() {
		for (int i = 0; i < W; i++) {
			int chkCnt = 1;
			for (int j = 0; j <= D - 1; j++) {
				if (chkCnt >= K)
					break;
				if (tmpMap[j][i] == tmpMap[j + 1][i])
					chkCnt++;
				else
					chkCnt = 1;
			}
			if (chkCnt < K)
				return false;
		}
		return true;
	}
}
