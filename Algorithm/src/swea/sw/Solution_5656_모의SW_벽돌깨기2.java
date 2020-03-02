package swea.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5656_모의SW_벽돌깨기2 {
	static int N;
	static int W; // 열 개수 (가로길이)
	static int H; // 행 개수 (세로길이)
	static int mincnt = Integer.MAX_VALUE;
	static int[][] map;
	static int[][] tmpM;
	static int[] tmpPos;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/5656_모의SW_벽돌깨기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken().trim()); // 지도 한변크기
			W = Integer.parseInt(st.nextToken().trim()); // 경사로 길이
			H = Integer.parseInt(st.nextToken().trim()); // 경사로 길이
			map = new int[H][W]; // 맵
			tmpM = new int[H][W]; // 맵

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			} // 맵 입력 받기

			mincnt = Integer.MAX_VALUE;
			tmpPos = new int[N];
			pickPos(0);

			System.out.println("#" + tc + " " + mincnt);
		}
	}

	private static void pickPos(int cnt) {
		if (cnt == N) {
			bfs(tmpPos, tmpM);
			return;
		}
		for (int i = 0; i < W; i++) {
			tmpPos[cnt] = i;
			pickPos(cnt + 1);
		}
	}

	private static void mapInit(int[][] mm) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmpM[i][j] = mm[i][j];
			}
		}
	}

	private static int check(int pos, int[][] tmpM) {
		for (int j = 0; j < H; j++) {
			if (tmpM[j][pos] != 0) {
				return j;
			}
		}
		return -1;
	}

	private static int counting(int[][] tmpM) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (tmpM[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static void bfs(int[] tmpPos, int[][] tmpM) {
		LinkedList<int[]> q = new LinkedList<>();
		mapInit(map);

		for (int n = 0; n < N; n++) {
			q = new LinkedList<>();
			int nextR = check(tmpPos[n], tmpM);
			if (nextR != -1) {
				q.add(new int[] { nextR, tmpPos[n], tmpM[nextR][tmpPos[n]] });
				while (!q.isEmpty()) {
					int[] tmp = q.poll();
					for (int i = 0; i < tmp[2]; i++) {
						for (int d = 0; d < 4; d++) {
							int nr = tmp[0] + dir[d][0] * i;
							int nc = tmp[1] + dir[d][1] * i;
							if (nr > -1 && nr < H && nc > -1 && nc < W && tmpM[nr][nc] != 0) {
								q.add(new int[] { nr, nc, tmpM[nr][nc] });
								tmpM[nr][nc] = 0;
							}
						}

					}
				}
			}

			int[][] move = new int[H][W]; // 맵
			for (int i = 0; i < W; i++) {
				int jj = H - 1;
				for (int j = H - 1; j > -1; j--) {
					if (tmpM[j][i] != 0) {
						move[jj][i] = tmpM[j][i];
						jj--;
					}
				}
			}
			mapInit(move);
		}
		if (counting(tmpM) < mincnt) {
			mincnt = counting(tmpM);
		}

	}

}
