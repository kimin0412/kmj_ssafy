//package swmaestro;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.StringTokenizer;
//
//public class 땅콩 {
//
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		int E = Integer.parseInt(st.nextToken());
//		int[] map = new int[N];
//
//		int max = E;
//		int min = E;
//
//		st = new StringTokenizer(br.readLine(), " ");
//		for (int i = 0; i < N; i++) {
//			map[i] = Integer.parseInt(st.nextToken());
//		}
//
//		int cnt = 0;
//		int idx = E;
//		int minABS = E;
//		int maxABS = E;
//		
//		while (true) {
//			if (cnt == M)
//				break;
//
//
//			for (int i = 0; i < N; i++) {
//				if (map[i] <= E) {
//					minABS = Math.min(minABS, Math.abs(map[i] - idx))
//				}
//			}
//
//		}
//		int ans = 0;
//
//		for (Integer i : maxDoo.keySet()) {
//			ans += maxDoo.get(i);
//		}
//
//		System.out.println(ans);
//	}
//
//}