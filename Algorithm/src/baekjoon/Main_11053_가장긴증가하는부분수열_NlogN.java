package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * DP O[N^2]
 */
public class Main_11053_가장긴증가하는부분수열_NlogN {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int[] LIS = new int[N]; // 자기자신이 맨 뒤로 올때 최장 증가수열의 길이를 저장할 배열

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		LIS[0] = a[0];
		int j = 1;
		for (int i = 1; i < N; i++) {
			if (LIS[0] > a[i]) {
				LIS[0] = a[i];
			} else if (LIS[j - 1] < a[i]) {
				LIS[j] = a[i];
				j++;
			} else {
				int idx = Arrays.binarySearch(LIS, 0, j, a[i]);
				if (idx < 0) {
					idx = (-idx) - 1;
				}
				LIS[idx] = a[i];
			}
		}
		System.out.println(j);

	}
}
