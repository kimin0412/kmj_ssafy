package com.ssafy.array.fillcell;
import java.util.Scanner;
/**
 * 초기 좌표에서 이동 방향 개수 만큼 이동후 마지막 이동 좌표 출력하기
 * 이동좌표가 범위를 벗어나면 -1 -1으로 출력하기 
 * 입력 :
 *  다음줄 부터 :  배열의 개수   초기row좌표, 초기col좌표, 이동 개수 , {이동 방향, 스텝} *n 
 *  1 : 오른쪽 
 *  2 : 아래쪽
 *  3 : 왼쪽
 *  4 : 윗쪽
 *  
 *  8  3 3 3 1 1 2 2 1 1                 결과] # 이동좌표 x :5 y:5  
 *  8  3 1 3 4 2 1 1 4 1                 결과] # 이동좌표 x :-1 y:-1
 */
public class FillCell10 {
	static int Answer1, Answer2;
	public static void main(String[] args) {
//		Scanner sc = new Scanner("8  3 3 3 1 1 2 2 1 1");
		Scanner sc = new Scanner("8  3 1 3 4 2 1 1 4 1");
//		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];

		System.out.println("# 이동좌표 x :"+Answer1+ " y:"+Answer2);
	}
}
