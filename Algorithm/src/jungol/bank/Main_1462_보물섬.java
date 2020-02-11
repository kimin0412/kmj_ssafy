package jungol.bank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1462_보물섬 {
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] map;
	static int[][] visit;
	static int rowN, colN; // 맵의 너비 좌표 높이
	static int srow, scol, erow, ecol; // 시작 좌표와 종료 좌표
	static int max = 0;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/jungol/1462_보물섬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine().trim());

		rowN = Integer.parseInt(st.nextToken());
		colN = Integer.parseInt(st.nextToken());
//		System.out.println(rowN +" "+  colN);
		map = new char[rowN][colN];
		visit = new int[rowN][colN];
		for (int i = 0; i < rowN; i++) {
			String line = br.readLine();
			for (int j = 0; j < colN; j++) {
				map[i][j] = line.charAt(j);
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

//		dfs(0, 0, max);

		LinkedList<int[]> queue = new LinkedList<>();
//		int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int i = 0; i < rowN; i++) {
			for (int j = 0; j < colN; j++) {
				if (map[i][j] == 'L' && visit[i][j] == 0) {
					visit[i][j] = 1;
				}

				queue.offer(new int[] { i, j, 0});  //시작위치
				while (!queue.isEmpty()) {
					int[] node = queue.poll();
					int r = node[0];
					int c = node[1];
					int cnt = node[2];
					for (int k = 0; k < 4; k++) { // 상하좌우에 인접된 아파트이면서 방문안한 아파트 찾기
						int nr = r + dir[k][0];
						int nc = c + dir[k][1];
						// 경계 안에 있으면서
						if (nr > -1 && nr < rowN && nc > -1 && nc < colN && map[nr][nc] == 'L' && visit[nr][nc] == 0) {// 상하좌우에
							visit[nr][nc] = 1;
							queue.offer(new int[] { nr, nc, cnt+1 });
						}
					}
					if(max<node[2])
						max = node[2];
				}
			}

		}
		System.out.println(max);
	}

//	private static void dfs(int r, int c, int cnt) {
//		
//		for (int i = 0; i < 4; i++) {
//			int nr = r + dir[i][0];
//			int nc = c + dir[i][1];
//			if (nr > -1 && nr < rowN && nc > -1 && nc < colN && map[nr][nc] == 'L') {
//				cnt++;
//				dfs(nr, nc, cnt);
//			}
//			else {
//				if(max<cnt)
//					max=cnt;
//				
//			}
//		}
//	}

}
