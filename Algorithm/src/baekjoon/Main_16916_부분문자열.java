package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 baekjoon
 aek
 bak
 joo
 oone
 online
 baekjoon
 
 <ans>
 1
 0
 1
 0
 0
 1
 
 */
public class Main_16916_부분문자열 {
	static int[] getPi(String pattern) {
		int[] pi = new int[pattern.length()];
		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			
			if (pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
//
//			else {
//				while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
//					j = pi[j - 1];
//				}
//			}
		}
		return pi;
	}

	static void KMP(String origin, String pattern) {
		int[] pi = getPi(pattern);
		boolean flag = false;
		int j = 0;
		for (int i = 0; i < origin.length(); i++) {
			while (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if(origin.charAt(i) == pattern.charAt(j)) {
				if(j == pattern.length() - 1) {
					flag = true;
//					System.out.println((i-pattern.length() + 1));
//					System.out.println(j);
					j = pi[j];
				}
				else {
					j++;
				}
			}
		}
		System.out.println(flag == true ? "1" : "0");
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		KMP(origin, pattern);
	}
}
