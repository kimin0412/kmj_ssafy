package jungol.im;

import java.util.Arrays;
import java.util.Scanner;

public class jungol_1810 {
	static int[] numbers = new int[7]; // 순열을 담을 배열
	static int sum;
	static int test_case;
	static int[] arr = new int[9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		sum100(0);
	}

	private static void sum100(int cnt) {
		if(cnt == 7) {
			sum = 0;
			for (int i = 0; i < 7; i++) {
				sum+=numbers[i];
//				System.out.println(Arrays.toString(numbers));
			}
			if(sum == 100) {
				System.out.println("!!!!!!!");
				System.out.println(Arrays.toString(numbers));
			}
			return;
		}
		
		top:
			for (int i = 0; i < 9; i++) {
//				동일한 데이터가 있는지 중복 검사
				for (int j = 0; j < cnt; j++) {  //배열번호
					if(numbers[j] == arr[i])
						continue top;
				}
				numbers[cnt] = arr[i];
				sum100(cnt+1);
			}
		
	}
}
