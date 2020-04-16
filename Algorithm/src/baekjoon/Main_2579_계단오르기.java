package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

 6
10
20
15
25
10
20

75

 */
public class Main_2579_계단오르기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] stair = new int[n + 1];
		int[] D = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		D[0] = 0;
		D[1] = stair[1];
		if(n>=2)
			D[2] = D[1] + stair[2];

		for (int i = 3; i <= n; i++) {
			D[i] = Math.max(D[i - 2] + stair[i]
					, D[i - 3] + stair[i - 1] + stair[i]);
		}

		System.out.println(D[n]);
	}
}
