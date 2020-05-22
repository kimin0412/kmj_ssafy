package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1251_준환이의양팔저울 {
	static int N, count;
	static int[] choo, left, right;
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/준환이의양팔저울.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			choo = new int[N];
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
//			Arrays.sort(arr);
			left = new int[N];
			right = new int[N];
//			Arrays.fill(left, -1);
//			Arrays.fill(right, -1);
			isSelected = new boolean[N];
			count = 0;

			comb1(count);

			System.out.format("#%d %f\n", tc, count);
		}
	}

	private static void comb1(int cnt) {
		if (cnt == N) {
			int leftHap = 0;
			int rightHap = 0;
			for (int i = 0; i <= N; i++) {
				if (left[i] == 0)
					break;
				leftHap += left[i];
			}
			for (int i = 0; i <= N; i++) {
				if (right[i] == 0)
					break;
				rightHap += right[i];
			}

			if (leftHap >= rightHap) {
				count++;
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			isSelected[i] = true;
			left[i] = choo[i];
			comb2(cnt + 1);
			isSelected[i] = false;
		}
	}

	private static void comb2(int cnt) {
		if (cnt == N) {
			System.out.println(Arrays.toString(left));
			System.out.println(Arrays.toString(right));
			int leftHap = 0;
			int rightHap = 0;
			for (int i = 0; i <= N; i++) {
				if (left[i] == -1)
					break;
				leftHap += left[i];
			}
			for (int i = 0; i <= N; i++) {
				if (right[i] == -1)
					break;
				rightHap += right[i];
			}

			if (leftHap >= rightHap) {
				count++;
			}
			return;
		}

		for (int i = 0; i <= N; i++) {
			if (isSelected[i])
				continue;
			isSelected[i] = true;
			left[i] = choo[i];
			comb2(cnt + 1);
			isSelected[i] = false;
		}
	}
}
