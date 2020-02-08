package D2;

import java.util.Arrays;
import java.util.Scanner;

public class _D2_1959 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] arr1 = new int[20];
			int[] arr2 = new int[20];
			int[] sum = new int[20];
			int len1 = 0, len2 = 0, n;
			Arrays.fill(sum, 0);

			for (int i = 0; i < arr2.length; i++) {
				arr1[i] = sc.nextInt();
				if((char)arr1[i] == '\n') {
					len1 = i-1;
					break;
				}
			}
			for (int i = 0; i < arr2.length; i++) {
				arr2[i] = sc.nextInt();
				if((char)arr2[i] == '\n') {
					len2 = i-1;
					break;
				}
			}
			
			if(len1>len2) {
				n = len1-len2+1;
				for (int i = 0; i < n; i++) {
//					arr1
				}
			}
			else {
				n = len2-len1+1;
			}
			
				
			
//			String s1;
//			String s2;
//			char[] arr1 = new char[20];
//			char[] arr2 = new char[20];
//			s1 = sc.nextLine();
//			s2 = sc.nextLine();
//			arr1 = s1.toCharArray();
//			arr2 = s2.toCharArray();
//			
			
			
			
		}
	}
}
