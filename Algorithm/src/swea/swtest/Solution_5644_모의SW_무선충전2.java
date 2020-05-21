package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5644_모의SW_무선충전2 {
	static class BC{
		int x;	// x좌표 
		int y;	// y좌표
		int c;	// coverage
		int p;	// performance
		int idx;	// BC의 index
		
		public BC(int x, int y, int c, int p, int idx) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.p = p;
			this.idx = idx;
		}
		
		@Override
		public String toString() {
			return "BC [x=" + x + ", y=" + y + ", c=" + c + ", p=" + p + ", idx=" + idx + "]";
		}
	}
	
	static int max;	// 최대 충전량 
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

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}

			map = new int[A][11][11];
			int[][] check = new int[A][3];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				check[i][0] = P;
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

			int Ar = 1, Ac = 1; // A 출발지점
			int Br = 10, Bc = 10; // B 출발지점
			int check1 = 0;

			int sum = 0;

			int e = 0;
			for (int i = 0; i <= M; i++) {
				System.out.println("@@" + (i + 1) + "번째 이동 ");
//				System.out.println("A 위치 : " + Ar + " " + Ac );
//				System.out.println("B 위치 : " + Br + " " + Bc );
				
				Ar += dirR[moveA[i]];
				Ac += dirC[moveA[i]];
				Br += dirR[moveB[i]];
				Bc += dirC[moveB[i]];
//				System.out.println("A 위치 : " + Ar + " " + Ac );
//				System.out.println("B 위치 : " + Br + " " + Bc );
				int maxA = 0;
				int maxB = 0;
				int aa = 0, bb = 0;
				for (int m = 0; m < A; m++) {
					e = 0;
					if (map[m][Ar][Ac] != 0) {
						check[m][1] = 1; // A가 그 안에 있는지
//						aa++;
//						e++;
					}
					if (map[m][Br][Bc] != 0) {
						check[m][2] = 1; // B가 그 안에 있는지
//						bb++;
//						e++;
					}
				}

				int maxhap = 0;
				for (int m = 0; m < A; m++) {
					System.out.println("check[m][1] : " + check[m][1] + " ");
					System.out.println("check[m][2] : " + check[m][2] + " ");
					int hap = 0;
					if (check[m][1] == 1)
						hap += check[m][0];
					for (int mm = 0; mm < A; mm++) {
//						maxhap = 0;
						if (m == mm && check[mm][1] == 1 && check[mm][2] == 1) { // 둘다 같은곳에 속해있으면
							hap = (hap + check[mm][0]) / 2;
						} else if (check[mm][2] == 1) {
							hap += check[mm][0];
						}
						System.out.println("mm, check : " + mm + " " + check[mm][2]);
						maxhap = Integer.max(maxhap, hap);
						System.out.println(i + " " + maxhap);

					}
				}
				sum += maxhap;
//				sum += maxA + maxB;
				System.out.println();
			}
			System.out.println("#" + tc + " " + sum);
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
