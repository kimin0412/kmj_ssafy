package programers;

import java.util.ArrayList;
import java.util.List;

public class Solution_두개뽑아서더하기 {
	public static void main(String[] args) {
		int[][] numbers = { { 2, 1, 3, 4, 1 }, { 5, 0, 2, 7 } };
//		int[][] res = { { 2, 3, 4, 5, 6, 7 }, { 2, 5, 7, 9, 12 } };
		System.out.println(solution(numbers[0]));
		System.out.println(solution(numbers[1]));
	}

	public static List<Integer> solution(int[] numbers) {
		List<Integer> answer = new ArrayList<Integer>();
		boolean[] check = new boolean[10010];

		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers.length; j++) {
				if (i == j)
					continue;
				check[numbers[i] + numbers[j]] = true;
			}
		}
		for (int i = 0; i < check.length; i++) {
			if (check[i] == true)
				answer.add(i);
		}
		return answer;
	}
}
