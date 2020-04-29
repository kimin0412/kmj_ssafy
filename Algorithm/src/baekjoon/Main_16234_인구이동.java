package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * DP O[N^2]
 */
public class Main_16234_인구이동 {
	static int N, L, R;
	static int[] dx = { -1, 1, 0, 0 }; // 상하좌우
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;
	static int[][] visit;
	static boolean flag;
	static int cnt, ans;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/16234_인구이동.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}// map 입력 완료
			
			
			for (int[] m : map) {
				System.out.println(Arrays.toString(m));
			}
			
			
			ans = 1;
			flag = true;
			cnt = 0;
			while (true) {
				if(cnt == N*N)
					break;
				
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (visit[i][j] != ans) {
							bfs(i, j);
							cnt++;
						}
						
					}
				}
				ans++;
			}
			
			
			for (int[] v : visit) {
				System.out.println(Arrays.toString(v));
			}

			System.out.println(tc + " : " + (ans-1));
		}

	}

	private static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.offer(new int[] { r, c });
		visit[r][c] = ans;
		boolean flag = false;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dx[d];
				int nc = tmp[1] + dy[d];
				if (-1 < nr && nr < N && -1 < nc && nc < N && visit[nr][nc]!=ans) {
					int cha = Math.abs(map[nr][nc] - map[tmp[0]][tmp[1]]);
					if (L <= cha && cha <= R) {
						q.offer(new int[] { nr, nc });
						visit[nr][nc] = ans;
						cnt++;
						flag = true;
					}
					for (int[] v : visit) {
						System.out.println(Arrays.toString(v));
					}
					System.out.println();
				}
			}

		}
		if(flag == true)
			ans++;

	}
}
