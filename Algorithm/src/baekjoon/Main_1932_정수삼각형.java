package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1932_정수삼각형 {
	static int[][] map, dist;
	static int N, max;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dist = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			dist[N - 1][i] = map[N - 1][i];
		}

		System.out.println(find(0, 0));
	}

	static int find(int depth, int idx) {
		if (depth == N - 1)
			return dist[depth][idx];
		if (dist[depth][idx] == 0) {
			dist[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + map[depth][idx];
		}
		return dist[depth][idx];
	}
}