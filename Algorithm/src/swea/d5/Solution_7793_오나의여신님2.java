package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author mj 
 * - 안전 지역으로 가기 위한 최소 시간 : BFS 
 * - 악마와 수연이가 각각 별도의 Queue에서 동작
 * 
 * - 악마의 * : 1초마다 사방으로 퍼져나간다, ., S를 대상으로 
 * - 수연 S : 1초마다 사방탐색으로 이동, .을 대상으로 이동, D를 만나면 종료 
 * - 수연이 없어지면 - 종료
 * 
 */
public class Solution_7793_오나의여신님2 {
	// 출력을 모아서!!
	static StringBuilder sb = new StringBuilder();
	// 사방 탐색
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	static int T, R, C, ans;
	static char[][] map;
	static Queue<Point> points;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d5/7793_오나의여신님.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			///////////////////////////////////////////
			st = new StringTokenizer(br.readLine());
			// 익숙한 형태의 변수로 사용하자.
			R = Integer.parseInt(st.nextToken()); // N, M(2 ≤ N, M ≤ 50)
			C = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			
			map = new char[R][C];
			points = new LinkedList<>();
			Point player = null;
			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
				for (int c = 0; c < C; c++) {
					if (map[r][c] == '*') {
						points.offer(new Point(r, c, 0, true));
					} else if (map[r][c] == 'S') {
						player = new Point(r, c, 0, false);
					}
				}
			}
			points.offer(player); // ****S
			
			// 이제 탐험 시작!!
			// 끝나는 시점 : 모든 수연이가 소멸할 때까지 or 수연이가 여신에게 도달할 때 까지.
			outer:
			while (!points.isEmpty()) {
				Point front = points.poll();
				
				for (int d = 0; d < 4; d++) {
					int nr = front.row + dirs[d][0];
					int nc = front.col + dirs[d][1];

					if (isIn(nr, nc)) { // 범위에 있다면 수연이는 .으로 이동, D를 만나면 땡
						if (front.isDevil) {
							if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
								// 지도의 상태를 변경한 것 자체가 방문처리.
								map[nr][nc] = '*';
								// 큐에 새로 들어가긴 하지만 빠지지는 않는다.
								points.offer(new Point(nr, nc, front.depth + 1, true));
							}
						} else {
							if (map[nr][nc] == 'D') {
								ans = front.depth + 1;
								break outer;
							} else if (map[nr][nc] == '.') {
								map[nr][nc] = 'S';
								points.offer(new Point(nr, nc, front.depth + 1, false));
							}
						}
					}
				}
			}
			sb.append(ans == Integer.MAX_VALUE ? "GAME OVER" : ans);

			///////////////////////////////////////////
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && 0 <= c && r < R && c < C;
	}
	
	static class Point {
		int row, col, depth; // 행,열,깊이(단계)
		boolean isDevil;
		
		public Point(int row, int col, int depth, boolean isDevil) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
			this.isDevil = isDevil;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + "]";
		}
	}
}