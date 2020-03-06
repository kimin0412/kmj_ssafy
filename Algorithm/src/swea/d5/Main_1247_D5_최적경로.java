package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1247_D5_최적경로 {
	static int N;
	static int[] Crc, Hrc;
	private static int[][] points = null;
	static boolean[] visit;
	static int minResult = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d5/1247_최적경로.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Hrc = new int[2];
			Crc = new int[2];
			Crc[0] = Integer.parseInt(st.nextToken());
			Crc[1] = Integer.parseInt(st.nextToken());
			Hrc[0] = Integer.parseInt(st.nextToken());
			Hrc[1] = Integer.parseInt(st.nextToken());
			points = new int[N][2];
			visit = new boolean[N];
			for (int i = 0; i < N; i++) {
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			minResult = Integer.MAX_VALUE;
			DFS(Hrc, 0, 0);
			System.out.println("#" + testCase + " " + minResult);
		}
	}

	private static int getDistance(int[] pointA, int[] pointB) {
		return Math.abs(pointA[0] - pointB[0]) + Math.abs(pointA[1] - pointB[1]);
	}

	private static void DFS(int[] Src, int dist, int cnt) {
		if (dist > minResult)
			return;
		if (cnt == N) {
			dist += getDistance(Crc, Src);
			minResult = Math.min(minResult, dist);
		}
		for (int i = 0; i < N; i++) {
			if (!visit[i]) {
				visit[i] = true;
				int cur = getDistance(Src, points[i]);
				DFS(points[i], dist + cur, cnt + 1);
				visit[i] = false;
			}
		}
	}
}
