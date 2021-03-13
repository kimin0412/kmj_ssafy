package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2740_행렬곱셈 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/baekjoon/Main_20040_사이클게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] B = new int[M][K];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] C = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				for (int k = 0; k < M; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
	}
}
