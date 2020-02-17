package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S1_7576_토마토 {
	static int C;
	static int R;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/bfs/7576_토마토.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringTokenizer st1 = new StringTokenizer(s);

		C = Integer.parseInt(st1.nextToken());
		R = Integer.parseInt(st1.nextToken());
		int[][] arr = new int[R][C];
		Queue<Integer[]> queue = new LinkedList<Integer[]>();

		for (int i = 0; i < R; i++) {
			String ss = br.readLine();
			StringTokenizer st2 = new StringTokenizer(ss);
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st2.nextToken());
				if (arr[i][j] == 1) {
					Integer[] temp = { i, j };
					queue.add(temp);
				}
			}
		}

		while (!queue.isEmpty()) {
			Integer[] now = queue.poll();
			for (int i = 0; i < dr.length; i++) {
				int nr = now[0] + dr[i];
				int nc = now[1] + dc[i];

				if ((0 <= nr && nr < R && 0 <= nc && nc < C) && arr[nr][nc] == 0) {
					arr[nr][nc] = arr[now[0]][now[1]] + 1;
					Integer[] temp = { nr, nc };
					queue.add(temp);
				}
			}
		}

		int sol = 1;
		top: for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 0) {
					sol = 0;
					break top;
				} else if (sol < arr[i][j]) {
					sol = arr[i][j];
				}
			}
		}
		System.out.println(sol - 1);
	}

}