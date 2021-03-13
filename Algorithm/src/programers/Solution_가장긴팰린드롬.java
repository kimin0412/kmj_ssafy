package programers;

public class Solution_가장긴팰린드롬 {
	public static void main(String[] args) {
		String[] s = { "abcdcba", "abacde", "abcabcdcbae", "aaaa", "abcde", "a", "abcbaqwertrewqq", "abcbaqwqabcba",
				"abba", "abaabaaaaaaa" };
		for (int i = 0; i < s.length; i++) {
			System.out.println(solution(s[i]));
			System.out.println("================");
		}
//		7, 3, 7, 4, 1, 1, 9, 13, 4, 7
	}

	public static int solution(String s) {
		int max = 1;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				StringBuffer part = new StringBuffer(s.substring(i, j + 1));
				System.out.println(part);
				if (part.length() % 2 == 0) { // 검사할 문자열 길이가 짝수면
					String left = new StringBuffer(s.substring(0, part.length() / 2)).toString();
					String right = new StringBuffer(s.substring(part.length() / 2, part.length())).reverse().toString();
					System.out.println(left);
					System.out.println(right);
					if (left.equals(right)) {
						max = Integer.max(max, part.length());
					}

				} else {
					String left = new StringBuffer(s.substring(0, part.length() / 2)).toString();
					String right = new StringBuffer(s.substring(part.length() / 2 + 1, part.length())).reverse()
							.toString();
					System.out.println(left);
					System.out.println(right);
					if (left.equals(right)) {
						max = Integer.max(max, part.length());
					}
				}
				System.out.println();
			}
		}

		return max;
	}
}
