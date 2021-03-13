package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질_정답 {
	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int visit[] = new int[100001];

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		visit[N] = 1;

		while (!q.isEmpty()) {
			N = q.poll();
			if (N == K)
				break;
			if (N + 1 <= 100000 && visit[N + 1] == 0) {
				q.add(N + 1);
				visit[N + 1] = visit[N] + 1;
			}
			if (N - 1 >= 0 && visit[N - 1] == 0) {
				q.add(N - 1);
				visit[N - 1] = visit[N] + 1;
			}
			if (N * 2 <= 100000 && visit[N * 2] == 0) {
				q.add(N * 2);
				visit[N * 2] = visit[N] + 1;
			}
		}
		System.out.println(visit[K] - 1); // 0이 아닌 1에서 시작 해서 -1해주기

	}
}