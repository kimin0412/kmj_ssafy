package swea.d3;

import java.util.ArrayList;
import java.util.Scanner;

class Solution_D3_4406_모음이보이지않는사람 {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			ArrayList a = new ArrayList();
			String s = sc.next();

			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
					continue;
				else {
					a.add(c);
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < a.size(); i++) {
				System.out.print((char) a.get(i));
			}
			System.out.println();
		}
	}
}
