package programers;

import java.util.Arrays;

public class Solution_주식가격 {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
//		int[] res = { 4, 3, 1, 1, 0 };
		System.out.println(Arrays.toString(solution(prices)));
	}

	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];

		int cnt = 0;

		for (int i = 0; i < prices.length; i++) {
			if (i != 0)
				answer[i - 1] = cnt;
			cnt = 0;
			for (int j = i + 1; j < prices.length; j++) {
				if (j == prices.length - 1) {
					cnt = j - i;
					break;
				}
				if (prices[i] <= prices[j]) {
					continue;
				} else {
					cnt = j - i;
					break;
				}
			}
		}
		return answer;
	}
}
