package hw;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class jungol_1811_ {
	static int target = 100;
	static int n = 9;
	static int r = 7;
	static int[] numbers;   //난쟁이 값을 저장할 배열
	static int[] result;    //난쟁이 7명에 대한 조합을 저장할 배열
	
	public static void main(String[] args) {
//		System.setIn(new FileInputStream("res/jungol/bank/1810_백설공주.txt"));
		Scanner sc = new Scanner(System.in);
		
		numbers = new int[n];
		result = new int[r];
		
		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}
		combination(0, 0, 0);
	}

	/**
	 * 난쟁이 조합을 구할 함수
	 * @param cnt    배열 번호
	 * @param start  조합의 시작 수
	 * @param sum    cnt번째까지의 난쟁이 모자 숫자 함
	 */
	private static void combination(int cnt, int start, int sum) {
		if(cnt==r) {
			if(sum == target) {
				for(int s : result) {
					System.out.println(s);
				}
			}
			return;
		}
		for (int i = start; i < n; i++) {
			result[cnt] = numbers[i];
			combination(cnt+1, i+1, sum+result[cnt]);
		}
	}
		
}
