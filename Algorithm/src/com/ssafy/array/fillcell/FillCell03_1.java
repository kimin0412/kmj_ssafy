package com.ssafy.array.fillcell;
import java.util.Scanner;
/**
 * 배열 개수와 좌표를 입력 받아 해당 좌표에 상하좌우에 1을 표시한후 전체 배열을 화면에 출력
 * 경계 검사
 * 
 * 입력 : 
 *  배열의 개수   row좌표, column좌표
 *  ex) 3 0 0 
 * 
 */
public class FillCell03_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		////////////////
		/// 처리 코드 작성
		            //상,하,좌,우,좌상,우상,좌하,우하
		int[] dirR= {-1,1,0,0,-1,-1,1,1};
		int[] dirC= {0,0,-1,1,-1,1,-1,1};
		
		//중요함. 외울것
		for (int i = 0; i < dirC.length; i++) {
			int nr=r+dirR[i];
			int nc=c+dirC[i];
			if(nr>-1 && nr<N && nc>-1 && nc<N) {
				map[nr][nc]=1;
			}
		}
		
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
	}
}
