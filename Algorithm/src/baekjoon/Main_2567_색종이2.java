package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2567_색종이2 {
	static int M = 30;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[M][M];
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			int r = arr[i][1];  //7
			int c = arr[i][0];  //3
			for (int j = 0; j < 10; j++) {
				map[M-1-r][c+j] = 1; //바닥면
				map[M-1-(r+j)][c+9] = 1; //오른쪽면
//				map[M-1-r-10][c-j]=1; //
				map[M-1-(r+j)][c]=1;  //왼쪽면
				
			}
//			for (int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
//			System.out.println();
//
//			for (int j = 0; j < 10; j++) {
//				System.out.println(c);
//				map[M-1-(r+j)][c+10]++; //오른쪽면
//			}
//			for (int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
//			
//			for (int j = 0; j < 10; j++) {
//				System.out.println(c);
//				map[M-1-(r+j)][c]++;  //왼쪽면
//			}
//			for (int[] m : map) {
//				System.out.println(Arrays.toString(m));
//			}
//			for (int j = 0; j < 10; j++) {
//				System.out.println(c);
//				map[r][c+j]++; //바닥면
//				map[M-1-(r+j)][c+10]++; //오른쪽면
//				map[M-1-r-10][c-j]++; //
//				map[M-1-(r+j)][c]++;  //왼쪽면
//			}
		}
		
//		for (int i = 0; i < N; i++) {
//			int r = arr[i][1];
//			int c = arr[i][0];
//			for (int j = 0; j < 10; j++) {
//				for (int k = 0; k < 10; k++) {
//					map[M-1-(r+j)][c+k]++;
//				}
//			}
//		}
		
//		
		for (int[] m : map) {
			System.out.println(Arrays.toString(m));
		}
		System.out.println();
		
		
//		int cnt = 0;
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 100; j++) {
//				if(map[i][j] == 1)
//					cnt++;
//			}
//		}
//		System.out.println(cnt);
	}
}

