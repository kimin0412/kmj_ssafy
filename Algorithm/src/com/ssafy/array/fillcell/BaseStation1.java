package com.ssafy.array.fillcell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * NxN 배열을 위한 기지국(A)와 집(H)가에 대한 정보가 주어진다. 
 * 기지국은 상하좌우 1셀씩만 커버한다. 커버하지 못하는 집의 개수를 출력
 *
 * [제약조건]
 * N은 3~15이하
 * 
 * [입력]
 * 첫줄은 테스트 케이스 수(T)가 주어진다.
 * 두번째 줄은 배열 크기(N)이 주어지고
 * 세번째 줄부터 N개의 기지국 정보가 제공된다. 
 * 
 * [출력 결과]
 * #1 4
 * #2 5
 * #3 9
 */
public class BaseStation1 {
    static int AnswerN=0;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/basestation1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] dir= {{-1,0},{1,0},{0,-1},{0,1}};
		
		for(int test_case=1; test_case<=T; test_case++){
			AnswerN=0; //답은 반드시 테스트케이스 안에서 초기화시켜주기
			int N=sc.nextInt();

			char[][] map = new char[N][N];
		
			//1.읽어온 데이터를 map에 담는다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=sc.next().charAt(0);  //문자 타입의 데이터 전체를 읽어온다. 문자 데이터는 char타입으로 처리
				}
			//	map[i]=sc.nextLine().toCharArray(); //문자열에서 하나씩 쪼개서 배열에 담아서 리턴. 대신 for문 돌려줌 데이터가 공백 없이 붙어있을때 사용
			}
			//2.map을 전체 탐색하면서 기지국(A)를 찾는다.
			int nr,nc,n=dir.length;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if(map[r][c]=='A') { // A를 찾으면 상하좌우 탐색
						for (int i = 0; i < n; i++) {
							nr=r+dir[i][0];
							nc=c+dir[i][1];
							if(nr>-1 && nr<N && nc>-1 && nc<N && map[nr][nc]=='H') { 	//3.상하좌우에 집(H)이 있으면 X로 바꾼다. 자주 씀!! 외우기
								map[nr][nc]='X';
							}
						}
					}
				}
			}

			//4.전체 map에 집(H)의 갯수를 카운트한다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='H') {
						AnswerN++;
				
					}
				}
			}
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}//end main
}//end class









