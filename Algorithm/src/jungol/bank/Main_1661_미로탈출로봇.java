package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class Main_1661_미로탈출로봇 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/jungol/1661_미로탈출로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int X = s.charAt(0) - '0';
		int Y = s.charAt(2) - '0';
		int[][] map = new int[Y][X];
		int[][] visit = new int[Y][X]; // 방문정보

		s = br.readLine();
		int sc = s.charAt(0) - '0' - 1;
		int sr = s.charAt(2) - '0' - 1;
		int ec = s.charAt(4) - '0' - 1;
		int er = s.charAt(6) - '0' - 1;

		for (int i = 0; i < Y; i++) {
			s = br.readLine();
			for (int j = 0; j < X; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		LinkedList<int[]> queue = new LinkedList<>();
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		queue.offer(new int[] { sr, sc, 0 });
		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int r = node[0];
			int c = node[1];
			if (r == er && c == ec) {
				System.out.println(node[2]);
				break;
			}
			for (int k = 0; k < 4; k++) { 
				int nr = r + dir[k][0];
				int nc = c + dir[k][1];
				if (nr > -1 && nr < Y && nc > -1 && nc < X && map[nr][nc] != 1 && visit[nr][nc] == 0) {// 상하좌우에
					visit[nr][nc] = 1;
					queue.offer(new int[] { nr, nc, node[2] + 1 });
				}

			}
		}

	}

}
