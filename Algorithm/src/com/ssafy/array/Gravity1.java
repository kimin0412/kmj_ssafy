package com.ssafy.array;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Gravity1 {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/Gravity.txt"));
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int answer = 0;
		int[] box = new int[N];
		for (int i = 0; i <N; i++) {
			box[i] = scan.nextInt();
		}
		int count = 0;
		for (int i = 0; i <N; i++) {
			count = N - (i +1); 	   //오른 쪽으로 돌면 맵 크기 N에서 box의 index +1를 빼면 해당 박스의 최대 낙차
			for (int j = i+1; j <N; j++) {
				if(box[j] >= box[i]) { //현재 박스와 같은 높이거나 더 높이면 쌓여하 하므로 최대 낙차에서 뺀다. 
					count--;
				}
			}
			answer = Math.max(count, answer);
		}
		System.out.println("answer : "+answer);
	}
}






