package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20040_사이클게임 {
	static int N, M;
	static int[] parent;

	public static int find(int x) {
		if (x == parent[x])
			return x;
		int y = find(parent[x]);
		parent[x] = y;
		return y;
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;
		else {
			parent[y] = x;
			return true;
		}
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/Main_20040_사이클게임.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int tc = 0; tc < 1; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			parent = new int[N + 1];

			for (int n = 0; n < N; n++) {
				parent[n] = n;
			}

			int cnt = 0;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (!union(a, b)) {
					cnt = m + 1;
					break;
				}
			}
			System.out.println(cnt);
		}
	}
}
