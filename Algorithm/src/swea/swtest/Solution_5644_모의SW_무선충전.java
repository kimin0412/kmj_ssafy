package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5644_모의SW_무선충전 {
	static int ans;
	static int chargeA;
	static int chargeB;
	static int[] dirR = { 0, -1, 0, 1, 0 };
	static int[] dirC = { 0, 0, 1, 0, -1 };
	static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/5644_모의SW_무선충전.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int[] moveA = new int[M];
			int[] moveB = new int[M];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				moveA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < M; i++) {
				moveB[i] = Integer.parseInt(st.nextToken());
			}
			
			map = new int[10][10];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int P = Integer.parseInt(st.nextToken());
				
				distance(X, Y, C, P);
				
			}
			for (int[] m : map) {
				System.out.println(Arrays.toString(m));
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}
	private static void distance(int x, int y, int c, int p) {
		for (int i = 0; i < 2*c+1; i++) {
			for (int j = y-i; j < y; j++) {
				map[x-c+i][j] = 9;
			}
			for (int j = y+1; j < y+1+j; j++) {
				map[x-c+i][j] = 9;
			}
		}
		
	}

}
