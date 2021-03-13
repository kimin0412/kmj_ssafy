package swmaestro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 두더지 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> maxDoo = new HashMap<Integer, Integer>();
		int timeLimit = 0;

		for (int i = 0; i < N * N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			for (int k = 0; k < K; k++) {
				int T = Integer.parseInt(st.nextToken());
				if (maxDoo.get(T) == null) {
					maxDoo.put(T, S);
				}
				else if(maxDoo.get(T) < S) {
					maxDoo.put(T, S);
				}
			}
		}

		int ans = 0;

		for (Integer i : maxDoo.keySet()) {
			ans += maxDoo.get(i);
		}

		System.out.println(ans);
	}

}