package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12865_평범한배낭 {
	static int N, K, ans;
	static Node[] things;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		things = new Node[N];
		visit = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			things[i] = new Node(a, b);
		}

		ans = 0;
		for (int i = 0; i < N; i++) {
			visit[i] = true;
			DP(i, 0, 0);
			visit[i] = false;
			DP(i, 0, 0);
		}
		System.out.println(ans);
	}

	public static void DP(int idx, int hap, int value) {
		int nHap = hap;
		int nValue = value;

		if (visit[idx]) {
			nHap += things[idx].W;
			nValue += things[idx].V;
		}

		if (nHap > K) {
			ans = Math.max(ans, value);
			return;
		} else if (nHap == K) {
			ans = Math.max(ans, nValue);
			return;
		}

		if (idx == N - 1) {
			ans = Math.max(ans, nValue);
			return;
		}

		visit[idx + 1] = true;
		DP(idx + 1, nHap, nValue);
		visit[idx + 1] = false;
		DP(idx + 1, nHap, nValue);
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