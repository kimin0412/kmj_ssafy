package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_4014_모의SW_활주로건설 {
	static int N;
	static int X;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/4014_모의SW_활주로건설.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); // 지도 한변크기 
			X = Integer.parseInt(st.nextToken()); // 경사로 길이 
			map = new int[N][N]; // 맵
			int[][] maxX = new int[2][N]; // 각행/마다 최대값 저장해두는 배열
			int[][] idxArr = new int[N][2];
			
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			} //맵 입력 받기
			
			for (int i = 0; i < N; i++) {
				int maxcntR = 0;
				int maxcntC = 0;
				for (int j = 0; j < N; j++) {
					maxcntR = Math.max(maxcntR, map[i][j]);
					maxcntC = Math.max(maxcntC, map[j][i]);
				}
				maxX[0][i] = maxcntR;
				maxX[1][i] = maxcntC;
			}
			System.out.println(Arrays.toString(maxX[0]));
			System.out.println(Arrays.toString(maxX[1]));
			//최대값 구하기
			
			
			
			
//			LinkedList<int[]> q = new LinkedList<>();
			int a = 0;
			for (int i = 0; i < N; i++) {
				int maxtmp = maxX[0][i];
				boolean flag = false;
				int idxS = 0;
				int idxE = 0;
				for (int j = 0; j < N; j++) {
					if(flag && map[i][j] == maxtmp){
						flag = true;
						idxS = j;
//						idxArr[a][0] = j;
					}
					else if(!flag && map[i][j] == maxtmp){
						flag = false;
						idxE = j;
//						q.add(new int[] {idxS, idxE});
//						idxArr[a][1] = j;
					}
				}
				a++;
			}
			for (int i = 0; i < idxArr.length; i++) {
				System.out.println(idxArr[i][0] + " "  + idxArr[i][1]);
				
			}
			
			for (int i = 0; i < N; i++) {
				int maxtmp = maxX[0][i];
				boolean flag = false;
//				int idxS = 0;
//				int idxE = 0;
				for (int j = maxX[0][i]; j > 0; j++) {
					if(flag && map[i][j] == maxtmp){
						flag = true;
						idxArr[a][0] = j;
					}
					else if(!flag && map[i][j] == maxtmp){
						flag = flag;
						idxArr[a][1] = j;
					}
				}
				a++;
			}
			
			
			
			LinkedList<int[]> q = new LinkedList<>();
			for (int h = 6; h > 0; h--) {
				for (int i = 0; i < N; i++) {
					boolean flag = false;
					int idxS = 0;
					int idxE = 0;
					for (int j = 0; j < N; j++) {
						if(flag && map[i][j] == h){
							flag = true;
							idxS = j;
//							idxArr[a][0] = j;
						}
						else if(!flag && map[i][j] == h){
							flag = false;
							idxE = j;
							q.add(new int[] {idxS, idxE});
//							idxArr[a][1] = j;
						}
					}
				}
				
				
			}
			
			/*
			 
3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 
3 3 3 2 2 2 2 3 3 3 4 4 4 4 4 4 5 5 5 5 
5 3 3 2 2 2 2 2 3 3 4 4 4 4 5 5 5 5 5 5 
4 3 3 1 1 1 1 1 2 3 4 4 4 5 5 5 5 5 5 5 
4 2 2 1 1 1 1 1 2 3 4 5 5 5 5 5 5 5 5 5 
4 3 3 2 2 2 2 1 2 3 4 5 5 5 5 5 5 5 5 5 
4 4 4 4 4 3 3 2 3 4 5 5 5 5 5 5 5 5 5 5 
4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 ?
4 3 3 3 3 3 3 3 4 4 4 5 5 5 5 5 5 4 4 4 ?
4 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 ?
3 3 3 3 3 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 ,
3 3 3 3 3 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 ,
3 3 3 3 4 4 4 4 5 5 5 5 5 5 5 5 5 5 5 5 ,
4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 ,
4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 4 4 4 ,
5 5 5 5 5 5 5 5 5 5 5 5 4 4 4 4 4 4 4 4 ,
5 5 5 5 5 5 5 5 5 5 5 5 3 3 3 3 4 4 4 4 
5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 
5 5 5 5 5 5 5 5 5 5 5 5 3 3 2 2 3 3 4 4 
5 5 5 5 5 5 5 5 4 4 4 4 3 3 3 3 4 4 4 4 
	   		      , ,
			 
			 
			 */
			
			
			
		}
	}
}
