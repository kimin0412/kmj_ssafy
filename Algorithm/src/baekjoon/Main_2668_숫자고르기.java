package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2668_숫자고르기 {
	static int N, M, ans;
	static List<Integer>[] map;
//	static int[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
//		map = new int[N][N];
		map = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			map[i] = new ArrayList<Integer>();
		}

		visit = new boolean[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[a].add(b);
			map[b].add(a);
		}

		ans = 0;
		for (int i = 0; i < N; i++) {
			if (ans == 1)
				break;
			visit[i] = true;
			dfs(i, 1);
			visit[i] = false;
		}
		System.out.println(ans);
	}

	private static void dfs(int idx, int cnt) {
		if (cnt == 5) {
			ans = 1;
			return;
		}

		for (int e : map[idx]) {
			if (!visit[e]) {
				visit[e] = true;
				dfs(e, cnt + 1);
				visit[e] = false;
			}

		}
	}
}