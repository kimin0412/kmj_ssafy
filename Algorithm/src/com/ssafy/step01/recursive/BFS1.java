package com.ssafy.step01.recursive;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class BFS1 {
	static int[][] map = new int[3][3];
	static int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		bfs1();
	}

	private static void bfs1() {
		// 0,0 ~ 2,2로 이동하는 최단 거리를 찾아보자!
		// 방문했던 곳은 더 이상 가지 말자!
		boolean[][] visited = new boolean[3][3];
		// 두 개 이상의 정보를 담아야해..
		// 배열 : int[] pair = {0,0} index가 의미, 동일 데이터 타입만 처리 {0, 0, true},
		// 출력이 번거롭다. but! 속도가 빠르고, 가볍다.
		// 사용자 정의 클래스를 사용
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(0, 0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Point front = q.poll();
			// 사용
			System.out.println(front);

			// 자식 탐색
			for (int d = 0; d < 4; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];

				if (isIn(nr, nc)) {
					if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc, front.depth + 1));
					}
				}
			}
		}

	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && 0 <= c && r < 3 && c < 3;
	}

	static class Point {
		int row, col, depth; // 행,열,깊이(단계)

		public Point(int row, int col, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + "]";
		}

	}
}
