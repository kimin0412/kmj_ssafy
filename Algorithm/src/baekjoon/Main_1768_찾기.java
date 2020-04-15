package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
 ABC ABCDAB ABCDABCDABDE
 ABCDABD

 */
public class Main_1768_찾기 {
	static int cnt;
	static List<Integer> arr;
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
					cnt++;
					arr.add(i-pattern.length() + 2);
					j = pi[j];
				}
				else {
					j++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String origin = br.readLine();
		String pattern = br.readLine();
		cnt = 0;
		arr = new ArrayList<>();
		KMP(origin, pattern);
		System.out.println(cnt);
		for (int a : arr) {
			System.out.println(a);
		}
	}

}
