package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1062_가르침2 {
	static int N, K;
	static String[] words;
	static boolean visit[] = new boolean[26];
	static int maxCnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/1062_가르침.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K < 5) {
			System.out.println(0);
			return;
		}

		words = new String[N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			s = s.substring(4, s.indexOf("tica"));
			words[i] = s;
		}

		maxCnt = 0;
		visit['a' - 97] = true;
		visit['n' - 97] = true;
		visit['t' - 97] = true;
		visit['i' - 97] = true;
		visit['c' - 97] = true;

		dfs(0, 5);
		System.out.println(maxCnt);

	}

	private static void dfs(int start, int cnt) {
		if (cnt == K) {
			int ans = 0;
			for (int i = 0; i < N; i++) {
				boolean check = true;
				for (int j = 0; j < words[i].length(); j++) {
					if (!visit[words[i].charAt(j) - 97]) {
						check = false;
						break;
					}
				}
				if (check) {
					ans++;
				}
			}
			maxCnt = Math.max(maxCnt, ans);
			return;
		}

		for (int i = start; i < 26; i++) {
			if (!visit[i]) {
				visit[i] = true;
				dfs(i, cnt + 1);
				visit[i] = false;
			}
		}
	}
}
