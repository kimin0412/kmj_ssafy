package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class S1_7576_토마토_me {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static LinkedList<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/bfs/7576_토마토.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		int day = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					queue.add(new int[] { i, j, day});
			}
		}

		int cnt = 0;
		// 큐에 토마토가 있는곳 넣기
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int d = 0; d < 4; d++) {
				int r = tmp[0] + dir[d][0];
				int c = tmp[1] + dir[d][1];
				if (r > -1 && r < N && c > -1 && c < M && arr[r][c] == 0) {
					queue.add(new int[] { r, c, tmp[2] + 1 });
					arr[r][c] = 1;
				}
			}
			cnt = tmp[2];
		}
		
		boolean flag = true;
		top:
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) {
					flag = false;
					break top;
				}
			}
		}
		if(flag == true) System.out.println(cnt);
		else System.out.println(-1);
	}
}