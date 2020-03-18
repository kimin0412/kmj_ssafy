package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5604_구간합 {
	static int[] count;
	static long A, B;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/5604_구간합.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			count = new int[10];
			int sumA = 0;
			int sumB = 0;

			int n = 0;
			while (A >= 10 && B >= 10) {
				while (A % 10 != 0) {
					count[(int) (A % 10)]++;
					System.out.println(A % 10);
					A++;
				}
				while (B % 10 != 9) {
					count[(int) (B % 10)]++;
					System.out.println(B % 10);

					B--;
				}
				System.out.println(Arrays.toString(count));

				A/=10;
				B/=10;
				for (int i = 0; i < 10; i++) {
					count[i] += (B-A+1)*Math.pow(10, n);
				}
				n++;
//				cal(A, B);
			}
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum+= count[i]*i;
			}
			
			System.out.println("A, B : " + A + " " + B);
			System.out.println(Arrays.toString(count));
			System.out.println("#" + tc + " " + sum);
			
		}
	}

	private static void cal(int a, int b) {
		while (b > 0) {
			count[b % 10]++;
			b /= 10;

		}
	}
}
