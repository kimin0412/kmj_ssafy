package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1808_지희의고장난계산기2 {
	static boolean[] btn;
	static int X, cnt, min;

	public static void main(String[] args) throws Exception {
//		입력
		System.setIn(new FileInputStream("res/swea/d4/1808_지희의고장난계산기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
//		min값을 초기화  Integer.MAX_VALUE;
			min = Integer.MAX_VALUE;
			StringTokenizer st;
			btn = new boolean[10];
			st = new StringTokenizer(br.readLine().trim(), " ");
			int num;
			for (int i = 0; i < 10; i++) {
				num = Integer.parseInt(st.nextToken());
				if (num == 1) {
//		btn값이 1이면 true로 설정
					btn[i] = true;
				}
			}
			X = Integer.parseInt(br.readLine().trim());

//		처리 - 약수 탐색  => 재귀함수 
			find(X, 0);
//			dfs로 풀수 없지만 약수들을 가지고 탐색해나가야해서 dfs사용

//		출력
//		min == Integer.MAX_VALUE ? -1 : min
			min = min == Integer.MAX_VALUE ? -1 : min;
			System.out.println("#" + tc + " " + min);

		}
	}

	private static int find(int x, int cnt) {
//		 basis case => 종료 조건 
		if(isMake(x+"")) {
//			x값이 주어진 모든 수로 누를 수 있는지 검사
//				x 길이를 리턴 
			if(cnt == 0) {
				min = len(x)+1; // 계산 버튼을 위해 1을 더한다.
			}
			return len(x) + 1;
		}
//		 처리
//			result 값을 -1로 초기화 
		int result = -1;
//			2~ 제곱근 까지 반복(i);
		for (int i = 2, end = (int)Math.sqrt(X); i < end; i++) {
//				i는 x의 약수, 모든 수로 누를 수 있는지 검사
			if(x%i == 0 && isMake(i+"")) {
//					i의 길이를 구하고
				int len1 = len(i) + 1; // 곱하기 버튼을 위해 1을 더한다.
//				 몫이 x의 약수, 모든 수로 누를 수 있는지 검사 ==> 재귀 호출 
				int len2 = find(x/i, cnt+1);
//				몫이 -1이 아니면 => x의 약수, 모든 수
				if(len2 > -1) {
//				 i의 길이와 몫의 길이를 +  * =
					result = len1 + len2;
					if(result < min && x == X) {
//				결과가 min 비교해서 갱신
						min = result;
					}
				}
//		재귀를 호출하는 상황 	
			}
		}
		return result;
	}

	private static int len(int x) {
		return (int) Math.log10(x) + 1; // 자리수 갯수 
	}

	private static boolean isMake(String x) {
		for (char c : x.toCharArray()) { // 포문 돌때마다 실행될때마다 실행되는게 아니라 최적화됨 -> toCharArray는 한번만 실행
			if (!btn[c - '0']) { // 고장난 버튼 이라면
				return false;
			}
		}
		return true;
	}
}
