package programers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_프린터 {
	public static void main(String[] args) {
		int[][] priorities = { { 2, 3, 1, 4, 5, 9, 6, 7 }, { 2, 1, 3, 2 }, { 1, 1, 9, 1, 1, 1 }, { 2, 2, 2, 1, 3, 4 } };
		int[] location = { 3, 2, 0, 3 };

		System.out.println(solution(priorities[0], location[0]));
		System.out.println(solution(priorities[1], location[1]));
		System.out.println(solution(priorities[2], location[2]));
		System.out.println(solution(priorities[3], location[2]));
	}

	public static int solution(int[] priorities, int location) {
		List<Integer> prio = new ArrayList<Integer>();
		for (int i = 0; i < priorities.length; i++) {
			prio.add(priorities[i]);
		}

		int idx = location;
		int cnt = 1;

		while (true) {
			if (prio.isEmpty()) {
				cnt--;
				break;
			}
			int p = prio.get(0);
			if (p < Collections.max(prio)) {
				prio.remove(0);
				prio.add(p);
				if (idx == 0) {
					idx = prio.size() - 1;
				} else
					idx--;
			} else {
				prio.remove(0);
				if (idx == 0) {
					return cnt;
				} else {
					idx--;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
