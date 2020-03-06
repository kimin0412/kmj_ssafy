package swea.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_2105_모의SW_디저트카페 {
	static int N; // 맵 크기
	static int max; // 디저트를 먹은 최대 개수
	static int sr; // 시작 좌표
	static int sc; // 시작 좌표
	static int[][] map;
	static boolean[][] visit; // 방문처리
	static HashSet list = new HashSet(); // 디저트 중복 처리
	// 우하 -> 좌하 -> 좌상 -> 우상
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
			visit = new boolean[N][N];
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
//					set을 초기화
					list.clear();
//					visit 배열을 초기화
					for (int k = 0; k < N; k++) {
						Arrays.fill(visit[k], false);
					}
//					dfs 탐색(i, j, d)
					dfs(i, j, 0);
				}
			}
//			출력   max==0?-1:max
			System.out.println("#" + tc + " " + (max == 0 ? -1 : max));
//	
		}
	}

	private static void dfs(int r, int c, int dir) {
//		현재 노드에 대한 방문 표시
		visit[r][c] = true;
//		set에 현재 노드를 추가
		list.add(map[r][c]);
//		현재 방향에서부터 <4 반복 하면서
		for (int d = dir; d < 4; d++) {
			int nr = r + direction[d][0];
			int nc = c + direction[d][1];
			int cnt = list.size();
//			다음 좌표가 시작 좌표이고 cnt>=4 이상인지 검사 => 한바퀴를 탐색
			if (nr == sr && nc == sc && cnt >= 4) {
//				cnt를 max값과 비교해서 갱신
				if (cnt > max) {
					max = cnt;
					return;
				}
			}
			if (nr > -1 && nr < N && nc > -1 && nc < N // 다음 좌표가 경계 내에 있고
					&& !visit[nr][nc] // 방문한 적이 없고,
					&& !list.contains(map[nr][nc])) { // 처음 먹어보는 디저트인지
//				다음 노드로 이동 => 재귀 호출 
				dfs(nr, nc, d);

			}
		}
//		visit 배열에서 현재 노드에 대한 방문 표시한 것을 해제
		visit[r][c] = false;
//		set에 현재 노드를 제거
		list.remove(map[r][c]);
	}
}