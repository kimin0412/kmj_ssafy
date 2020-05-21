package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자 {
	static int N, M;
	static char[][] map;
	// 사방 탐색
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static boolean[][][] visited;
	static int keyCnt;
	static String[] words;
	static boolean[] check;
	static int maxCnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/1194_달이차오른다가자.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[64][N][M];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
		}

		int sr = 0;
		int sc = 0;
		keyCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					sr = i;
					sc = j;
				}
				if ('a' <= map[i][j] && map[i][j] <= 'f')
					keyCnt++;
			}
		}

		bfs(sr, sc);

		System.out.println(maxCnt);

	}

	private static void bfs(int r, int c) {
		if (map[r][c] == '1') {
			return;
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c, 0, 0 });
//						 r, c, cnt, keyNum
		visited[0][r][c] = true;

		while (!q.isEmpty()) {
			int[] front = q.poll();
			for (int d = 0; d < 4; d++) {
				int nr = front[0] + dx[d];
				int nc = front[1] + dy[d];
				if (isIn(nr, nc) && !visited[front[3]][nr][nc]) {
					if(map[nr][nc] == '1') {
						return;
					}
					if(map[nr][nc] == '#')
						continue;
					if (map[nr][nc] == '.') {
						map[r][c] = '.';
						map[nr][nc] = '0';
//						bfs(nr, nc, cnt);
						map[r][c] = '0';
						map[nr][nc] = '.';
					} else if ('a' <= map[nr][nc] && map[nr][nc] <= 'f') {
						int key2 = ( 1 << (map[nr][nc] - 'a')) | front[3];
					}
				}
			}
		}

	}

	static boolean isIn(int r, int c) {
		return 0 <= r && r <= N && 0 <= c && c <= M;
	}
}
