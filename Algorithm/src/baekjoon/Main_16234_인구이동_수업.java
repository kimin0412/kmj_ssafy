package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 500 ms
 * 시뮬레이션
 * @author 서민규
 */
public class Main_16234_인구이동_수업 {
	private static int N;
	private static int L;
	private static int R;
	private static int[][] m;
	private static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken()); // N×N 땅의 크기 , N (1 ≤ N ≤ 50)
		L = Integer.parseInt(st.nextToken()); // L (1 ≤ L ≤ R ≤ 100), 인접한 나라의 인구 차이가 L명 <= 차이 <= R명 이면 국경을 연다
		R = Integer.parseInt(st.nextToken()); // R (1 ≤ L ≤ R ≤ 100)
		m = new int[N][N];
		for (int i = 0; i < m.length; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m.length; j++) {
				m[i][j] = Integer.parseInt(st.nextToken()); // r행 c열에 있는 나라의 인구수(0 ≤ A[r][c] ≤ 100)
			}
		}
		
		int cnt = 0;
		while(true) {
			boolean change = false; // 인구이동이 있었는지 체크할 플래그변수
			visited = new boolean[N][N]; // 방문 여부 체크
			//인접한 국가와 L~R 범위 내의 인구차인자 검사 => BFS 탐색
			for (int i = 0; i < m.length; i++) {
				for (int j = 0; j < m.length; j++) {
					if (!visited[i][j] && search(i, j)) { // 방문하지 않았으면, 탐색
						change = true;
					}
				}
			}
			
			if (!change) { // 인구이동이 없었으면
				break;
			}
			cnt++;
		}
		System.out.println(cnt);
	} // end of main
	private static int[] dr = {-1, 1, 0, 0}; // 상하좌우
	private static int[] dc = { 0, 0,-1, 1};
	
	public static boolean search(int r, int c) {
		ArrayList<Loc> al = new ArrayList<Loc>(); // 인접국가 목록
		
		Queue<Loc> q = new LinkedList<Loc>();  
		Loc l = new Loc(r,c);
		al.add(l);
		q.add(l);
		visited[r][c] = true;
		while (!q.isEmpty()) {
			l = q.poll();
			r = l.r;
			c = l.c;
			for (int i = 0; i < dc.length; i++) {
				int nr = r + dr[i]; 
				int nc = c + dc[i];
				if (0 <= nr && nr < N && 0 <= nc && nc < N 
					&& !visited[nr][nc] 
					&& diff(m[nr][nc], m[r][c])) { // 미방문, 차이가 범위내 
					Loc nl = new Loc(nr,nc);
					al.add(nl);
					q.add(nl);
					visited[nr][nc] = true;
				}
			}
		}
		//인접국가 개수가 2개 이상인 경우 인구 이동 발생 
		if (al.size() >= 2) { // 인접국
			int total = 0; // 인접국가 인구의 총합
			for (Loc loc : al) {
				total += m[loc.r][loc.c];
			}
			int avg = total / al.size();
			for (Loc loc : al) {
				m[loc.r][loc.c] = avg;
			}
			
			return true;	//인구 이동이 있으면
		}
		return false; //인구이동이 없으면
	}
	private static boolean diff(int a, int b) {
		int sub = a >= b ? a - b : b - a;
		return L <= sub && sub <= R;
	}
	public static class Loc {
		int r, c;
		public Loc(int r, int c) {
			this.r = r;
			this.c = c;
		}
		public String toString() {
			return "("+r+","+c+")";
		}
	}
} // end of class
