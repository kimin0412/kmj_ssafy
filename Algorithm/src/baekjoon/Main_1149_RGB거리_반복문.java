package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리_반복문 {
	static int[][] map, dist;
	static int N;
	/*
	 * https://st-lab.tistory.com/128
	 * 반복문 (Bottom-Up) 방식
	 */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][3];
		dist = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.
		for (int i = 1; i < N; i++) {
			map[i][0] += Math.min(map[i - 1][1], map[i - 1][2]);
			map[i][1] += Math.min(map[i - 1][0], map[i - 1][2]);
			map[i][2] += Math.min(map[i - 1][0], map[i - 1][1]);
		}

		System.out.println(Math.min(Math.min(map[N - 1][0], map[N - 1][1]), map[N - 1][2]));
	}
}
