package D2;

import java.util.Scanner;

public class D2_1284 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int P, Q, R, S, W;
			P = sc.nextInt();
			Q = sc.nextInt();
			R = sc.nextInt();
			S = sc.nextInt();
			W = sc.nextInt();
			
			if(R>W) {
				if(Q<P*W)
					System.out.println("#" + test_case + " " + Q);
				else
					System.out.println("#" + test_case + " " + P * W);
			}
			else {
				if((Q + (W - R) * S)<P*W)
					System.out.println("#" + test_case + " " + (Q + (W - R) * S));
				else
					System.out.println("#" + test_case + " " + P * W);
			}
		}
	}

}
