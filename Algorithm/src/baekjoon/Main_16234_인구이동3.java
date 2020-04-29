package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16234_인구이동3 {
	static int N, L, R;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] map2;
	static boolean[][] visit;
	static boolean flag;
	static int cnt, ans, sum = 0, mapCnt = 0;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/baekjoon/16234_인구이동.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine());

//		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // map 입력 완료

//			for (int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}

			top: while (true) {
				visit = new boolean[N][N];
				map2 = new int[N][N];
				mapCnt = 0;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						isOpen(i, j);
					}
				}
				if (mapCnt == 0) {
					break top;
				} else {
					cnt++;
				}

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map2[i][j] == 1 && !visit[i][j]) {
							bfs(i, j);
						}
					}
				}
			}
//			System.out.println(tc + " : " + cnt);
			System.out.println(cnt);
//		}
	}

	private static void isOpen(int r, int c) {
		int x = r;
		int y = c;

		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];

			if (nr > -1 && nr < N && nc > -1 && nc < N) {
				int cha = Math.abs(map[nr][nc] - map[x][y]);
				if (cha >= L && cha <= R) {
					map2[x][y] = 1;
					map2[nr][nc] = 1;
					mapCnt++;
				}
			}
		}
	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		ArrayList<int[]> save = new ArrayList<int[]>();
		int tmpCnt = 0;
		sum = 0;
		visit[r][c] = true;
		q.offer(new int[] { r, c });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			save.add(tmp);
			int x = tmp[0];
			int y = tmp[1];
			sum += map[x][y];
			tmpCnt++;

			for (int d = 0; d < 4; d++) {
				int nr = x + dx[d];
				int nc = y + dy[d];
				if (-1 < nr && nr < N && -1 < nc && nc < N && !visit[nr][nc]) {
					int cha = Math.abs(map[nr][nc] - map[x][y]);
					if (L <= cha && cha <= R) {
						q.offer(new int[] { nr, nc });
						visit[nr][nc] = true;
					}
				}
			}
		}
		int divide = sum / tmpCnt;

		for (int i = 0; i < save.size(); i++) {
			int[] tmp2 = save.get(i);
			map[tmp2[0]][tmp2[1]] = divide;

		}
	}
}
