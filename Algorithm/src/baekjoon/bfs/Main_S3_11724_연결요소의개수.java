package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S3_11724_연결요소의개수 {
	static int[][] map;
//	static int[][] visit;
	static int[] visit;
	static int N;
	static int M;
	static int cnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/dfs/11724_연결요소의개수.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
//		visit = new int[N][N];
		visit = new int[N];

		
////////////////////// 그래프 양방향 형태로 입력받기 ///////////////////
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1] = 1;
			map[c - 1][r - 1] = 1;
			
		}

		int cnt = 0;
		for (int n = 0; n < N; n++) {
			if (visit[n] == 0) {
				bfs(n);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static void bfs(int cur) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(cur);
		
		while(!queue.isEmpty()) {
			int c = queue.poll();
			
			for (int i = 0; i < N; i++) {
				int nrc = map[c][i];
				
				if(nrc == 1 && visit[i]==0)
				{
					queue.add(i);
					visit[i]=1;
				}
			}
		}
	}
	
/////////////////////// 시간초과 //////////////////////////////
		/*
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r - 1][c - 1] = 1;
		}
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (map[n][m] == 1 && visit[n][m] == 0) {
					visit[n][m] = 1;
					bfs(m, n);
				}
			}
		}
		int maxcnt = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				maxcnt = Math.max(maxcnt, map[n][m]);
			}
		}
		System.out.println(maxcnt);
	}

	private static void bfs(int start, int end) {
		visit = new int[N][N];

		LinkedList<int[]> queue = new LinkedList<>();

		queue.offer(new int[] { start, end });

		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			for (int j = 0; j < N; j++) {
				if (map[tmp[0]][j] == 1 && visit[tmp[0]][j] == 0) {
					visit[tmp[0]][j] = 1;
					queue.offer(new int[] { j, end });
					if (j == end) {
						map[tmp[0]][j] = cnt;
						return;
					}
				}
			}
			for (int j = 0; j < N; j++) {
				if (map[j][tmp[0]] == 1 && visit[j][tmp[0]] == 0) {
					visit[j][tmp[0]] = 1;
					queue.offer(new int[] { j, end });
					if (j == end) {
						map[j][tmp[0]] = cnt;
						cnt++;
						return;
					}
				}
			}
		}
		 */
	


}
