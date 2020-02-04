package jungol.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main_1141_불쾌한날_scan2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/1141_불쾌한날.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		//Integer.ParseInt(s) : 정수 포맷의 문자열을 정수로 변환시켜주는 함수
		int N = Integer.parseInt(in.readLine());
		int[] cows = new int[N];
		long cnt = 0;
		for (int i = 0; i < N; i++) {
			cows[i] = Integer.parseInt(in.readLine().trim());  //trim으로 양쪽 공백 잘라주기
		}
		int curCow = 0;
		for (int i = 0; i < N; i++) {
			curCow = cows[i];
			for (int j = i+1; j < N; j++) {
				if(curCow>cows[j])
					cnt++;
				else break;
			}
		}
		System.out.println(cnt);

	}
}
