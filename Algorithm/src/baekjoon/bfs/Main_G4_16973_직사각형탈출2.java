package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main_G4_16973_직사각형탈출2 {
	static int N, M;
	static int H, W;
	static int Sr, Sc;
	static int Fr, Fc;
	static int minCnt = Integer.MAX_VALUE;
	static int map[][];
	static boolean visit[][];
//	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	LinkedList<int[]> queue;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/bfs/16973_직사각형탈출.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N + 2][M + 2];
			visit = new boolean[N + 2][M + 2];
			for (int[] m : map) {
				Arrays.fill(m, 1);
			}

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 1; j <= M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // map입력받기 끝

			for (int[] m : map) {
				System.out.println(Arrays.toString(m));
			}

			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			Sr = Integer.parseInt(st.nextToken());
			Sc = Integer.parseInt(st.nextToken());
			Fr = Integer.parseInt(st.nextToken());
			Fc = Integer.parseInt(st.nextToken());

			int ans = -1;
			// BFS를 위해서 큐를 준비
			Queue<Node> queue = new LinkedList<>();
			// 초기상태(출발점)를 큐에 삽입하고, 초기상태의 좌표를 다시 검사하지 않기 위해서 방문췤
			queue.add(new Node(Sr, Sc, 0));
			visit[Sr][Sc] = true;

			// 큐가 빌때까지
			while (!queue.isEmpty()) {
				// 큐에서 상태를 하나 꺼내서
				Node node = queue.poll();
				// 현재 검사하는 상태가 종료점이라면 이동횟수를 ans에 저장하고 break;
				if (node.r == Fr && node.c == Fc) {
					ans = node.cnt;
					break;
				}
				// 현재 상태로부터 전이될 수 있는 상태들을 큐에 삽입하고 다시 검사하지 않기 위해서 방문췤
				for (int d = 0; d < 4; d++) {
					int nr = node.r + dr[d];
					int nc = node.c + dc[d];
					// 갈 수 있는지 검사해봐서, 괜츈 하면 큐에 삽입 ㅇㅇ

					if (movable(nr, nc, d)) {
						// 이미 간곳은 안감
						if (visit[nr][nc])
							continue;
						visit[nr][nc] = true;
						queue.add(new Node(nr, nc, node.cnt + 1));
					}

				}

			}

			// break를 못만나고 큐가 비어서 반복이 종료됐다면 ans는 -1, break를 만났다면 이동횟수가 들어있음

			System.out.println(ans);
		}
	}

	static boolean movable(int r, int c, int dir) {
		// 위로
		if (dir == 0) {
			if (r - 1 > 0) {
				for (int i = 0; i < W; i++) {
					if (map[r - 1][c + i] == 1) // [사각형의 맨 왼쪽부터 맨 오른쪽까]
						return false;
				}
			} else
				return false;

		} else if (dir == 1) {
			if (r + H <= N) {
				for (int i = 0; i < W; i++) {
					if (map[r + H][c + i] == 1) // [사각형의 맨 왼쪽부터 맨 오른쪽까]
						return false;
				}
			} else
				return false;

		} else if (dir == 2) {
			if (c - 1 > 0) {
				for (int i = 0; i < H; i++) {
					if (map[r + i][c - 1] == 1) // [사각형의 맨 왼쪽부터 맨 오른쪽까]
						return false;
				}
			} else
				return false;

		} else if (dir == 3) {
			if (c + W <= M) {
				for (int i = 0; i < H; i++) {
					if (map[r + i][c + W] == 1) // [사각형의 맨 왼쪽부터 맨 오른쪽까]
						return false;
				}
			} else
				return false;
		}
		return true;

	}

	static class Node {
		int r, c, cnt;

		Node(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
