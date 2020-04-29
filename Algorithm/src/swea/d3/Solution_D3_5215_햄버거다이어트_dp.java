//package swea.d3;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Solution_D3_5215_햄버거다이어트_dp {
//	static int[][] arr;
//	static int max = 0;
//	static int N;
//	static int L;
//
//	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/swea/d3/5215_햄버거다이어트.txt"));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		StringTokenizer st;
//		int T = Integer.parseInt(br.readLine().trim());
//		for (int tc = 0; tc < T; tc++) {
//			max = 0;
//			st = new StringTokenizer(br.readLine().trim(), " ");
//			N = Integer.parseInt(st.nextToken());
//			L = Integer.parseInt(st.nextToken());
//			arr = new int[N][2];
//
//			for (int j = 0; j < N; j++) {
//				st = new StringTokenizer(br.readLine().trim(), " ");
//				arr[j][0] = Integer.parseInt(st.nextToken());
//				arr[j][1] = Integer.parseInt(st.nextToken());
//			}
//			
//			int[] cal = new int[N];
//			
//			for (int i = 1; i < N; i++) { 
//
//				for (int j = 0; j < w[1]; j++) { // 임시 배낭의 무게가 물건의 무게보다 적으면 이전 차수에서 값을 가져옴
//					K[i][j] = K[i-1][j];
//				}
//				for (int j = w[i]; j <= W; j++) {
//					int now = K[i-1][j - w[i]] + v[i]; // 물건 선택을 고려한 경우
//					int pre = K[i][j]; // 물건을 고려하지 않은 경우
//					K[i][j] = now >= pre ? now : pre;
//				}
//			}
//			
//			
//			dfs(0, 0, 0);
//			System.out.println("#" + (tc+1) + " " +max);
//		}
//	}
//
//}
