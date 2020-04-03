package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G4_16973_직사각형탈출 {
	static int N, M;
	static int H, W;
	static int Sr, Sc;
	static int Fr, Fc;
	static int minCnt = Integer.MAX_VALUE;
	static int map[][];
	static int visit[][];
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int K;
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
			visit = new int[N + 2][M + 2];
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

			int cnt = 0;
			bfs(Sr, Sc);
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					if (map[i][j] == 1 && visit[i][j] == 0) {
//						bfs(i, j);
//						cnt++;
//					}
//				}
//			}
			System.out.println(minCnt);
		}
	}

	private static void bfs(int r, int c) {
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c, 0 });

//		if (map[r][c] == 1 && visit[r][c] == 0) {
//			queue.offer(new int[] { x, y });
//			visit[x][y] = 1;
//		}

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			int nr = tmp[0];
			int nc = tmp[1];
			if(nr == Fr && nc == Fc) {
				minCnt = Math.max(minCnt, tmp[2]);
			}
			System.out.println("!!nr, nc : " + nr + " " + nc);

			boolean flag = true;
			for (int d = 0; d < 4; d++) {
				int tr = nr, tc = nc;
				if(d == 0) {
					for (int i = 0; i < W; i++) {
						tr += i + dir[d][0];
						tc = nc + i + dir[d][1];
						System.out.println("tr, tc : " + tr + " " + tc);
						if (!(map[tr][tc] == 0) || visit[tr][tc] != 0) {
							flag = false;
							System.out.println("break!");
							break;
						}
					}
					
					
				}
				
//				int tr = 0, tc = 0;
				if(d==0 || d==1) {
					for (int i = 0; i < W; i++) {
						tr = nr + i + dir[d][0];
						tc = nc + i + dir[d][1];
						System.out.println("tr, tc : " + tr + " " + tc);
						if (!(map[tr][tc] == 0) || visit[tr][tc] != 0) {
							flag = false;
							System.out.println("break!");
							break;
						}
					}
					if(flag == true) {
						visit[tr][tc] = 1;
						queue.offer(new int[] { nr, nc, tmp[2] });
//						map[nr][nc] = map[tmp[0]][tmp[1]] + 1;
						visit[nr][nc] = 0;
					}
				}
				else {
					for (int i = 0; i < H; i++) {
						tr = nr + i + dir[d][0];
						tc = nc + i + dir[d][1];
						System.out.println("tr, tc : " + tr + " " + tc);
						if (map[tr][tc] == 1 || visit[tr][tc] != 0) {
							flag = false;
							System.out.println("break!");
							break;
						}
					}
				}
				if(flag == true) {
					visit[tr][tc] = 1;
					queue.offer(new int[] { nr, nc, tmp[2] });
//					map[nr][nc] = map[tmp[0]][tmp[1]] + 1;
					visit[nr][nc] = 0;
				}
				
			}
		}

	}
	/*
	 * private static void bfs(int x, int y) { LinkedList<int[]> queue = new
	 * LinkedList<>();
	 * 
	 * if (map[x][y] == 1 && visit[x][y] == 0) { queue.offer(new int[] { x, y });
	 * visit[x][y] = 1; }
	 * 
	 * while (!queue.isEmpty()) { int[] tmp = queue.poll(); for (int i = 0; i < 4;
	 * i++) { int nx = tmp[0] + dir[i][0]; int ny = tmp[1] + dir[i][1];
	 * 
	 * if (ny > -1 && ny < M && nx > -1 && nx < N && map[nx][ny] == 1) { if
	 * (visit[nx][ny] == 0) { queue.offer(new int[] { nx, ny }); visit[nx][ny] = 1;
	 * } } } } }
	 */
}
