package algo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mian_0417_별자리 {
	static int[][] map;
	static boolean[][] visit;
	static int[] dR = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dC = { 0, 0, -1, 1, -1, 1, 1, -1 };
	
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/algo/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			map = new int[10][10];
			visit = new boolean[10][10];
			StringTokenizer st;
			for (int i = 0; i < 10; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 10; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt = 0;
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if(!visit[i][j] && map[i][j] != 0) {
						Queue<int[]> q = new LinkedList<>();
						q.offer(new int[] {i, j, ++cnt});
						
						while(!q.isEmpty()) {
							int[] tmp = q.poll();
							int r = tmp[0];
							int c = tmp[1];
							for (int d = 0; d < 8; d++) {
								int nr = r + dR[d];
								int nc = c + dC[d];
								
								if(-1<nr && nr<10 && -1<nc && nc<10
										&& !visit[nr][nc] && map[nr][nc] ==1) {
									q.offer(new int[] {nr, nc, tmp[2]});
									visit[nr][nc] = true;
								}
							}
						}
					}
				}
			}
			System.out.println("#" + tc + " " + cnt);
			
		}
	}
}
