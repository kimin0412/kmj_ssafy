package com.ssafy.array.fillcell;
import java.util.Scanner;
/**
 * 배열 개수와 좌표를 입력 받아 해당 좌표에 상하좌우에 1을 표시한후 전체 배열을 화면에 출력
 * 
 * 입력 : 
 *  배열의 개수   row좌표, column좌표
 *  ex) 3  1 1
 * 
 */
public class FillCell02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();

		map[r-1][c]=1; //상
		map[r][c-1]=1; //좌
		map[r+1][c]=1; //하
		map[r][c+1]=1; //우
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	
	}
}
		
