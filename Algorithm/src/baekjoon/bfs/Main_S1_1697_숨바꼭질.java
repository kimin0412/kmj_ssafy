package baekjoon.bfs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_S1_1697_숨바꼭질 {
	static int N;
	static int K;
	static int mincnt = Integer.MAX_VALUE;
	static int visit[];

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/baekjoon/dfs/2178_미로탐색.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visit = new int[K + 1];
//		LinkedList<Integer> queue = new LinkedList<>();
//		queue.offer(N);
//		
//		while(!queue.isEmpty()) {
//			int tmp  = queue.poll();
//			if(tmp !=)
//			
//		}

		visit[N] = 1;
		mincnt = Math.abs(N-K);
		if (N <= K) {
			System.out.println(K - N);
		} else {
			bfs(N, 0);
		}
	}

//
	private static void bfs(int cur, int cnt) {
		if (cnt >= mincnt)
			return;
		LinkedList<Integer> queue = new LinkedList<>();
		queue.offer(cur);

		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			if (tmp == K) {
				mincnt = Math.min(mincnt, cnt);
				return;
			} else {

			}

		}
	}
//
//	private static void bfs(int r, int c, int cnt) {
//		LinkedList<int[]> queue = new LinkedList<>();
//		
//		queue.offer(new int[] {r, c, cnt});
//		
//		while(!queue.isEmpty()) {
//			int[] tmp  = queue.poll();
//			for (int d = 0; d < 4; d++) {
//				int nr = tmp[0] + dir[d][0];
//				int nc = tmp[1] + dir[d][1];
//				if(nr>-1 && nr<N && nc>-1 && nc<M 
//						&& map[nr][nc] == 1 && visit[nr][nc] == 0) {
//					queue.offer(new int[] {nr, nc, cnt});
//	                map[nr][nc] = map[tmp[0]][tmp[1]] + 1;
//	                visit[nr][nc] = 1;
//				}
//			}
//		}
//	}

}
