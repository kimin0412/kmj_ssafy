package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1251_하나로 {
	static int N;
	static double E;
	static Point[] points;
	static int[][] map;
	static boolean[] visit;
	static double minHap;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1251_하나로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			points = new Point[N];
			map = new int[N][N];
			visit = new boolean[N];
			int[] tmpX = new int[N];
			int[] tmpY = new int[N];

			for (int i = 0; i < N; i++) {
				tmpX[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < N; i++) {
				tmpY[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < N; i++) {
				points[i] = new Point(i, tmpX[i], tmpY[i]);
			}

			E = Double.parseDouble(br.readLine());
			System.out.println(E);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = getDis(points[i], points[j]);
				}
			}

			for (int[] m : map) {
				System.out.println(Arrays.toString(m));
			}

			for (int i = 0; i < N; i++) {
				minHap = Integer.MAX_VALUE;
				
				dfs(i, 0, 0);
			}
			
			System.out.println("#" + tc + " ");
		}
	}

	

	private static void dfs(int cur, int hap, int cnt) {
		if (cnt == N) {
			minHap = Math.min(minHap, hap);
		}
		
		LinkedList<Point> q = new LinkedList<>();
		q.offer(points[cur]);
		visit[cur] = true;
		
		while(!q.isEmpty()) {
			Point tmp = q.poll();
			
			
			
		}
		

	}
	
	private static int getDis(Point p1, Point p2) {
		return (int) Math.sqrt(Math.pow((p1.x - p2.x), 2) + Math.pow((p1.y - p2.y), 2));
	}
	
	static public class Point {
		int pos;
		int x;
		int y;

		public Point(int pos, int x, int y) {
			super();
			this.pos = pos;
			this.x = x;
			this.y = y;
		}
	}
}
