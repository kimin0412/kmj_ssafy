package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭_풀이 {
	static int N, K, ans;
	static Node[] bags;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		bags = new Node[N + 1];
		int[][] dp = new int[K + 1][N + 1];

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			bags[i] = new Node(a, b);
		}

		ans = 0;
		for (int i = 1; i < K + 1; i++) {
			for (int j = 1; j < N + 1; j++) {
				if (i >= bags[j].W)
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - bags[j].W][j - 1] + bags[j].V);
				else
					dp[i][j] = dp[i][j - 1];
			}
		}
		System.out.println(dp[K][N]);
	}

	public static class Node {
		public int W;
		public int V;

		public Node(int w, int v) {
			super();
			W = w;
			V = v;
		}

		@Override
		public String toString() {
			return "Node [W=" + W + ", V=" + V + "]";
		}
	}
}