package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008_모의SW_숫자만들기2 {
	static int[] oper;
	static long[] numbers;
	static int N;
	static long maxSum;
	static long minSum;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/4008_모의SW_숫자만들기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			numbers = new long[N];
			oper = new int[4];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			maxSum = Integer.MIN_VALUE;
			minSum = Integer.MAX_VALUE;
			operate(numbers[0], 1);
			System.out.println("#" + tc + " " + Math.abs(maxSum - minSum));
		}
	}

	private static void operate(long sum, int depth) {
		if (depth >= N) {
			maxSum = Math.max(maxSum, sum);
			minSum = Math.min(minSum, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {

			if (oper[i] > 0) {
				oper[i] -= 1;
				switch (i) {
				case 0:
					operate(sum + numbers[depth], depth + 1);
					break;
				case 1:
					operate(sum - numbers[depth], depth + 1);
					break;
				case 2:
					operate(sum * numbers[depth], depth + 1);
					break;
				case 3:
					operate(sum / numbers[depth], depth + 1);
					break;
				}
				oper[i] += 1;
			}
		}
	}
}
