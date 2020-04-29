package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DP 
 * O[N^2]
 */
public class Main_11053_가장긴증가하는부분수열 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		int[] LIS = new int[N]; // 자기자신이 맨 뒤로 올때 최장 증가수열의 길이를 저장할 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝

		for (int i = 0; i < LIS.length; i++) {
			LIS[i] = 1; // 자기자신은 무조건 포함이므로 최소 길이는 1부터 시작한다. 
			for (int j = 0; j < i; j++) { // 0번째 인덱스(맨처음)부터 자기자신까지 검사 
				if (a[j] < a[i] && LIS[i] < LIS[j] + 1) { // a[j] < a[i] : 증가수열이 맞고, LIS[i] < LIS[j] + 1 : 1증가했을때 더 큰거
					LIS[i] = LIS[j] + 1;
				}
			}
		}

//		System.out.println(Arrays.toString(LIS));
		int maxLISIndex = 0;
		for (int i = 0; i < LIS.length; i++) {
			if (LIS[maxLISIndex] < LIS[i]) {
				maxLISIndex = i;
			}
		}
		System.out.println(LIS[maxLISIndex]);
	}
}
