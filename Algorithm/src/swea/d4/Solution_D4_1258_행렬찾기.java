package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

import swea.d4.Solution_1861_정사각형방.Ans;

public class Solution_D4_1258_행렬찾기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1258_행렬찾기.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine().trim());

		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(in.readLine().trim());
			int[][] map = new int[N + 2][N + 2];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for (int j = 1; j <= N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] arr = new int[N * N][2];
			LinkedList<int[]> queue = new LinkedList<>();

			int x = 0;
			int y = 0;
			int cnt = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] != 0) {
						x = 0;
						y = 0;
						for (int k = i; k <= N; k++) {
							if (map[k][j] == 0)
								break;
							else {
								x++;
							}
						}
						for (int k = j; k <= N; k++) {
							if (map[i][k] == 0)
								break;
							else {
								y++;
							}
						}
						queue.add(new int[] { x, y, x * y });
						cnt++;
						for (int k = i; k <= x+i; k++) {
							for (int k2 = j; k2 <= y+j; k2++) {
								map[k][k2] = 0;
							}
						}
					}
				}

			}
			
			queue.sort(new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[2] > o2[2])
						return 1;
					else if (o1[2] == o2[2]) {
						if(o1[0] > o2[0])
							return 1;
						else if(o1[0] == o2[0])
							return 0;
						else return -1;
					} else
						return -1;
				}
				
			});
			
			System.out.print("#" + tc + " " + cnt + " ");
			for (int[] q : queue) {
				System.out.print(q[0]+" "+q[1] + " ");
				 
			}System.out.println();

		}
	}

}
