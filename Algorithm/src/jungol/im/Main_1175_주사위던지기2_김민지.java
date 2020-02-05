package jungol.im;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1175_주사위던지기2_김민지 {
	static int n, m;
	static int[] numbers ; // 순열을 담을 배열

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		m = sc.nextInt();
		
		
		numbers = new int[n];
		
		permutation(0);
	}

	private static void permutation(int cnt) {
		if(cnt==n) {  //nㅠr이라면 여기가 r로 바뀌면 됨
//			test_case++;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += numbers[i];
			}
			if(sum == m) {
				for (int i = 0; i < n; i++) {
					System.out.print(numbers[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = 1; i <= 6; i++) {
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}

}
