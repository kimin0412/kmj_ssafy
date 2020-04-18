package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_5656_모의SW_벽돌깨기 {
	static int N;
	static int W; // 열 개수 (가로길이)
	static int H; // 행 개수 (세로길이)
	static int maxcnt = 0;
	static int[][] map;
	static int[][] tmpM;
	static int[] cntArr;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/5656_모의SW_벽돌깨기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken().trim()); // 지도 한변크기
			W = Integer.parseInt(st.nextToken().trim()); // 경사로 길이
			H = Integer.parseInt(st.nextToken().trim()); // 경사로 길이
			map = new int[H][W]; // 맵
			tmpM = new int[H][W]; // 맵
			cntArr = new int[W]; // 맵

			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
				}
			} // 맵 입력 받기

			
			for (int c = 0; c < H; c++) {
//				bfs(c, 0);
			}
				
//				for (int cc = 0; cc < N; cc++) {
//					for (int ccc = 0; ccc < N; ccc++) {	
//						for (int i = 0; i < W; i++) {
//							mapInit(map);
//							for (int j = 0; j < H; j++) {
//								if (tmpM[j][i] != 0) {
////						System.out.println("!!");
////						bfs(j, i);
//									System.out.println(counting());
//
//									break;
//								}
//							}
//						}
//					}
//				}
//			}

			System.out.println("#" + tc + " ");
		}
	}

	private static void mapInit(int[][] tmpM, int[][] mm) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				tmpM[i][j] = mm[i][j];
			}
		}
	}

	private static int check(int pos, int[][] tmpM) {
		for (int j = 0; j < H; j++) {
			if (tmpM[j][pos] != 0) {
				return j;
			}
		}
		return -1;
	}

	private static int counting(int[][] tmpM) {
		int cnt = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (tmpM[i][j] != 0)
					cnt++;
			}
		}
		return cnt;
	}

	private static void bfs(int[][] tmpM, int no, int CNT) {
		if(CNT == N) {
			if(counting(tmpM) > maxcnt) {
				maxcnt = counting(tmpM);
            }
			return;
		}
		
		LinkedList<int[]> q = new LinkedList<>();
		int[] tmp;
		
		
		
		for (int n = 0; n < N; n++) {
			q = new LinkedList<>();
			int nextR = check(no, tmpM);
			if (nextR != -1) {
				q.add(new int[] { nextR, no });
				tmpM[nextR][no] = 0;

				while (!q.isEmpty()) {
					tmp = q.poll();
					for (int i = 1; i < map[tmp[0]][tmp[1]]; i++) {
						for (int d = 0; d < 4; d++) {
							int nr = tmp[0] + dir[d][0] * i;
							int nc = tmp[1] + dir[d][1] * i;
							if (nr > -1 && nr < H && nc > -1 && nc < W && tmpM[nr][nc] != 0) {
								q.add(new int[] { nr, nc });
								tmpM[nr][nc] = 0;
							}
						}

					}
				}
			}

			int[][] move = new int[H][W]; // 맵
			for (int i = 0; i < W; i++) {
				int jj = H - 1;
				for (int j = H - 1; j > -1; j--) {
					if (tmpM[j][i] != 0) {
						move[jj][i] = tmpM[j][i];
						jj--;
					}
				}
			}
//			mapInit(move);
//			
//			for(int i = 0; i < H; i++) {
//	            bfs(i, CNT+1);
//	        }
//			
//			System.out.println("no : " + (no + 1));
//			for (int[] m : tmpM) {
//				System.out.println(Arrays.toString(m));
//			}
//			System.out.println();
		}
	}

}
