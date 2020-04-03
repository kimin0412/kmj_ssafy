package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4530_극한의청소작업 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/4530_극한의청소작업.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			A = Math.abs(A);
			B = Math.abs(B);
			
			long cntA = 0, cntB = 0;
			long cntAll = B - A;
			System.out.println(cntAll);

			int k = 1;
			while (A > 0) {
				if (A % 10 < 4) {
					cntA += (A % 10) * Math.pow(9, k-1);
				} else {
					cntA += (A % 10 - 1) * Math.pow(9, k-1);
				}
//				cntA += A;
				A /= 10;
			}
			System.out.println(cntA);
			
			
			k = 1;
			while (B > 0) {
				if (B % 10 < 4) {
					cntB += (B % 10) * Math.pow(9, k-1);
				} else {
					cntB += (B % 10 - 1) * Math.pow(9, k-1);
				}
				B /= 10;
			}
			System.out.println(cntB);
			
			cntAll -= cntA + cntB;
			System.out.println("#" + tc + " " + (cntA+cntB));
		}

	}

}
