package jungol.im;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main_1141_불쾌한날_scan {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/1141_불쾌한날.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] cows = new int[N];
		long sum = 0; // 가장 최악의 경우 80000부터 1까지 모두 더해야 하므로 int로 선언하면 범위를 초과
//		count는 최대 7999 이므로 int로 해도 상관없다.
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			cows[i] = sc.nextInt();
		}

		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				if(cows[i]>cows[j])
					cnt++;
				else break;
			}
		}
		System.out.println(cnt);
	}
}
