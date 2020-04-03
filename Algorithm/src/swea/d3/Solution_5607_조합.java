package swea.d3;

import java.io.*;

public class Solution_5607_조합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		long P = 1234567891;
		
		for (int tc = 1; tc <= T; tc++) {
			String[] line = br.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int R = Integer.parseInt(line[1]);

			long[] fac = new long[N + 1];
			fac[0] = 1;
			fac[1] = 1;
			for (int i = 2; i <= N; i++)
				fac[i] = (fac[i - 1] * i) % P;
			long m = (fac[R] * fac[N - R]) % P;

			long idx = P - 2;
			long num = 1;
			while (idx > 0) {
				if (idx % 2 == 1) {
					num *= m;
					num %= P;
				}
				m = (m * m) % P;
				idx /= 2;
			}
			long ans = ((fac[N] % P) * (num % P)) % P;

			System.out.println("#" + tc + " " + ans);
		}
	}
}
