package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9659_다항식계산 {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/swea/d4/9659_다항식계산.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] t = new int[100];
			int[] a = new int[100];
			int[] b = new int[100];
			for (int i = 2; i <= N; i++) {
				st = new StringTokenizer(br.readLine().trim(), " ");
				t[i] = Integer.parseInt(st.nextToken());
				a[i] = Integer.parseInt(st.nextToken());
				b[i] = Integer.parseInt(st.nextToken());
			}
			int M = Integer.parseInt(br.readLine());
			System.out.print("#" + tc + " ");
			st = new StringTokenizer(br.readLine().trim(), " ");
			long[] res = new long[100];
			for (int i = 0; i < M; i++) {
				long x = Long.parseLong(st.nextToken());
				res[0] = 1;
				res[1] = x;
				for (int j = 2; j <= N; j++) {
					if (t[j] == 1)
						res[j] = (res[a[j]] + res[b[j]]) % 998244353;
					else if (t[j] == 2)
						res[j] = (a[j] * res[b[j]]) % 998244353;
					else if (t[j] == 3)
						res[j] = (res[a[j]] * res[b[j]]) % 998244353;
				}
				System.out.print(res[N] + " ");
			}
			System.out.println();
		}
	}
}
