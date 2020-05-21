package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15683_감시 {
	static int N, M, cameraCnt;
	static int[][] map;
	static LinkedList<int[]> cams;

	// 사방 탐색
	static int[][] dir1 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] dir2 = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static boolean[][][] visited;
	static int keyCnt;
	static String[] words;
	static boolean[] check;
	static int minCnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/15683_감시.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			cams = new LinkedList<>();
			visited = new boolean[64][N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] != 0 || map[i][j] == 7) {
						cams.add(new int[] { i, j });
						cameraCnt++;
					}
				}
			}
			
			solve(map);

			for (int[] a : map) {
				System.out.println(Arrays.toString(a));
			}

			System.out.println("#" + tc + " " + minCnt);
		}
	}

//	private static void solve(LinkedList<int[]> cams, int[][] map) {
	private static void solve(int[][] map) {
		int[][] mapTmp = map.clone();
		if (cams.isEmpty()) {

			return;
		}

		int[] cam = cams.poll();
//		LinkedList<int[]> list = cams;

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { cam[0], cam[1] });

		while (!q.isEmpty()) {
			System.out.println("!!");
			int[] front = q.poll();
			int r = front[0];
			int c = front[1];
//			int cnt = front[2];
			System.out.println(r + " " + c);
			switch (mapTmp[r][c]) {
			case 1:
				for (int d = 0; d < 4; d++) {
					int nr = r;
					int nc = c;
					System.out.println("방향 : " + r + " " + c);
					mapTmp = map;
//					list = cams;
					while (true) {
						nr += dir1[d][0];
						nc += dir1[d][1];
						System.out.println(nr + " " + nc);
						System.out.println(isIn(nr,nc));
						if(isIn(nr, nc)){
							if(mapTmp[nr][nc] == 6)
								break;
						}
						else break;
						mapTmp[nr][nc] = 7;
					}
//					solve(mapTmp);
				}
				break;

			case 2:

				break;

			case 3:

				break;

			case 4:

				break;

			case 5:

				break;

			}

		}

	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < M;
	}
}
