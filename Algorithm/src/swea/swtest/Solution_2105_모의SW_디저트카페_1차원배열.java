package swea.swtest;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;
// 먹은걸로 방문처리를 같이 하면 메모리를 절약할 수 있다.
// 1~100까지 배열사용 -> Set 안쓰면서 메모리랑 시간을 아낄 수 있다. 힙을 두번 방문 안해도
public class Solution_2105_모의SW_디저트카페_1차원배열 {
	static int N; // 맵 크기
	static int max; // 디저트를 먹은 최대 개수
	static int sr; // 시작 좌표
	static int sc; // 시작 좌표
	static int[][] map;
	static boolean[] visit; // 방문처리
	// 								우하 -> 좌하 -> 좌상 -> 우상
	static int[][] direction = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/2105_모의SW_디저트카페.txt"));
//		입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
//			max를 0으로 초기화
			max = 0;
//			N을 입력받아 N*N 배열을 생성
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
//			N*N boolean 타입의 visit 배열을 생성
			visit = new boolean[101]; // 먹은 디저트 중복 체크, 방문 체크도 같이
			
//			데이터 읽기 
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

//	 	탐색(dfs)
//			N*N을 반복 돌면서 i j번째의 카페부터 투어
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					시작 좌표를 i, j로 설정
					sr = i;
					sc = j;
//					visit 배열을 초기화
					Arrays.fill(visit, false);
//					dfs 탐색(i, j, d)
					dfs(i, j, 0, 1);
				}
			}
//			출력   max==0?-1:max
			System.out.println("#" + tc + " " + (max == 0 ? -1 : max));
//	
		}
	}

	private static void dfs(int r, int c, int dir, int cnt) { // list.size를 체크해야하므로 cnt변수 추
//		현재 노드에 대한 방문 표시
		visit[map[r][c]] = true;
//		현재 방향에서부터 <4 반복 하면서
		for (int d = dir; d < 4; d++) {
			int nr = r + direction[d][0];
			int nc = c + direction[d][1];
//			다음 좌표가 시작 좌표이고 cnt>=4 이상인지 검사 => 한바퀴를 탐색
			if (nr == sr && nc == sc && cnt >= 4) {
//				cnt를 max값과 비교해서 갱신
				if (cnt > max) {
					max = cnt;
					return;
				}
			}
			if (nr > -1 && nr < N && nc > -1 && nc < N // 다음 좌표가 경계 내에 있고
					&& !visit[map[nr][nc]]) { // 처음 먹어보는 디저트인지 => 방문처
//				다음 노드로 이동 => 재귀 호출 
				dfs(nr, nc, d, cnt+1);

			}
		}
//		visit 배열에서 현재 노드에 대한 방문 표시한 것을 해제
		visit[map[r][c]] = false;
	}
}