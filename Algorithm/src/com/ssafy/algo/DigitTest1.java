package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class DigitTest1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[10];
		Arrays.fill(arr, 0);
		while(true) {
			int a = sc.nextInt();
			if(a == 0) break;
			a/=10;
			arr[a]++;
		}
		for (int i = 0; i < 10; i++) {
			if(arr[i] !=0)
				System.out.println(i+" : " + arr[i]+ "개");
		}
	}
}
