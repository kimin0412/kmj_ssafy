package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 정렬 - 우선순위 
 * 중복을 제거 
 * 선택 정렬 O[N^2] 시간이 터짐 
 * API 정렬 O[NlogN] : 3,100ms, 중복을 직접 제거 
 * 중복제거를 TreeSet 자료구조 O[NlogN] : 2,900ms
 */
public class Solution_7701_염라대왕의이름정렬3 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/7701_염라대왕의이름정렬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim()); // 이름의 개수 1~20,000

			TreeSet<String> name = new TreeSet<>(new Comparator<String>() {
				@Override
				public int compare(String pre, String next) {
					if (pre.length() != next.length()) { // 글자의 길이 짧은 순서
						return pre.length() - next.length();
					} else { // 길이가 같으면, 사전순
						return pre.compareTo(next); // 오름차순
					}
				}
			});
			
			for (int i = 0; i < N; i++) {
				name.add(br.readLine()); // 중복 자동 제거 
			}

			System.out.println("#" + tc);
			for (String s : name) {
				System.out.println(s);
			}
		}// end of tc
	}// end of main
}
