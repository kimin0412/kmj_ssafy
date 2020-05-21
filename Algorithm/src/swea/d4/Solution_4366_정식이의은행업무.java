package swea.d4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4366_정식이의은행업무 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			long ans = 0;
			String s1 = br.readLine().trim();
			String s2 = br.readLine().trim();

			char[] char1 = s1.toCharArray();
			char[] char2 = s2.toCharArray();

			top: for (int i = 0; i < s1.length(); i++) {
				if (char1[i] == '0')
					char1[i] = '1';
				else
					char1[i] = '0';
				long digit = convert(char1, 2);
				for (int j = 0; j < char2.length; j++) {
					for (char k = '0'; k < '3'; k++) {
						char tmp = char2[j];
						if (char2[j] != k) {
							char2[j] = k;
							if (digit == convert(char2, 3)) {
								ans = digit;
								break top;
							}
							char2[j] = tmp;// 원복
						}
					}
				}
				if (char1[i] == '0')
					char1[i] = '1';
				else
					char1[i] = '0';
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static long convert(char[] chars, int digits) {
		long num = 0;
		int j = chars.length - 1;
		for (int i = 0; i < chars.length; i++) {
			num += (chars[i] - '0') * (Math.pow(digits, j));
			j--;
		}
		return num;
	}
}
