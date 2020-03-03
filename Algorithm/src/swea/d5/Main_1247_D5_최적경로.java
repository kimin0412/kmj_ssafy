package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1247_D5_최적경로 {
	private static int T, N;
	static int[] Crc, Hrc;
	private static int[][] points = null;
	static int[] visit = new int[N];
	static int minResult = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d5/1247_최적경로.txt"));
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 T = Integer.parseInt(br.readLine()); 
		 for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Crc[0] = Integer.parseInt(st.nextToken()); 
			Crc[1] = Integer.parseInt(st.nextToken()); 
			Hrc[0] = Integer.parseInt(st.nextToken()); 
			Hrc[1] = Integer.parseInt(st.nextToken()); 
			points = new int[N][2];
			for (int i = 0; i < N; i++) {
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
//			DFS(Crc, 0, 0);
			System.out.println("#" + testCase + " " + minResult);
		}
	}

//	private static void DFS(int[] p, int hap, int n) {
//		if (visit[i] == 0) {
//			if (n == N + 1) {
//				if (p[0] == home[0] && p[1] == home[1]) {
//					minResult = Math.min(minResult, hap);
//				}
//				return;
//			}
//
//			else {
//
//				for (int i = 0; i < N + 1; i++) {
//					DFS(points[i], hap, n + 1);
//
//				}
//
//			}
//
//		}
//	}

//	private
//
//	private static int getDistance(int[] pointA, int[] pointB) {
//		return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
//	}

}
//		 }
//	}
//}