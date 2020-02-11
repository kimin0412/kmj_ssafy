package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1661_미로탈출로봇_bfs {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	static int rowN, colN;				//맵의 너비 좌표 높이
	static int srow, scol, erow, ecol; //시작 좌표와 종료 좌표
	static boolean[][] visit;
	static int min = Integer.MAX_VALUE; //결과 값
	
	static int N;
	static int no = 1;
	static int r, c, nr, nc, count = 0;
	static int[] cur;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/jungol/1661_미로탈출로봇.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		colN = Integer.parseInt(st.nextToken());
		rowN = Integer.parseInt(st.nextToken());
		map = new int[rowN][colN];
		visit = new boolean[rowN][colN];
		
		st = new StringTokenizer(br.readLine().trim(), " ");
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
		
		visit[srow][scol] = true;
		dfs(srow, scol, 0);
		System.out.println(min);
	}
	
	private static void dfs(int r, int c, int dist) {
		if(r == erow && c == ecol) {
			//도착 지점까지 온 상태
			min = Math.min(min, dist);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr>-1 && nr<rowN && nc>-1 && nc<colN  //경계검사 
					&& map[nr][nc] == 0 			 //갈수있는길
					&& !visit[nr][nc]) {  			 //방문한 적이 없는 경로
				visit[nr][nc] = true;
				dfs(nr, nc, dist+1);
				// 다른 길로 갈 예정이기 때문에 현재 경로는 안가본 길로 표시해준다.
				visit[nr][nc] = false;
			}
		}

	}
}
