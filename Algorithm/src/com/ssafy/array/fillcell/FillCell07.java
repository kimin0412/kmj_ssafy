package com.ssafy.array.fillcell;
import java.util.Scanner;
/**
 * 여러개의 좌표를 입력 받아 해당 좌표의 지정한 칸수에 상하 좌우에 1을 누적하기
 *  다음줄 부터 :  배열의 개수  좌표개수 칸수  {row좌표, column좌표}*좌표개수
 *  8 4 3 1 1 3 1 3 3 4 2
 */
public class FillCell07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner("8 4 3 1 1 3 1 3 3 4 2");
//		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		////////////////
		/// 처리 코드 작성
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
