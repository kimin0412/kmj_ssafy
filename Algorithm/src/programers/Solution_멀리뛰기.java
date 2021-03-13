package programers;

public class Solution_멀리뛰기 {
	public static void main(String[] args) {
		int[] ns = { 4, 3, 2000 };
		for (int i = 0; i < ns.length; i++) {
			System.out.println(solution(ns[i]));
		}
	}

	static long cnt = 0;

	public static long solution(int n) {
		cnt = 0;

		solve(n);

		return cnt % 1234567;
	}

	private static void solve(int remain) {
		if (remain == 1) {
			cnt++;
			return;
		} else if (remain == 0) {
			cnt++;
			return;
		} else {
			solve(remain - 1);
			solve(remain - 2);
		}
	}
}
