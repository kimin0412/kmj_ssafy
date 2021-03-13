package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리_재귀 {
	static int[][] map, dist;
	static int N;
	/*
	 * https://st-lab.tistory.com/128
	 * 재귀 (Top-Down) 방식
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

		dist[0][0] = map[0][0];
		dist[0][1] = map[0][1];
		dist[0][2] = map[0][2];

		System.out.println(
				Math.min(find(N - 1, 0), Math.min(find(N - 1, 1), find(N - 1, 2))));
	}

	static int find(int idx, int RGB) {
		// 만약 탐색하지 않은 배열이라면
		if (dist[idx][RGB] == 0) {
			// RGB의 색에 따라 이전 집의 서로 다른 색을 재귀호출하여 최솟값과 현재 집의 비용을 더해서 dist에 저장한다
			if (RGB == 0) {
				dist[idx][0] = Math.min(find(idx - 1, 1), find(idx - 1, 2)) + map[idx][0];
			} else if (RGB == 1) {
				dist[idx][1] = Math.min(find(idx - 1, 0), find(idx - 1, 2)) + map[idx][1];
			} else {
				dist[idx][2] = Math.min(find(idx - 1, 0), find(idx - 1, 1)) + map[idx][2];
			}
		}
		return dist[idx][RGB];

	}
}
