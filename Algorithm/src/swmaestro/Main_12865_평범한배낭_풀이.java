//package swmaestro;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main_12865_평범한배낭_풀이 {
//	static int p, n, h, ans;
//	static int[][] bags;
//	static int[] pc;
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//		p = Integer.parseInt(st.nextToken());
//		n = Integer.parseInt(st.nextToken());
//		h = Integer.parseInt(st.nextToken());
//
//		bags = new int[p][n];
//		pc = new int[p];
//		for (int i = 0; i < n; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			bags[a][pc[a]] = b;
//			pc[a]++;
//		}
//
//		ans = 0;
//		for (int pp = 0; pp < p; pp++) {
//			int[][] dp = new int[h + 1][n + 1];
//			
//			for (int i = 1; i < h + 1; i++) {
//				for (int j = 1; j < pc[pp]; j++) {
//					if (i >= bags[pp][j])
//						dp[i][j] = Math.max(dp[i][j - 1], dp[i - bags[pp][j]][j - 1] + bags[pp][j].V);
//					else
//						dp[i][j] = dp[i][j - 1];
//				}
//			}
//			System.out.println(dp[K][N]);
//		}
//		
//
////		for (int i = 1; i < N + 1; i++) {
////			st = new StringTokenizer(br.readLine(), " ");
////			int a = Integer.parseInt(st.nextToken());
////			int b = Integer.parseInt(st.nextToken());
////			bags[i] = new Node(a, b);
////		}
//
//	}
//
//	public static class Node {
//		public int pc;
//		public int hour;
//
//		public Node(int p, int h) {
//			super();
//			pc = p;
//			hour = h;
//		}
//	}
//}
