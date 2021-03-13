package programers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_기능개발 {
	public static void main(String[] args) {
		int[][] progresses = { { 93, 30, 55 }, { 95, 90, 99, 99, 80, 99 } };
		int[][] speeds = { { 1, 30, 5 }, { 1, 1, 1, 1, 1, 1 } };
		System.out.println(Arrays.toString(solution(progresses[0], speeds[0])));
		System.out.println(Arrays.toString(solution(progresses[1], speeds[1])));
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] day = new int[progresses.length];
		for (int i = 0; i < progresses.length; i++) {
			int remain = 100 - progresses[i];
			if (remain % speeds[i] == 0) {
				day[i] = remain / speeds[i];
			} else {
				day[i] = remain / speeds[i] + 1;
			}
		}

		List<Integer> arr = new ArrayList<Integer>();
		int first = day[0];
		int cnt = 1;
		for (int i = 1; i < day.length; i++) {
			if (first >= day[i]) {
				cnt++;
			} else {
				arr.add(cnt);
				cnt = 1;
				first = day[i];
			}
		}
		arr.add(cnt);
		
		int[] answer = new int[arr.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr.get(i);
		}
		return answer;

	}
}
