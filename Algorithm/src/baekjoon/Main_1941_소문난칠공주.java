package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1941_소문난칠공주 {
	static char[][] map;
	static boolean[][] visit;
	static String[] words;
	static boolean[] check;
	static int count;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/1941_소문난칠공주.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new char[5][5];
		visit = new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			map[i] = br.readLine().toCharArray();
		}

		bfs();

		for (char[] m : map) {
			System.out.println(Arrays.toString(m));
		}

		System.out.println(count);

	}

	private static void dfs() {
		boolean[][] check = new boolean[5][5];
		Queue<int[]> q = new LinkedList<>();
		int chk4 = 0;
		if (map[0][0] == 'S')
			chk4 = 1;
		q.offer(new int[] { 0, 0, 1, chk4 });
		check[0][0] = true;

		while (!q.isEmpty()) {
			int[] front = q.poll();
			int cnt = front[2];
			chk4 = front[3];
			if (cnt == 7) {
				if (chk4 >= 4) {
					bfs();
				}
				return;
			}
			for (int d = 0; d < 4; d++) {
				int nr = front[0] + dir[d][0];
				int nc = front[1] + dir[d][1];
				if (isIn(nr, nc) && !check[nr][nc]) {
					if (map[nr][nc] == 'Y') {

					}
					q.offer(new int[] { nr, nc, cnt++ });
					check[nr][nc] = true;
				}
			}
		}
	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 1 });
		visit[0][0] = true;

		while (!q.isEmpty()) {
			int[] front = q.poll();
			int r = front[0];
			int c = front[1];
			int cnt = front[2];

			for (int d = 0; d < 4; d++) {
				int nr = r + dir[d][0];
				int nc = c + dir[d][1];
				if (isIn(nr, nc) && !visit[nr][nc]) {
					q.add(new int[] { nr, nc, cnt + 1 });
					visit[nr][nc] = true;
				}
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < 5 && 0 <= nc && nc < 5;
	}

//	private static void dfs(String word, int cnt, int order, List<Character> tmpList) {
//		int tmpCnt = cnt;
////		System.out.println(tmpCnt + " " + tmpList);
//		for (int i = 0; i < word.length(); i++) {
//			if (!tmpList.contains(word.charAt(i))) {
//				tmpList.add(word.charAt(i));
//				tmpCnt++;
//			}
//		}
//
//		if (tmpCnt > K) {
//			maxCnt = Math.max(maxCnt, order);
//			return;
//		} else {
//			order++;
//		}
//
//		for (int i = 0; i < N; i++) {
//			if (!check[i] && words[i].length() <= K) {
//				check[i] = true;
//				dfs(words[i], tmpCnt, order, tmpList);
//				check[i] = false;
//			}
//		}
//	}
}
