package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_D3_2806_NQueen {
	static int cnt = 0;
	static int Q = 0;
	static int[][] map;
	static int[][] visit;
	static int[][] dir = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };
	static int[][] dir2 = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d3/2806_NQueen.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			cnt = 0;
			Q = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new int[N][N];
			dfs(0, 0, Q);
			System.out.println(cnt);
		}

	}

	private static void dfs(int r, int c, int Q) {
		
		if (!(r > -1 && r < N && c > -1 && c < N)) {
			System.out.println("!!");
			return;
		}
		
		
		
		boolean flag = true;
		visit[r][c] = 1;
		
		for (int[] v : visit) {
			System.out.println(Arrays.toString(v));
		}
		System.out.println();
		
		
		for (int i = 0; i < 8; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			while (nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc] == 0) {
				nr += dir[i][0];
				nc += dir[i][1];
			}
			if (nr > -1 && nr < N && nc > -1 && nc < N && map[nr][nc] == 1) {
				flag = false;
				return;
			}
		}
		if (flag == true) {
			map[r][c] = 1;
			Q++;
			if (Q == N) {
				cnt++;
				return;
			}
			for (int i = 0; i < 8; i++) {
				dfs(r + dir2[i][0], c + dir2[i][1], Q);

			}

		}
	}
}
