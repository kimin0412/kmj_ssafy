package swea.swtest;

//// 보류 ////
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5644_모의SW_무선충전 {
	static int ans;
	static int chargeA;
	static int chargeB;
	static int[] dirR = { 0, -1, 0, 1, 0 };
	static int[] dirC = { 0, 0, 1, 0, -1 };
	static int[][][] map;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/5644_모의SW_무선충전.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken()); // 이동시간
			int A = Integer.parseInt(st.nextToken()); // BC 개수
			int[] moveA = new int[M + 1];
			int[] moveB = new int[M + 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(moveA));

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
//			System.out.println(Arrays.toString(moveB));

			map = new int[A][11][11];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());

				distance(i, Y, X, C, P);
			}
			for (int m = 0; m < A; m++) {
				for (int mm = 1; mm < 11; mm++) {
					for (int mmm = 1; mmm < 11; mmm++) {
						System.out.print(map[m][mm][mmm] + " ");
					}
					System.out.println();
				}
				System.out.println();
			}
			System.out.println();

			
			
			
			int Ar = 1, Ac = 1;
			int Br = 10, Bc = 10;
//			boolean[][] check = new boolean[A][2];

//			int hapA = 0;
//			int hapB = 0;
//			int[][] ABmap = new int[11][11];
//			ABmap[1][1]++;
//			ABmap[10][10]++;
//			for (int m = 0; m < A; m++) {
//				if (map[m][Ar][Ac] != 0) {
//					check[m][0] = true;
//				} else {
//					check[m][0] = false;
//				}
//				if (map[m][Br][Bc] != 0) {
//					check[m][1] = true;
//				} else {
//					check[m][1] = false;
//				}
//				}
			int check1 = 0;
			boolean[][] check = new boolean[A][2];
			int sum = 0;
			
			int e = 0;
			for (int i = 0; i <= M; i++) {
				Ar += dirR[moveA[i]];
				Ac += dirC[moveA[i]];
				Br += dirR[moveB[i]];
				Bc += dirC[moveB[i]];
				int maxA = 0;
				int maxB = 0;
				int aa = 0, bb=0;
				for (int m = 0; m < A; m++) {
					e = 0;
					if(map[m][Ar][Ac] != 0) {
						check[m][0] = true;
						aa++;
						e++;
					}
					if(map[m][Br][Bc] != 0) {
						check[m][1] = true;
						bb++;
						e++;
					}
//					System.out.println(e);
					
					if(e!=0) {
						maxA = Integer.max(maxA, map[m][Ar][Ac]/e);
						maxB = Integer.max(maxB, map[m][Br][Bc]/e);
					}
					System.out.println(i + " " + maxA + " " + maxB);
					
				}
				
				
//				System.out.println(maxA + " " + maxB);
//				System.out.println("aa, bb : " + aa + " " + bb);
				sum+= maxA+maxB;
//				
//				
//				int[][] ccheck = new int[A][];
//				int maxA = 0;
//				int maxB = 0;
//				int hapMap = 0;
//				System.out.println(i + " 위치 : " + Ar + ", " + Ac + "  " + Br + ", " + Bc);
//				for (int m = 0; m < A; m++) {
//					if (map[m][Ar][Ac] != 0 && map[m][Br][Bc] == 0) {
//						check1 = 1;
//						hapMap = map[m][Ar][Ac];
//					} else if (map[m][Br][Bc] != 0 && map[m][Ar][Ac] == 0) {
//						check1 = 1;
//						hapMap = map[m][Br][Bc];
////					check[i][1] = true;
//					} else if (map[m][Ar][Ac] != 0 && map[m][Br][Bc] != 0) {
//						check1 = 2;
//						hapMap = map[m][Ar][Ac] + map[m][Br][Bc];
//						;
////					check[i][1] = false;
//					} else {
//						check1 = 0;
//					}
//					if (Br == 5 && Bc == 4) {
//						System.out.println("m, map값 : " + m + " " + map[m][Br][Bc]);
//					}
//					System.out.println("ch : " + check1);
//				if(check1 == 2) {
//					
//				}
//					if (check1 != 0) {
//						System.out.println("maxA : " + maxA);
//						maxA = Integer.max(maxA, map[m][Ar][Ac] / check1);
//					}
//					if (check1 != 0) {
//						System.out.println(map[m][Ar][Ac] + "  " + map[m][Br][Bc]);
//						System.out.println("maxB : " + maxB);
//						System.out.println("값 : " + map[m][Br][Bc]/check1);
//						System.out.println(hapMap + " " +check1);
//						maxB = Integer.max(maxB, (hapMap / check1));
//						System.out.println("ch : " + map[m][Br][Bc] + " " + check1 + " " + map[m][Br][Bc] / check1);
//						maxB = Integer.max(maxB, map[m][Br][Bc] / check1);
//					}
//				}
//				System.out.println("@@ " + maxA + " " + maxB);
//				System.out.println();

//				hapA += maxA;
//				hapB += maxB;
//				ABmap[Ar][Ac]--;
//				ABmap[Br][Bc]--;

//				ABmap[Ar][Ac]++;
//				ABmap[Br][Bc]++;
//				for (int m = 0; m < A; m++) {
////				}
//				if()
//				max = Integer.max(max, map[Ar][Ac])

			}

			System.out.println("#" + tc + " " + sum );
		}

	}

	private static void distance(int m, int y, int x, int c, int p) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { y, x, 0 });
		map[m][y][x] += p;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			if (tmp[2] == c)
				break;
			for (int d = 1; d < 5; d++) {
				int nr = tmp[0] + dirR[d];
				int nc = tmp[1] + dirC[d];
				int ii = tmp[2] + 1;
				if (-1 < nr && nr < 11 && -1 < nc && nc < 11) {
					map[m][nr][nc] = p;
					q.offer(new int[] { nr, nc, ii });
				}
			}
		}
	}
}
