package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17142_연구소3 {
	static int N, M;
	static int[][] map;
	static List<Virus> viruses;
	static boolean[] check;
	static int virusCnt, minCnt;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/17142_연구소3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			viruses = new ArrayList<>();
			virusCnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 2) {
						viruses.add(new Virus(i, j));
						virusCnt++;
					}
				}
			}
			check = new boolean[virusCnt];

			minCnt = Integer.MAX_VALUE;
			solve(0);

			System.out.println("#" + tc + " " + minCnt);
		}

	}

	private static void solve(int cnt) {

		if (cnt == M) {
			minCnt = Math.min(cnt, minCnt);
			return;
		}
		int[][] tmpMap = new int[N][N];
		for (int i = 0; i < virusCnt; i++) {
			if (!check[i]) {
				check[i] = true;
				tmpMap = map.clone();

				Virus v = viruses.get(i);
				Queue<int[]> q = new LinkedList<>();
				q.offer(new int[] { v.row, v.col });

				while (!q.isEmpty()) {
					int[] front = q.poll();
					for (int d = 0; d < 4; d++) {
						int nr = front[0] + dir[d][0];
						int nc = front[1] + dir[d][1];
						if(isIn(nr, nc) && map[nr][nc] != 1 && map[nr][nc] !=2) {
							
							
						}
					}

				}
			}
		}

	}

	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < N;
	}

	static class Virus {
		int row;
		int col;

		public Virus(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}
	}
}
