package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11559_뿌요뿌요 {
	static char[][] map;
	static boolean[][] visited;
	static int count;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[12][6];
		visited = new boolean[12][6];
		for (int i = 0; i < 12; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}

//		for (char[] js : map) {
//			System.out.println(Arrays.toString(js));
//		}
//		System.out.println();

		count = 0;
		bfs();
		System.out.println(count);
	}

	private static void bfs() {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (map[i][j] != '.') {
					find(i, j);
				}
			}
		}
	}

	private static void redown() {
		for (int j = 0; j < 6; j++) {
			for (int i = 11; i >= 0; i--) {
				if (map[i][j] != '.') {
//					System.out.println(i + " " + j);
					int cnt = 0;
					for (int k = i + 1; k < 12; k++) {
						if (map[k][j] == '.') {
							cnt++;
						}
					}
//					System.out.println("cnt : " + cnt);
					if (cnt != 0) {
						map[i + cnt][j] = map[i][j];
						map[i][j] = '.';
					}
//					for (char[] js : map) {
//						System.out.println(Arrays.toString(js));
//					}
				}
			}
		}

	}

	private static void find(int r, int c) {
		char[][] tmpMap = new char[12][6];
		boolean[][] chkMap = new boolean[12][6];

		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}
//		for (char[] js : tmpMap) {
//			System.out.println(Arrays.toString(js));
//		}

		char chk = map[r][c];
		chkMap[r][c] = true;
		int cnt = 1;
		Queue<int[]> q = new LinkedList<int[]>();

		tmpMap[r][c] = '.';
		q.offer(new int[] { r, c });
//		System.out.println(r + " " + c);

		while (!q.isEmpty()) {
			int[] pp = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = pp[0] + dir[d][0];
				int nc = pp[1] + dir[d][1];
//				System.out.println(nr + " " + nc);
				if (Isin(nr, nc) && !chkMap[nr][nc]) {
					if (map[nr][nc] == chk) {
//						chkMap[nr][nc] = true;
						q.offer(new int[] { nr, nc });
						tmpMap[nr][nc] = '.';
						chkMap[nr][nc] = true;
						cnt++;
					}
				}

			}
		}
//		for (char[] js : tmpMap) {
//			System.out.println(Arrays.toString(js));
//		}

//		System.out.println(cnt);
		if (cnt >= 4) {
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					map[i][j] = tmpMap[i][j];
				}
			}
			redown();
			count++;
		}
//		for (char[] js : map) {
//			System.out.println(Arrays.toString(js));
//		}
//		System.out.println();
//		System.out.println();
	}

	private static boolean Isin(int nr, int nc) {
		if (nr < 12 && nc < 6 && nr > -1 && nc > -1)
			return true;
		return false;
	}

}
