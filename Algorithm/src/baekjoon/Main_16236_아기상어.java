package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_아기상어 {
	static int n, sr, sc, ssize, cnt;
	static int[][] map;
	// 사방 탐색
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	// 상어의 이동거리
	static int sharkMoveCnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/16236_아기상어.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			sharkMoveCnt = 0;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];

			Shark shark = null;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 9) {
						shark = new Shark(i, j, 2, 0, 0);
						map[i][j] = 0;
					}
				}
			}

			bfs(shark);

			System.out.println(sharkMoveCnt);
		}

	}

	private static void bfs(Shark shark) {
		Queue<Shark> queue = new LinkedList<Shark>();
		queue.offer(shark);

		boolean[][] visited = new boolean[n][n];
		visited[shark.row][shark.col] = true;

		// 먹을 수 있는 물고기를 저장할 PQ
		PriorityQueue<Fish> targetFishes = new PriorityQueue<>();
		Shark front = null;
		findFisht: while (!queue.isEmpty()) {
			front = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nr = front.row + dx[d];
				int nc = front.col + dy[d];

				if (isIn(nr, nc) && !visited[nr][nc]) {
					visited[nr][nc] = true;
					// 이동한 점의 값에 따라서 분기 처리.
					// 이동가능
					if (map[nr][nc] == 0 || map[nr][nc] == front.size) {
						queue.offer(new Shark(nr, nc, front.size, front.depth + 1, front.eatCnt));
					}
					// 먹을 수 있다.
					else if (map[nr][nc] < front.size) {
						if (targetFishes.isEmpty()) {
							targetFishes.offer(new Fish(nr, nc, map[nr][nc], front.depth + 1));
						}
						// 비어있지 않다면..
						else {
							Fish first = targetFishes.peek();
							if(first.dist < front.depth+1) {
								break findFisht;
							}else {
								targetFishes.offer(new Fish(nr, nc, map[nr][nc], front.depth + 1));
							}
						}
					}
				}
			}
		}
		// 먹을게 없다. 
		if(targetFishes.isEmpty()) {
			return;
		}
		// 맨 처음 녀석을 먹자. 
		else {
			Fish food = targetFishes.poll();
			front.eat();
			map[food.row][food.col] = 0;
			
			sharkMoveCnt+= food.dist;
			
			bfs(new Shark(food.row, food.col, front.size, 0, front.eatCnt));
			
		}

	}

	static boolean isIn(int row, int col) {
		return 0 <= row && row < n && 0 <= col && col < n;
	}

	static class Shark {
		int row, col;
		int size; // 크기
		int depth; // bfs의 탐색 너비
		int eatCnt; // 먹은 마리수

		public Shark(int row, int col, int size, int depth, int eatCnt) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
			this.depth = depth;
			this.eatCnt = eatCnt;
		}

		public void eat() {
			eatCnt++;
			if (eatCnt == size) {
				size++;
				eatCnt = 0;
			}
		}
	}

	static class Fish implements Comparable<Fish> {
		int row, col;
		int size; // 크기
		int dist;

		public Fish(int row, int col, int size, int dist) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dist == o.dist) {
				if (this.row == o.row) {
					return Integer.compare(this.col, o.col);
				} else {
					return Integer.compare(this.row, o.row);
				}

			} else {
				return Integer.compare(this.dist, o.dist);
			}
		}
	}
}
