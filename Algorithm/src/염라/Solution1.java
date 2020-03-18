package 염라;

import java.util.Scanner;

/**
 *	정렬 - 우선순위
 *	중복을 제거
 *	시간이 터짐
 *	선택정렬 O[N^2]
 */
public class Solution1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt(); // 1~50
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = sc.nextInt(); // 이름의 개수 1~20,000
			
			String[] name = new String[N];
			for (int i = 0; i < N; i++) {
				name[i] = sc.next();
			}
			// 선택정렬 - 우선순위
//			0~끝 : name[0] <-> name[minIndex]
//			1~끝 : name[1] <-> name[minIndex]
			
//			끝~끝 : name[끝] <-> name[minIndex]
			for (int i = 0; i < name.length; i++) { // 범위의 시작값
				int minIndex = i; // 최소값의 방번호
				for (int j = i; j < name.length; j++) { // 범위 i~끝
					if (compare(name[minIndex], name[j]) > 0) { // 최소값이라면, 앞쪽에 배치해야된다면
						minIndex = j; // 최소값 인덱스 기억
					}
				}
				// swap name[i] <-> name[minIndex]
				String temp = name[i];
				name[i] = name[minIndex];
				name[minIndex] = temp;
			}
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
	/** 바꿔야된다면,(next 앞으로 가야한다면) 양수를 리턴 */
	public static int compare(String pre, String next) {
		if (pre.length() != next.length()) { // 글자의 길이 짧은순서
			return pre.length() - next.length();
		} else { // 길이가 같으면, 사전순
			return pre.compareTo(next); // 오름차순
		}
	}
} // end of class
