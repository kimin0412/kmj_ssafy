package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S1_2178_미로탐색_bfs {
	static int[][] map;
	static int[][] visit;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;
	static int M;
	static int mincnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/dfs/2178_미로탐색.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];

		for (int n = 0; n < N; n++) {
			String s = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = s.charAt(m) - '0';
			}
		}

		visit[0][0] = 1;
		bfs(0, 0, 0);
		System.out.println(map[N-1][M-1]);
	}

	private static void bfs(int r, int c, int cnt) {
		LinkedList<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {r, c, cnt});
		
		while(!queue.isEmpty()) {
			int[] tmp  = queue.poll();
			for (int d = 0; d < 4; d++) {
				int nr = tmp[0] + dir[d][0];
				int nc = tmp[1] + dir[d][1];
				if(nr>-1 && nr<N && nc>-1 && nc<M 
						&& map[nr][nc] == 1 && visit[nr][nc] == 0) {
					queue.offer(new int[] {nr, nc, cnt});
	                map[nr][nc] = map[tmp[0]][tmp[1]] + 1;
	                visit[nr][nc] = 1;
				}
			}
		}
	}
}
