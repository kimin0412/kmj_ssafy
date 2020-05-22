package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1251_준환이의양팔저울2 {
	static int N, count;
	static int[] choo, left, right;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/준환이의 양팔저울.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			choo = new int[N];
			for (int i = 0; i < N; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
			left = new int[N];
			right = new int[N];
			count = 0;

			subset(count, 0, 0);

			System.out.format("#%d %d\n", tc, count);
		}
	}

	private static void subset(int cur, int left, int right) {
		if (cur == N) {
			count++;
		} else {
			for (int i = cur; i < N; i++) {
				int tmp = choo[cur];
				choo[cur] = choo[i];
				choo[i] = tmp;

				subset(cur + 1, left + choo[cur], right);
				if (left >= right + choo[cur]) {
					subset(cur + 1, left, right + choo[cur]);
				}
				tmp = choo[cur];
				choo[cur] = choo[i];
				choo[i] = tmp;

			}
		}
	}
}
