package 염라;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *	정렬 - 우선순위
 *	중복을 제거
 *	
 *	선택정렬 O[N^2] 시간이 터짐
 *	API 정렬 O[NlogN] : 3100ms, 중복을 직접 제거
 */
public class Solution2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt(); // 1~50
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = sc.nextInt(); // 이름의 개수 1~20,000
			
			String[] name = new String[N];
			for (int i = 0; i < N; i++) {
				name[i] = sc.next();
			}
			
			Arrays.sort(name, new Comparator<String>() {
				public int compare(String pre, String next) {
					if (pre.length() != next.length()) { // 글자의 길이 짧은순서
						return pre.length() - next.length();
					} else { // 길이가 같으면, 사전순
						return pre.compareTo(next); // 오름차순
					}
				}
			});
			
//			System.out.println(Arrays.toString(name));
			// 중복제거
			System.out.println("#"+testCase);
			
			String temp = null;
			for (int i = 0; i < name.length; i++) {
				if (!name[i].equals(temp)) {
					System.out.println(name[i]);
				}
				temp = name[i];
			}
		} // end of testCase
	} // end of main
} // end of class
