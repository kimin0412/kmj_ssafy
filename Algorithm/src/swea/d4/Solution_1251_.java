package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1251_ {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1251_.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine().trim(), " ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			double A = 0;
			for (int i = 0 + K - 1; i < N; i++) {
//			for (int i = N - K; i < N; i++) {
				System.out.println(arr[i]);
				A = (A + arr[i]) / 2;
			}


			System.out.format("#%d %f\n", tc, A);
		}
	}

}
