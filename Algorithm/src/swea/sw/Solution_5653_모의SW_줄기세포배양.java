//package swea.sw;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.StringTokenizer;
//
//public class Solution_5653_모의SW_줄기세포배양 {
////	static Cell[][] map = new Cell[100][100];
//	static int[][] map = new int[100][100];
//	static int[][] time = new int[100][100];
//	static int MID = 50;
//	static int N;
//	static int M;
//	static int K;
////	static int time;
//	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
//
////	public static class Cell {
//////		int rr;
//////		int cc;
////		public int health;
////		public int stime;
////		public int status;
////
////		public Cell(int health, int stime, int status) {
////			super();
//////			this.rr = rr;
//////			this.cc = cc;
////			this.health = health;
////			this.stime = stime;
////			this.status = status;
////		}
////
////		public void setHealth(int health) {
////			this.health = health;
////		}
////
////		public void setStime(int stime) {
////			this.stime = stime;
////		}
////
////		public void setStatus(int status) {
////			this.status = status;
////		}
////	}
//
//	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/swea/sw/5653_모의SW_줄기세포배양.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//
//		int T = Integer.parseInt(br.readLine());
//		for (int tc = 1; tc <= T; tc++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			N = Integer.parseInt(st.nextToken()); // 세로
//			M = Integer.parseInt(st.nextToken()); // 가로
//			K = Integer.parseInt(st.nextToken()); // 시간
//
//			for (int i = 0; i < N; i++) {
//				st = new StringTokenizer(br.readLine(), " ");
//				for (int j = 0; j < M; j++) {
//					map[MID + i][MID + j].setHealth(Integer.parseInt(st.nextToken()));
//					map[MID + i][MID + j].setStatus(-map[MID + i][MID + j].health);
//					map[MID + i][MID + j].setStime(0);
//				}
//			}
//
//			for (int k = 1; k <= K; k++) {
//				for (int i = 0; i < k * N; i++) {
//					for (int j = 0; j < k * M; j++) {
//						int nr = MID + i;
//						int nc = MID + j;
//						if (map[nr][nc].health != 0 && !(map[nr][nc].health <= map[nr][nc].status)) {
//							if (map[nr][nc].status == 0) {
//								spread(nr, nc);
//							} else if (map[nr][nc].status < 0) {
//								continue;
//							} else if (map[nr][nc].status > 0) {
//								continue;
//							}
//							map[nr][nc].setStatus(map[nr][nc].status + 1);
//						}
//					}
//				}
//			}
//
//			for (int i = 0; i < 500; i++) {
//				for (int j = 0; j < 500; j++) {
//					System.out.print(map[i][j].health + " ");
//				}
//				System.out.println();
//			}
//
//		}
//	}
//
//	private static void spread(int nr, int nc) {
//		for (int d = 0; d < 4; d++) {
//			int nextr = nr + dir[d][0];
//			int nextc = nc + dir[d][1];
//			if (map[nextr][nextc].health < map[nr][nc].health) {
//				Cell tmp = new Cell(map[nr][nc].health, 0, -map[nr][nc].health);
//				map[nextr][nextc] = tmp;
//			}
//
//		}
//
//	}
//
////	private static void bfs(Cell c, int time) {
////		LinkedList<Cell> q = new LinkedList<>();
////		q.add(c);
////		
////		while (!q.isEmpty()) {
////			
////			Cell tmp = q.poll();
////			for (int i = 0; i < 4; i++) {
////				int nr = tmp[0] + dir[i][0];
////				int nc = tmp[1] + dir[i][1];
////				
////				if(map[nr][nc] )
////					
////			}
////		}
////		
////	}
//
////	private static void bfs(Cell c, int time) {
////		LinkedList<Cell> q = new LinkedList<>();
////		q.add(c);
////
////		while (!q.isEmpty()) {
////			
////			Cell tmp = q.poll();
////			for (int i = 0; i < 4; i++) {
////				int nr = tmp[0] + dir[i][0];
////				int nc = tmp[1] + dir[i][1];
////				
////				if(map[nr][nc] )
////
////			}
////		}
////
////	}
//
//}
