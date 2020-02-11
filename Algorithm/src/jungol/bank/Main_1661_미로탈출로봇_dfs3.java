package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백트래킹 개념의 메모이제이션 사용한 dfs
public class Main_1661_미로탈출로봇_dfs3 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	static int rowN, colN;				//맵의 너비 좌표 높이
	static int srow, scol, erow, ecol; //시작 좌표와 종료 좌표
	
	/**
	 * 방문 기록이면서 노드 이동의 최단 거리를 기록
	 * 0 : 안가본길
	 * 숫자 : 가본길, 노드까지의 최단 이동 거리
	 */
	static int[][] visit;
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
		visit = new int[rowN][colN];
		
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
		
		map[srow][scol] = 1;
		dfs(srow, scol);
		System.out.println(map[srow][scol]);
	}
	
	private static void dfs(int r, int c) {  //dist는 visit에 기록해놓을거라 필요없다.
		if(r == erow && c == ecol) {
			//도착 지점까지 온 상태
			return;
		}
		
		int dist = map[r][c];
		for (int i = 0; i < 4; i++) {
			int nr = r + dir[i][0];
			int nc = c + dir[i][1];
			if(nr>-1 && nr<rowN && nc>-1 && nc<colN  //경계검사 
					&& map[nr][nc] == 0 			 //방문한 적이 없거나
					|| map[nr][nc]>dist+1) {  	 //방문한 적이 있어도 최단이 아니면
				map[nr][nc] = dist+1;
				dfs(nr, nc);
				// 다른 길로 갈 예정이기 때문에 현재 경로는 안가본 길로 표시해준다.
//				map[nr][nc] = dist+1;
			}
		}

	}
}
