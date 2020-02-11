package HW;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[100][100];
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}			
		
		for (int i = 0; i < N; i++) {
			int r = arr[i][0];
			int c = arr[i][1];
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					map[r+j][c+k] = 1;
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}

