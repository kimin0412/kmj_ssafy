package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1808_지희의고장난계산기_memo {
	static boolean[] btn;
	static int X, cnt, min;
	static int[] memo; // 제곱근 까지만 사용
	static int size;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/1808_지희의고장난계산기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			StringTokenizer st;
			btn = new boolean[10];
			st = new StringTokenizer(br.readLine().trim(), " ");
			int num;
			for (int i = 0; i < 10; i++) {
				num = Integer.parseInt(st.nextToken());
				if (num == 1) {
					btn[i] = true;
				}
			}
			X = Integer.parseInt(br.readLine().trim());
			size = (int) Math.sqrt(X);
			memo = new int[size];
			find(X, 0);
			min = min == Integer.MAX_VALUE ? -1 : min;
			System.out.println("#" + tc + " " + min);

		}
	}

	private static int find(int x, int cnt) {
		if (x < size && memo[x] != 0) { // memo크기를 x로 잡지 않아서 size보다 작아야함
			return memo[x];
		}
		if (isMake(x + "")) {
			int count = len(x) + 1;
			if (cnt == 0) {
				min = count;
			}
			if (x < size) {
				memo[x] = count;
			}
			return count;
		}
		int result = -1;
		for (int i = 2, end = (int) Math.sqrt(X); i < end; i++) {
			if (x % i == 0 && isMake(i + "")) {
				int len1 = len(i) + 1;
				int len2 = find(x / i, cnt + 1);
				if (len2 > -1) {
					result = len1 + len2;
					if (result < min && x == X) {
						min = result;
					}
				}
			}
		}
		if (x < size) {
			memo[x] = result;
		}
		return result;
	}

	private static int len(int x) {
		return (int) Math.log10(x) + 1;
	}

	private static boolean isMake(String x) {
		for (char c : x.toCharArray()) {
			if (!btn[c - '0']) {
				return false;
			}
		}
		return true;
	}
}
