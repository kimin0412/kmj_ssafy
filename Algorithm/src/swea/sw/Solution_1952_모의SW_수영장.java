package swea.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_모의SW_수영장 {
	static int[] price;
	static int[] plan;
	static int maxPrice;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/1952_모의SW_수영장.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			price = new int[4];
			plan = new int[12];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 12; i++) {
				plan[i] = Integer.parseInt(st.nextToken());
			} // 입력 끝

			maxPrice = price[3];
			dfs(0, 0);
			System.out.println("#" + tc + " " + maxPrice);
		}
	}

	private static void dfs(int month, int sum) {
		if (month >= 12) {
			maxPrice = Math.min(maxPrice, sum);
			return;
		}
		if (plan[month] == 0) {
			dfs(month + 1, sum); // 이용 안하는 달은 넘어감
		} else {
			dfs(month + 1, sum + (plan[month] * price[0])); // 1일권
			dfs(month + 1, sum + price[1]); // 1달권
			dfs(month + 3, sum + price[2]); // 3개월권
		}
	}
}
