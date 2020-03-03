package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_7699_수지의수지맞는여행 {
	static int[][] map;
	static boolean[][] visit;
//	static boolean[] selected;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R, C, maxCnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/7699_수지의수지맞는여행.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[R + 2][C + 2];
			visit = new boolean[R + 2][C + 2];
			for (int i = 1; i <= R; i++) {
				String line = br.readLine();
				for (int j = 1; j <= C; j++) {
					map[i][j] = line.charAt(j - 1) - 64;
				}
			}

//			selected = new boolean[27];
			maxCnt = 0;
			visit[1][1] = true;
			bfs(1, 1);
//			dfs(1, 1);

			System.out.println("#" + tc + " " + maxCnt);
			
			for (int[] m : map) {
				System.out.println(Arrays.toString(m));
			}
		}

	}
	
	public static class NOW{
		int r, c, cnt;
		boolean[] selected = new boolean[14];
		public NOW(int r, int c, int cnt, boolean[] selected) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.selected = selected;
		}
	}
	
	
	
	private static void bfs(int r, int c) {
		LinkedList<NOW> queue = new LinkedList<>();
		boolean[] selected = new boolean[14];
		selected[map[r][c]] = true;
		queue.add(new NOW(r, c, 1, selected));
		
		while(!queue.isEmpty()) {
			NOW tmp = queue.poll();
			top:
			for (int i = 0; i < 4; i++) {
				int nr = tmp.r + dir[i][0];
				int nc = tmp.c + dir[i][1];
				System.out.println(nr + " " + nc);
				selected = tmp.selected;
				if(map[nr][nc]!=0 && !visit[nr][nc] && !selected[map[nr][nc]]) {
					selected[map[nr][nc]] = true;
					System.out.println(Arrays.toString(selected));
					visit[nr][nc] = true;
					queue.add(new NOW(r, c, tmp.cnt+1, selected));
//					selected[map[nr][nc]] = false;
					
//					visit[nr][nc] = true;
					
				}
				else {
					if(maxCnt<tmp.cnt) {
						maxCnt = Math.max(maxCnt, tmp.cnt);
					}
				}
			}
		}
		
		
		
		
//		for (int i = r; i <= R; i++) {
//			for (int j = c; j <= C; j++) {
//				if(map[i][j] != 0) {
//					
//				}
//			}
//		}
//		
		
	}
}
