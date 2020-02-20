package swea.d5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1247 {
	private static int T, N;
	static int[] Crc, Hrc;
	private static int[][] points = null;
	static int[] visit = new int[N];
	static int minResult = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 T = Integer.parseInt(br.readLine()); 
		 for (int testCase = 1; testCase <= T; testCase++) {
//			N = Integer.parseInt(br.readLine());
//			crc[0] = 
//			cc = sc.nextInt();
//			hr = sc.nextInt();
//			hc = sc.nextInt();
//			points = new int[N][2];
//			for (int i = 0; i < N; i++) {
//				points[i][0] = sc.nextInt();
//				points[i][1] = sc.nextInt();
//			}
////			points[N][0] = home[0];
////			points[N][1] = home[1];
//			
//			DFS(company, 0, 0);
////            findPath(new boolean[N], company, 0);
//			System.out.println("#" + testCase + " " + minResult);
//		}
//	}
//
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
//
//	private static void findPath(boolean[] nodes, int[] prePoint, int weight) {
//		boolean isFin = true;
//		for (boolean node : nodes) {
//			if (!node) {
//				isFin = false;
//				break;
//			}
//		}
//
//		if (isFin) {
//			return weight + getDistance(prePoint, home);
//		}
//
//		int minResult = Integer.MAX_VALUE;
//		for (int i = 0; i < nodes.length; i++) {
//			if (!nodes[i]) {
//				nodes[i] = true;
//				int pathResult = findPath(nodes, points[i], weight + getDistance(prePoint, points[i]));
//				minResult = Math.min(minResult, pathResult);
//				nodes[i] = false;
//			}
//		}
//
//		return minResult;
//	}
//
//	private static int getDistance(int[] pointA, int[] pointB) {
//		return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
//	}
//
//}
		 }
	}
}