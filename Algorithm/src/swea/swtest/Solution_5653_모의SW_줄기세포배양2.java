package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5653_모의SW_줄기세포배양2 {
	static int[][] map;
	static int[][] HP;
	static int[][] stime;
	static int MID = 500;
	static int N;
	static int M;
	static int K;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/5653_모의SW_줄기세포배양.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 세로
			M = Integer.parseInt(st.nextToken()); // 가로
			K = Integer.parseInt(st.nextToken()); // 시간
			map = new int[1000][1000];
			HP = new int[1000][1000];
			stime = new int[1000][1000];
			for (int i = K / 2 + 1; i < K / 2 + N + 1; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = K / 2 + 1; j < K / 2 + M + 1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					HP[i][j] = -map[i][j];
					stime[i][j] = 0;
				}
			}

			for (int k = 1; k <= K; k++) {

				for (int i = 0; i < N + K + 2; i++) {
					for (int j = 0; j < M + K + 2; j++) {
						if (map[i][j] != 0 && map[i][j] > HP[i][j] && HP[i][j] == 0) { // 활성시
							spread(i, j, k);

						}
					}
				}

				for (int i = 0; i < N + K + 2; i++) {
					for (int j = 0; j < M + K + 2; j++) {
						if (stime[i][j] != k && map[i][j] != 0 && map[i][j] > HP[i][j]) {
							HP[i][j]++;
						}
					}
				}
			}
			int cnt = 0;
			for (int i = 0; i < N + K + 2; i++) {
				for (int j = 0; j < M + K + 2; j++) {
					if (map[i][j] != 0 && HP[i][j] < map[i][j])
						cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);

		}
	}

	private static void spread(int nr, int nc, int time) {
		for (int d = 0; d < 4; d++) {
			int nextr = nr + dir[d][0];
			int nextc = nc + dir[d][1];

			if (map[nextr][nextc] == 0) {
				map[nextr][nextc] = map[nr][nc];
				HP[nextr][nextc] = -map[nr][nc];
				stime[nextr][nextc] = time;
			}

			else if (stime[nextr][nextc] == time && map[nextr][nextc] < map[nr][nc]) {
				map[nextr][nextc] = map[nr][nc];
				HP[nextr][nextc] = -map[nr][nc];
				stime[nextr][nextc] = time;
			}

		}

	}

}
