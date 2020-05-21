package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4008_모의SW_숫자만들기 {
	static int[] count;
	static int[] numbers;
	static boolean[] visit;
	static int N, K;
	static long maxSum;
	static long minSum;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/4008_모의SW_숫자만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			numbers = new int[N];
			count = new int[N - 1];
			visit = new boolean[N - 1];

			st = new StringTokenizer(br.readLine(), " ");
			int idx = 0;
			for (int i = 0; i < 4; i++) {
				int op = Integer.parseInt(st.nextToken());
				for (int j = 0; j < op; j++) {
					count[idx] = i + 1;
					idx++;
				}
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			maxSum = Integer.MIN_VALUE;
			minSum = Integer.MAX_VALUE;
			for (int i = 0; i < N - 1; i++) {
				long sum = numbers[0];
				visit[i] = true;
				operate(sum, count[i], 1);
				visit[i] = false;
			}
//			System.out.println("max, min : " + maxSum + " " + minSum);
			System.out.println("#" + tc + " " + Math.abs(maxSum - minSum));
		}
	}

	private static void operate(long sum, int op, int cnt) {
		long tmpSum = sum;
		switch (op) {
		case 1:
			tmpSum = sum + numbers[cnt];
			break;
		case 2:
			tmpSum = sum - numbers[cnt];
			break;
		case 3:
			tmpSum = sum * numbers[cnt];
			break;
		case 4:
			tmpSum = sum / numbers[cnt];
			break;
		}
		if (cnt == N - 1) {
			maxSum = Math.max(maxSum, tmpSum);
			minSum = Math.min(minSum, tmpSum);
			return;
		}
		for (int i = 0; i < N - 1; i++) {
			if (!visit[i]) {
				visit[i] = true;
				operate(tmpSum, count[i], cnt + 1);
				visit[i] = false;
			}
		}
	}
}
