package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1475_방번호 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s = br.readLine();
		int size = s.length();
		int N = Integer.parseInt(s);

		int[] count = new int[10];

		for (int i = 0; i < size; i++) {
			int tmp = N % 10;
			count[tmp]++;
			N /= 10;
		}
		int hap = count[6] + count[9];
		if (hap % 2 == 0) {
			count[6] = hap / 2;
			count[9] = hap / 2;
		} else {
			count[6] = hap / 2 + 1;
			count[9] = hap / 2;
		}

		int max = 0;
		for (int i = 0; i < 10; i++) {
			max = Math.max(max, count[i]);
		}
		System.out.println(max);
	}
}