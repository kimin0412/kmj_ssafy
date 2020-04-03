package baekjoon.bfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 백준_직사각형탈출 {
	// 맵의 크기.
	static int N;
	static int M;
	// 움직일 직사각형의 크기
	static int H;
	static int W;
	static int[][] map;
	static boolean[][] visited;
	// 움직일 직사각형의 시작점
	static int Sr;
	static int Sc;
	// 목표하는 도착점.
	static int Fr;
	static int Fc;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 2 ≤ N, M ≤ 1,000
		M = sc.nextInt(); // 2 ≤ N, M ≤ 1,000
		map = new int[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++)
				map[i][j] = sc.nextInt();
		}
		H = sc.nextInt(); // 1 ≤ H ≤ N
		W = sc.nextInt(); // 1 ≤ W ≤ M
		Sr = sc.nextInt();
		Sc = sc.nextInt();
		Fr = sc.nextInt();
		Fc = sc.nextInt();
		ans = -1;
		//BFS가즈아.
		Queue<Status> queue = new LinkedList<>();
		queue.add(new Status(Sr, Sc, 0));
		visited[Sr][Sc] = true;
		while (!queue.isEmpty()) {
			Status s = queue.poll();
			//목적지에 도달했을때의 이동칸수를 ans에 담고 탐색을 종료한다.
			if (s.r == Fr && s.c == Fc) {
				ans = s.cnt;
				break;
			}
			for (int i = 0; i < 4; i++) {
				//4방으로 이동가능한지 체크.
				if(movable(s.r, s.c, i)) {
					int nr = s.r + dr[i];
					int nc = s.c + dc[i];
					if(visited[nr][nc])
						continue;
					visited[nr][nc] = true;
					queue.add(new Status(nr, nc, s.cnt + 1));
				}
			}
		}
		System.out.println(ans);
	}
	 //하 상 우 좌
	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int ans = 987654321;
	//이동 가능이란, 한칸 더 이동해도 끝이 나가떨어지지 않으면서.
	//새로 이동해서 밟게 되는 영역에 1이 존재하는지 검사
	static boolean movable(int r,int c, int dir) {
		if( dir == 0 ) {
			if( r + H <= N ) {
				for(int i = 0; i < W; i++) {
					if(map[r+H][c+i] == 1)
						return false;
				}
			}
			else
				return false;
		}
		else if( dir == 1 ) {
			if( r - 1 > 0 ) {
				for(int i = 0; i < W; i++) {
					if(map[r-1][c+i] == 1)
						return false;
				}
			}
			else
				return false;
		}
		else if( dir == 2 ) {
			if( c + W  <= M ) {
				for(int i = 0; i < H; i++) {
					if(map[r+i][c+W] == 1)
						return false;
				}
			}
			else
				return false;
		}
		else if( dir == 3 ) {
			if( c - 1 > 0 ) {
				for(int i = 0; i < H; i++) {
					if(map[r+i][c-1] == 1)
						return false;
				}
			}
			else
				return false;
		}
		return true;
	}
	static class Status {
		int r, c, cnt;

		Status(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}
