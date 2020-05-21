package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	static int[] oper;
	static long[] numbers;
	static int N;
	static long maxSum;
	static long minSum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		numbers = new long[N];
		oper = new int[4];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		maxSum = Integer.MIN_VALUE;
		minSum = Integer.MAX_VALUE;
		operate(numbers[0], 1);
		System.out.println(maxSum);
		System.out.println(minSum);
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
