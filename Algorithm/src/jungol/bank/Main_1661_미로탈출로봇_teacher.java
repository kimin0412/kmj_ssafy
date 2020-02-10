package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1661_미로탈출로봇_teacher {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/jungol/1661_미로탈출로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int rowN, colN;				//맵의 너비 좌표 높이
		int srow, scol, erow, ecol; //시작 좌표와 종료 좌표
		
		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
		StringTokenizer st = new StringTokenizer(br.readLine());
		colN = Integer.parseInt(st.nextToken());
		rowN = Integer.parseInt(st.nextToken());
		int map[][] = new int[rowN][colN];
		
		st = new StringTokenizer(br.readLine(), " ");
		scol = Integer.parseInt(st.nextToken()) - 1;
		srow = Integer.parseInt(st.nextToken()) - 1;
		ecol = Integer.parseInt(st.nextToken()) - 1;
		erow = Integer.parseInt(st.nextToken()) - 1;
		
		for (int i = 0; i < rowN; i++) {
			String line = br.readLine();
			for (int j = 0; j < colN; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		LinkedList<int[]> queue = new LinkedList<>();
		map[srow][scol] = 1;  //시작점에 1로 놓고 시작.		0은 가지 않은길, 		!=0은 막혔거나 방문한 길
		//시작 위치부터 BFS 탐색
		queue.offer(new int[] {srow, scol});
		int r, c, nr, nc, count = 0;
		int[] cur;
		
		top:  //맵탐사를 다 하지 못해도 도착하면 끝날거라 레이블 지정함
		while(!queue.isEmpty()) {
			cur = queue.poll();
			r = cur[0];
			c = cur[1];
			count = map[r][c];
//			현재 위치에서 갈수 있는 길을 사방탐색
			for (int i = 0; i < 4; i++) {
				nr = r + dir[i][0];
				nc = c + dir[i][1];
//				경계 검사, 									갈 수 있는 길인지 검가
				if(nr>-1 && nr<rowN && nc>-1 && nc<colN && map[nr][nc] == 0) {
					map[nr][nc] = count+1;
					if(nr == erow && nc == ecol) { //현재 위치 기준으로 다음 위치가 도착 지점
						break top;
					}
					queue.offer(new int[] {nr, nc});
				}
			}
		}
		System.out.println(map[erow][ecol]-1);
	}
}
