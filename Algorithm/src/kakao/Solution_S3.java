package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_S3 {
	public static int[] solution(String[] gems) {
		int[] answer = new int[2];
		int gemCnt = 0;
		List<int[]> pos = new ArrayList<>();
		List<String> gemsName = new ArrayList<String>();
		for (int i = 0; i < gems.length; i++) {
			if (!gemsName.contains(gems[i])) {
				pos.add(new int[] {i, i});
				gemCnt++;
				gemsName.add(gems[i]);
			}
			else {
				pos.get(gemsName.indexOf(gems[i]))[1] = i;
			}
		}
		for (int[] p : pos) {
			System.out.println(Arrays.toString(p));
		}
		
		if (gemCnt == 1) {
			answer[0] = 1;
			answer[1] = 1;
			return answer;
		}
		int sIndex = 0;
		int eIndex = 0;
		int min = Integer.MAX_VALUE;
		top: for (int i = 0; i < gems.length; i++) {
			List<String> gemCheck = new ArrayList<String>();
			int cnt = 1;
			if (gems.length - i < gemCnt) {
				break;
			}
			for (int j = i; j < gems.length; j++) {
				if (min <= gemCheck.size()) {
					break;
				}
				gemCheck.add(gems[i]);

				if (!gemCheck.contains(gems[j])) {
					cnt++;
				}
				gemCheck.add(gems[j]);

				if (cnt == gemCnt) {
					if (min > gemCheck.size()) {
						eIndex = j + 1;
						min = gemCheck.size();
						sIndex = i + 1;
					}
					break;
				}
			}
		}
		answer[0] = sIndex;
		answer[1] = eIndex;
		return answer;
	}

	public static void main(String[] args) {
		String[] gems1 = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		String[] gems2 = { "AA", "AB", "AC", "AA", "AC" };
		String[] gems3 = { "XYZ", "XYZ", "XYZ" };
		String[] gems4 = { "ZZZ", "YYY", "NNNN", "YYY", "BBB" };
		System.out.println(Arrays.toString(solution(gems1)));
		System.out.println();
		System.out.println(Arrays.toString(solution(gems2)));
		System.out.println();
		System.out.println(Arrays.toString(solution(gems3)));
		System.out.println();
		System.out.println(Arrays.toString(solution(gems4)));
		System.out.println();
	}

}
