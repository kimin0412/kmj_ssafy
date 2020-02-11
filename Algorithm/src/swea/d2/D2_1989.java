package swea.d2;

import java.util.Arrays;
import java.util.Scanner;

public class D2_1989 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String s;
			char[] cs = new char[10];
			boolean flag = true;
			s = sc.next();
			cs = s.toCharArray();
			for (int i = 0; i < s.length()/2; i++) {
				if(cs[i] != cs[s.length()-i-1])
					flag = false;
			}
			if(flag == true) System.out.println("1");
			else System.out.println("0");
		}
		
	}
}
