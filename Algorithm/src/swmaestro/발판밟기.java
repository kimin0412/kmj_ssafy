package swmaestro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 발판밟기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int[] map = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		int ans = 0;

		for (int i = 0; i < 3; i++) {
			int cnt = 1;
			boolean[] visit = new boolean[N];
			int idx = i;
			while (true) {
				if (!visit[idx]) {
					visit[idx] = true;
					idx += map[idx];
					cnt++;
				} else {
					ans = Math.max(ans, cnt);
					break;
				}

			}
		}

		System.out.println(ans);
	}

}