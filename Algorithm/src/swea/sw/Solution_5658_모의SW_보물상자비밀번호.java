package swea.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5658_모의SW_보물상자비밀번호 {
	static int N, K;
	static LinkedList<Character> hexa;
	static int n;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/5658_모의SW_보물상자비밀번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			hexa = new LinkedList<>();
			int nn = N / 4;

			String line = br.readLine();
			for (int i = 0; i < N; i++) {

				char a = line.charAt(i);
				hexa.offer(a);
			}

			List<String> arr = new ArrayList<String>();

			for (int i = 0; i < nn; i++) {
				String tmp = "";
				for (int j = 0; j < N; j++) {
					tmp += hexa.get(j);
					if (j % nn == nn - 1) {
						boolean flag = true;
						if (arr.contains(tmp)) {
							flag = false;
							tmp = "";
							continue;
						}

						if (flag == true) {
							arr.add(tmp);
							tmp = "";
						}
					}
				}
				char c = hexa.pollLast();
				hexa.offerFirst(c);
			}

			Collections.sort(arr);
			long ans = 0;
			for (int i = 0; i < nn; i++) {
				char c = arr.get(arr.size() - K).charAt(nn - i - 1);
				int a;
				if (Character.isAlphabetic(c)) {
					a = (int) c - 55;
				} else {
					a = (int) c - 48;
				}
				ans += a * Math.pow(16, i);

			}
			System.out.println("#" + tc + " " + ans);
		}
	}
}
