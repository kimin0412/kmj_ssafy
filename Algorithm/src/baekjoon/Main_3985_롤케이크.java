package HW;

import java.util.Scanner;

public class Main_3985_롤케이크 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		int[] arrL = new int[L];
		int[][] arrN = new int[N+1][2];
		int num = 0;
		int maxP = 0;
		int maxC = 0;
		for (int i = 1; i <= N; i++) {
			arrN[i][0] = sc.nextInt();
			arrN[i][1] = sc.nextInt();
			if(maxP< arrN[i][1]-arrN[i][0]) {
				maxP = arrN[i][1]-arrN[i][0];
				num = i;
			}
		}
		System.out.println(num);

		for (int i = 1; i <= N; i++) {
			int cnt = 0;
			for (int j = arrN[i][0]-1; j <= arrN[i][1]-1; j++) {
				if(arrL[j] == 0) {
					arrL[j] = i;
					cnt++;
				}
			}
			if(maxC<cnt) {
				maxC = cnt;
				num = i;
			}
		}
		System.out.println(num);
	}
}

