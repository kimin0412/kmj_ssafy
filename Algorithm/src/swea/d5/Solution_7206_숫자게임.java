package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_7206_숫자게임 {
	static String number;
	static int[] subSet;
	static int maxCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d5/7206_숫자게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			number = br.readLine();
			maxCnt = Integer.MIN_VALUE;

			subset(number, 0);

			System.out.println("#" + testCase + " " + maxCnt);
		}
	}

	private static void makeSet(int C, int cnt, int cur) { // 주사위 던지기4 : 조합
		if (cnt == C) {
//			System.out.println(Arrays.toString(subSet));
			return;
		}
		for (int i = cur; i < number.length()-1; i++) { // 주사위의 눈 1~6
			subSet[cnt] = i;
			makeSet(C, cnt + 1, i + 1);
		}
	}

	private static void subset(String num, int cnt) {
		if (Integer.parseInt(num) < 10) {
			maxCnt = Math.max(maxCnt, cnt);
			return;
		}

		char[] numArr = num.toCharArray();
		for (int c = 1; c < numArr.length; c++) { // 몇번 쪼갤건지
			int idx = 0;
			System.out.println("c : " + c);
			subSet = new int[c];
			makeSet(c, 0, 0);
			System.out.println(Arrays.toString(subSet));
			int[] nums = new int[c];

//			int start = 0;
//			int end = -1;
			for (int ii = 0; ii < subSet.length; ii++) {
//				start = end + 1;
//				end = pos[ii];
				String front = "";
				String back = "";
				for (int f = 0; f <= subSet[ii]; f++) {
					front += numArr[f];
				}
				System.out.println(front);
				for (int b = subSet[ii] + 1; b < numArr.length; b++) {
					back += numArr[b];
				}
				System.out.println(back);
				int next = Integer.parseInt(front) * Integer.parseInt(back);
				subset(Integer.toString(next), cnt + 1);
			}
		}
	}
}
