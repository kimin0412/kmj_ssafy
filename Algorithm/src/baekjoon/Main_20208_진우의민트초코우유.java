package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

public class Main_20208_진우의민트초코우유 {
	static int N, M, H, sr, sc, count;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		visited = new boolean[N][N];
		count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 1) {
					sr = i;
					sc = j;
				} else if (a == 2) {
					count++;
				}
				map[i][j] = a;
			}
		}

		ans = 0;
		bfs();
		System.out.println(ans);
	}

	private static void bfs() {
		int[] s = { sr, sc, M, 0 };
		Queue<int[]> q = new LinkedList<int[]>();

		q.add(s);

		while (!q.isEmpty()) {
			int[] p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = p[0] + dir[d][0];
				int nc = p[1] + dir[d][1];
				System.out.println(nr + " " + nc);
				
				if (Isin(nr, nc)) {
					int nM = p[2] - 1;
					int cnt = p[3] + 1;
					if (map[nr][nc] == 2)
						nM += H;
					if (nM == 0) {
						ans = Math.max(ans, cnt);
						return;
					}

					q.add(new int[] { nr, nc, nM, cnt });
				}
			}

		}

	}

	private static boolean Isin(int r, int c) {
		return (r < N && r > -1 && c < N && c > -1);
	}

}