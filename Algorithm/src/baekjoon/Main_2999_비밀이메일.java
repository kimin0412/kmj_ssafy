package baekjoon;

import java.util.Scanner;

public class Main_2999_비밀이메일 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int N = s.length();
		int R = (int) Math.sqrt(N);
		int C = R;
		
		if (R * C != N) {
			top:
			for (int i = R; i > 0; i--) {
				for (int j = C; j <= N; j++) {
					if (i * j == N) {
						R = i;
						C = j;
						break top;
					}
				}
			}
		}
		
		char[][] arr = new char[R][C];
		int cnt = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				arr[j][i] = s.charAt(cnt);
				cnt++;
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
		}
		System.out.println();
	}
}

