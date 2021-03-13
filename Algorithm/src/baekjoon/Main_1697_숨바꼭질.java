package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int ans = Integer.MAX_VALUE;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { N, 0 });

		int[] check = new int[200000];
		Arrays.fill(check, Integer.MAX_VALUE);
		check[N] = 0;

		while (!queue.isEmpty()) {
			int[] q = queue.poll();
			System.out.println(q[0] + " " + q[1]);

			if (K == q[0]) { // 동생이 수빈이보다 왼쪽일때 수빈이는 순간이동을 할 수 없고 -1로만 이동해야한다.
				ans = Math.min(ans, q[1]);
			} else if (q[0] > K) {
				if (check[q[0]] > q[1] + q[0] - K) {
					check[q[0]] = q[1] + q[0] - K;
				}
				ans = Math.min(ans, check[q[0]]);
			} else {
				if (q[0] * 2 < 200000) {
					if (check[q[0] * 2] > q[1] + 1) {
						queue.add(new int[] { q[0] * 2, q[1] + 1 });
						check[q[0] * 2] = q[1] + 1;
					}
				}
				if (q[0] + 1 < 200000) {
					if (check[q[0] + 1] > q[1] + 1) {
						queue.add(new int[] { q[0] + 1, q[1] + 1 });
						check[q[0] + 1] = q[1] + 1;
					}
				}
				if (q[0] - 1 >= 0) {
					if (check[q[0] - 1] > q[1] + 1) {
						queue.add(new int[] { q[0] - 1, q[1] + 1 });
						check[q[0] - 1] = q[1] + 1;
					}
				}

			}
		}
		System.out.println(ans);
	}
}