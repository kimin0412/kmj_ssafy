package com.ssafy.permutation;

public class Permutation_For {

	public static void main(String[] args) {
		int n = 3;
		int cnt = 0;
		System.out.println("중복 순열");
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					cnt++;
					System.out.printf("%d %d %d\n", i, j, k);
				}
			}
		}
		System.out.println("중복 순열의 개수 : "+ cnt);
		
		
		cnt = 0;
		System.out.println("\n순열");
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i != j) {
					for (int k = 1; k <= n; k++) {
						if(i!=k && j !=k) {
							cnt++;
							System.out.printf("%d %d %d\n", i, j, k);
						}
					}
				}
			}
		}
		System.out.println("순열의 개수 : "+ cnt);
	}
}
// 재귀 호출 사용해서 할 수 있다.

