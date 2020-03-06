package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1808_지희의고장난계산기 {
	static boolean[] button;
	static int N, cnt, minCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
//		입력
//		min값을 초기화  Integer.MAX_VALUE;
//		btn값이 1이면 true로 설정
		
//		처리 - 약수 탐색  => 재귀함수 
//		dfs로 풀수 없지만 약수들을 가지고 탐색해나가야해서 dfs사용
//		 basis case => 종료 조건 
//			x값이 주어진 모든 수로 누를 수 있는지 검사
//				x 길이를 리턴 
		
//		 처리
//			result 값을 -1로 초기화 
//			2~ 제곱근 까지 반복(i);
//				i는 x의 약수, 모든 수로 누를 수 있는지 검사
//					i의 길이를 구하고
//				 몫이 x의 약수, 모든 수로 누를 수 있는지 검사 ==> 재귀 호출 
//				몫이 -1이 아니면 => x의 약수, 모든 수
//				 i의 길이와 몫의 길이를 +  * =
//				결과가 min 비교해서 갱신
		
		
//		재귀를 호출하는 상황 
		
//		출력
//		min == Integer.MAX_VALUE ? -1 : min
		
		
		System.setIn(new FileInputStream("res/swea/d4/1808_지희의고장난계산기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			button = new boolean[10];
			LinkedList q = new LinkedList<>();
			cnt = 0;
			for (int i = 0; i < 10; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int tmp = Integer.parseInt(st.nextToken());
				if(tmp !=0) {
					button[i] = true;
					q.offer(i);
					cnt++;
				}
			}
			minCnt = 0;
			for (int i = 1; i <= 7; i++) { // 뽑는 수의 자리
				int sum = 0;
				for (int j = 0; j < i; j++) {
//					int[] arr = 
					for (int k = 0; k < 10; k++) {
						if(button[k] == true) {
							sum+=k*Math.pow(10, j);
						}
					}
				}
			}
			
//			dfs(1, 1, 1);
			System.out.println("#" + tc + " " + minCnt);
		}
	}
	
	
//	private static void dfs(int r, int c, int cnt) {
//		for (int i = 0; i < 4; i++) {
//			int nr = r + dir[i][0];
//			int nc = c + dir[i][1];
//			if (map[nr][nc] != 0 && !visit[nr][nc] && !selected[map[nr][nc]]) {
//				visit[nr][nc] = true;
//				selected[map[nr][nc]] = true;
//				dfs(nr, nc, cnt + 1);
//				visit[nr][nc] = false;
//				selected[map[nr][nc]] = false;
//			}
//		}
//		maxCnt = Math.max(maxCnt, cnt);
//	}
}
