package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1861_정사각형방_dfs {
	static int[][] map;
	static int N;
	static int max = 0;
	static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d4/1861_정사각형방.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());
		// 마주보는 방을 같은 번호로 맞추고 옮길때마다 누적하여 가장 큰수를 출력한다.

		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			dfs(1, 1);
			
			
			int n = 0, max = 0, maxn = 0;
			int cnt = 0;
			int r = 1;
			int c = 1;
			while (n != N * N) {
				n++;
				for (int i = 1; i <= N; i++) {
					cnt = 1;
					for (int j = 1; j <= N; j++) {
						if (map[i][j] == n) {
							r = i;
							c = j;
							
							while (true) {
								if (map[r][c] != 0) {
									if (map[r + 1][c] == (n + 1)) {
										r = r + 1;
										cnt++;
										n++;
									} else if (map[r - 1][c] == (n + 1)) {
										r = r - 1;
										cnt++;
										n++;
									} else if (map[r][c + 1] == (n + 1)) {
										c = c + 1;
										cnt++;
										n++;
									} else if (map[r][c - 1] == (n + 1)) {
										c = c - 1;
										cnt++;
										n++;
									} else {
										break;
									}
								}

								if (max < cnt) {
									max = cnt;
									maxn = n;
								}
								// 최대값비교
							}
						}
					}
				}
			}
			System.out.println(maxn-max+1 + " " + max);


		}

	}

	private static void dfs(int r, int c, int num, int cnt) {
//		int r = 0, c = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] == num) {
					r = i;
					c = j;
				}
			}
		}

		for (int k = 0; k < 4; k++) {
			int nr = r + dir[k][0];
			int nc = c + dir[k][1];
			if (map[nr][nc] == (num + 1)) {
				dfs(nr, nc, num+1, cnt+1);
			} 
		}
		
		

//		if (max < cnt) {
//			max = cnt;
//			maxn = n;
//		}
	}

}
