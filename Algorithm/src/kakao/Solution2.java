package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Solution2 {
	public static int[] solution(String s) {
		int[] answer = {};
		int[] check = new int[100001];
		s = s.substring(1, s.length() - 1);
		int si = 0;
		int ei = 0;
		List<String> nums = new ArrayList<String>();

		for (int i = 0; i < s.length(); i++) {
			si = s.indexOf("{");
			ei = s.indexOf("}");
			nums.add(s.substring(si + 1, ei));
			s = s.substring(ei + 1);
		}
		nums.sort(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;
				else if (s1.length() == s2.length())
					return 0;
				else
					return 1;
			}
		});

		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			StringTokenizer st = new StringTokenizer(nums.get(i), ",");
			while (st.hasMoreTokens()) {
				int tmp = Integer.parseInt(st.nextToken());
				if (check[tmp] != 1) {
					temp.add(tmp);
					check[tmp] = 1;
				}
			}
		}

		answer = new int[temp.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = temp.get(i);
		}
		return answer;
	}

	public static void main(String[] args) {
//		int[][] list = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
//				{ 3, 5, 1, 3, 1 } };
//		int[] list2 = { 1, 5, 3, 5, 1, 2, 1, 4 };
		String ss = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(Arrays.toString(solution(ss)));
	}
}
