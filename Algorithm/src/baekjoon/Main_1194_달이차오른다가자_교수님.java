package baekjoon;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 
 * 7
 * -1
 * 55
 *
 */
public class Main_1194_달이차오른다가자_교수님 {
	static int N,M;
	static char[][] map;
	static boolean[][][] visit;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/bfs/1194_달이차오른다가자.txt"));
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		// 획득한 key를 받아 갔던 길에만 방문 체크 하기 위해  
		visit = new boolean [N][M][2<<7];   //key는 bit마스크로 획득한 키를 표시 
		int sr=0, sc=0;
		for (int i = 0; i <N; i++) {
			map[i] = in.readLine().toCharArray();
			for (int j = 0; j <M; j++) {
				if(map[i][j]=='0') {
					sr = i;
					sc = j;
				}
			}
		}
		bfs(sr,sc);
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}
	private static void bfs(int sr, int sc) {
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {sr, sc, 0, 0});
		visit[sr][sc][0] = true;
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int[] cur;
		int depth,  nr, nc;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			sr = cur[0];
			sc = cur[1];
			depth = cur[3];
			for (int d = 0; d <4; d++) {
				nr = sr+dr[d];
				nc = sc+dc[d];
				int key= cur[2];		//key를 사방향에 대한 획득한 키만 갱신해야 하기 때문에  여기서  key를 얻어온다. 
				if(nr>-1 && nr <N && nc>-1 && nc<M ) {
					if(map[nr][nc]=='1') {
						min = Math.min(min, depth+1);
						return;
					}
					if(map[nr][nc]=='#') {
						continue;
					}
					if(map[nr][nc]>='A' && map[nr][nc]<='F') {
						if((key & 1<<(map[nr][nc]-'A'))== 0) {
							continue;
						}
					}
					if(map[nr][nc]>='a' && map[nr][nc]<='f') {
						key |= 1<<( map[nr][nc]-'a');
					}
					
					// key를 얻어 온 후 해당 위치에 대한 방문 했는지 여부를 확인해 본다. 
					if(visit[nr][nc][key]) {
						continue;
					}
					visit[nr][nc][key] =true;
					queue.offer(new int[] {nr, nc, key, depth+1});
				}
			}
		}
	}
}





