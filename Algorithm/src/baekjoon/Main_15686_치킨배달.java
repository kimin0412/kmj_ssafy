package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/15686_치킨배달.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			Queue<int[]> home = new LinkedList<int[]>();
			Queue<int[]> chick = new LinkedList<int[]>();
			int idx1 = 0, idx2 = 0;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						home.add(new int[] { idx1, i, j });
						idx1++;
					}

					if (map[i][j] == 2) {
						chick.add(new int[] { idx2, i, j });
						idx2++;
					}
				}
			}

//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if (map[i][j] == 1) {
//						home[idx1][0] = i;
//						home[idx1][1] = j;
//						idx1++;
//					}
//					if (map[i][j] == 2) {
//						chick[idx2][0] = i;
//						chick[idx2][1] = j;
//						idx2++;
//					}
//				}
//			}
			
			
			

//			LinkedList<int[]> hap = new LinkedList<int[]>();
//			LinkedList<int[]> dis = new LinkedList<int[]>();
//			for (int i = 0; i < chick.size(); i++) {
//				int[] ch = chick.
//				for (int j = 0; j < home.size(); j++) {
//					hap[i] += distance(new int[] { chR, chC }, new int[] { hR, hC });
//					dis[j][i] = distance(new int[] { chR, chC }, new int[] { hR, hC });
//				}
//			}
//			Arrays.sort(hap);
//			System.out.println(Arrays.toString(hap));
//			for (int i = M; i < cnt2; i++) {
//
//			}

			System.out.println("#" + tc + " ");
		}
	}

	private static int distance(int[] th, int[] ch) {
		return Math.abs(th[0] - ch[0]) + Math.abs(th[1] - ch[1]);
	}
}
