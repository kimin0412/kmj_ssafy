package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
	// 사방탐색
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int n, m; // 1 ≤ N, M ≤ 10
	static int[][] map, graph;
	static int islandIdx; // 섬의 번호
	static int INF = 987654321; // 그래프에서 사용할 초기화 값

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/17472_다리만들기2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}
//		for (int[] m : map) {
//			System.out.println(Arrays.toString(m));
//		}
		islandIdx = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 땅을 발견하면 거기를 기점으로 BFS 탐색 --> 연결된 지점들을 표시
				if (map[i][j] == 1) {
					bfs(i, j); // 한번의 BFS --> 섬 하나가 발견되었다!
					islandIdx++;
				}
			}
		}
		//
		System.out.println("섬 확인");
		for (int[] row : map) {
			System.out.println(Arrays.toString(row));
			
		}

		// 그래프 초기화 하기..
		graph = new int[islandIdx][islandIdx];
		// 각 섬간의 최단 거리로 그래프를 구성할 계획 - 그래프의 값을 최대값으로 초기화
		for (int r = 2; r < islandIdx; r++) {
			Arrays.fill(graph[r], INF);
		}

		// 각 섬별로 거리(간선 가중치) 찾아보기
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < m; c++) {
				if (map[r][c] > 1) {
					makeGraph(r, c);
				}
			}
		}
		
		// 그래프 확인
		for (int[] g : graph) {
			System.out.println(Arrays.toString(g));
		}
		
		// MST 구하기 및 출력
		System.out.println(prim());

	}
	
	static int prim() {
		// 모든 vertex가 처음에 여기 들어있다가 탈출해야한다.
		PriorityQueue<Vertex> notMstGroup = new PriorityQueue<>();
		// 연결 비용과 관련된 섬들의 정보를 관리할 배열
		Vertex[] vertexes = new Vertex[islandIdx];
		for (int i = 2; i < islandIdx; i++) {
			if(i == 2) {
				vertexes[i] = new Vertex(i, 0);
			}else {
				vertexes[i] = new Vertex(i, INF);
			}
			notMstGroup.offer(vertexes[i]);
		}
		
		int sum = 0;
		
		while(!notMstGroup.isEmpty()) {
			Vertex front = notMstGroup.poll();
			if(front.cost == INF) {
				return -1;
			}
			sum+=front.cost;
			
			for (int i = 2; i < islandIdx; i++) {
				Vertex child = vertexes[i];
				// 아직 MST의 요소가 아닌 녀석이라면..
				if(notMstGroup.contains(child)) {
					// 그래프에서 비용 조회, 현재 가지고 있는 것보다 작으면 업데이트
					if(child.cost > graph[front.idx][i]) {
						child.cost = graph[front.idx][i]; // 비용 갱신
						notMstGroup.remove(child);
						notMstGroup.offer(child); // 순서가 다시 바뀌었을 거임
					}
				}
			}
		}
		
		return sum;
	}
	
	static class Vertex implements Comparable<Vertex>{
		int idx, cost;

		public Vertex(int idx, int cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public int compareTo(Vertex o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	private static void makeGraph(int row, int col) {
		// 내땅
		int base = map[row][col];
		for (int d = 0; d < 4; d++) {

			for (int l = 1;; l++) {
				int nr = row + dx[d] * l; // 쭉 가라
				int nc = col + dy[d] * l; // 쭉 가라

				if (isIn(nr, nc)) {
					// 바다면 쭉 간다...
					if (map[nr][nc] == 0) {
						continue;
					}
					// 내륙 - 그만..
					else if (map[nr][nc] == base) {
						break;
					}
					// 아니면 다른 섬 --> 거리는 2칸이상 떨어져 있어야 한다.
					else {
						// 드디어 다리를 만들 수 있는 곳에 왔음...
						if (l > 2) {
							// 무향 그래프 --> 양방향 업데이트
							graph[map[nr][nc]][base] = Math.min(graph[base][map[nr][nc]], l - 1);
						}
						break;
					}
				}
				// 영역 안에 없으면 그만..
				else {
					break;
				}

			}
		}

	}

	private static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(row, col));
		// 방문 표시 - map 자체에다가 islandIdx로 표시한다.
		map[row][col] = islandIdx;

		while (!q.isEmpty()) {
			Point front = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = front.row + dx[d];
				int nc = front.col + dy[d];

				// map[nr][nc]==1 --> 아직 방문하지 않은 땅이라면...
				if (isIn(nr, nc) && map[nr][nc] == 1) {
					map[nr][nc] = islandIdx;
					q.offer(new Point(nr, nc));
				}
			}
		}
	}

	static boolean isIn(int row, int col) {
		return 0 <= row && row < n && 0 <= col && col < m;
	}

	static class Point {
		int row, col;

		public Point(int row, int col) {
			super();
			this.row = row;
			this.col = col;
		}

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + "]";
		}
	}
}
