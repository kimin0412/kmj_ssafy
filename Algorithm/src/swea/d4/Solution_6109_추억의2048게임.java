package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6109_추억의2048게임 {
	static int N;
	static int X;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/6109_추억의2048게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 지도 한변크기
			String S = st.nextToken();
			int[][] map = new int[N][N]; // 맵

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int[][] map2 = new int[N][N];
			int[][] ans = new int[N][N];
			int[] tmpRC = new int[2];
			switch (S) {
			case "up":
				map2 = init(0, map, map2);
				int tmp = 0;
				tmpRC[0] = 0;
				tmpRC[1] = 0;
				boolean flag = false;
				for (int j = 0; j < N; j++) {
					flag = false;
					for (int i = 0; i < N; i++) {
						if (!flag && map2[i][j] != 0) {
							tmp = map2[i][j];
							flag = true;
							tmpRC[0] = i;
							tmpRC[1] = j;
							continue;
						}
						if (flag && map2[i][j] != 0) {
							if(tmp == map2[i][j]) {
								map2[tmpRC[0]][tmpRC[1]]*=2;
								map2[i][j] = 0;
								flag = false;
							}
							else {
								tmp = map2[i][j];
								tmpRC[0] = i;
								tmpRC[1] = j;
								flag = true;
							}
						}
					}
				}
				ans = init(0, map2, ans);
				break;

			case "down":
				map2 = init(1, map, map2);
				tmp = 0;
				for (int j = 0; j < N; j++) {
					flag = false;
					for (int i = N-1; i >= 0; i--) {
						if (!flag && map2[i][j] != 0) {
							tmp = map2[i][j];
							flag = true;
							tmpRC[0] = i;
							tmpRC[1] = j;
							continue;
						}
						if (flag && map2[i][j] != 0) {
							if(tmp == map2[i][j]) {
								map2[tmpRC[0]][tmpRC[1]]*=2;
								map2[i][j]=0;
								flag = false;
							}
							else {
								tmp = map2[i][j];
								tmpRC[0] = i;
								tmpRC[1] = j;
								flag = true;
							}
						}
					}
				}
				ans = init(1, map2, ans);
				break;

			case "left":
				map2 = init(2, map, map2);
				tmp = 0;
				for (int i = 0; i < N; i++) {
					flag = false;
					for (int j = 0; j < N; j++) {
						if (!flag && map2[i][j] != 0) {
							tmp = map2[i][j];
							flag = true;
							tmpRC[0] = i;
							tmpRC[1] = j;
							continue;
						}
						if (flag && map2[i][j] != 0) {
							if(tmp == map2[i][j]) {
								map2[tmpRC[0]][tmpRC[1]]*=2;
								map2[i][j]=0;
								flag = false;
							}
							else {
								tmp = map2[i][j];
								tmpRC[0] = i;
								tmpRC[1] = j;
								flag = true;
							}
						}
					}
				}
				ans = init(2, map2, ans);
				break;

			case "right":
				map2 = init(3, map, map2);
				tmp = 0;
				for (int i = 0; i < N; i++) {
					flag = false;
					for (int j = N-1; j >= 0; j--) {
						if (!flag && map2[i][j] != 0) {
							tmp = map2[i][j];
							flag = true;
							tmpRC[0] = i;
							tmpRC[1] = j;
							continue;
						}
						if (flag && map2[i][j] != 0) {
							if(tmp == map2[i][j]) {
								map2[tmpRC[0]][tmpRC[1]]*=2;
								map2[i][j]=0;
								flag = false;
							}
							else {
								tmp = map2[i][j];
								tmpRC[0] = i;
								tmpRC[1] = j;
								flag = true;
							}
						}
					}
				}
				ans = init(3, map2, ans);
				break;
			}
			
			System.out.println("#"+tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(ans[i][j] +" ");
				}
				System.out.println();
			}
		}
	}

	private static int[][] init(int x, int[][]map1, int[][] map2) {
		switch (x) {
		case 0:
			int ii = 0, jj = 0;
			for (int j = 0; j < N; j++) {
				ii = 0;
				for (int i = 0; i < N; i++) {
					if (map1[i][j] != 0) {
						map2[ii][j] = map1[i][j];
						ii++;
					}
				}
			}
			break;

		case 1:
			ii = N-1;
			for (int j = 0; j < N; j++) {
				ii = N-1;
				for (int i = N-1; i >= 0; i--) {
					if (map1[i][j] != 0) {
						map2[ii][j] = map1[i][j];
						ii--;
					}
				}
			}
			break;

		case 2:
			jj = 0;
			for (int i = 0; i < N; i++) {
				jj = 0;
				for (int j = 0; j < N; j++) {
					if (map1[i][j] != 0) {
						map2[i][jj] = map1[i][j];
						jj++;
					}
				}
			}
			break;

		case 3:
			jj = N-1;
			for (int i = 0; i < N; i++) {
				jj = N-1;
				for (int j = N-1; j >= 0; j--) {
					if (map1[i][j] != 0) {
						map2[i][jj] = map1[i][j];
						jj--;
					}
				}
			}
			break;
		}
		return map2;
	}
}