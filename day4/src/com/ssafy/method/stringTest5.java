package com.ssafy.method;

import java.util.Arrays;
import java.util.Scanner;

public class stringTest5 {

	public static void main(String[] args) {
		String[] msg = { "kim", "park", "lee", "kang", "choi" };
		
		String a = "ABDrrr";
		String b = "ABDzfrr";
		
		int result = a.compareTo(b);
		System.out.println(result);
		
//		ABD랑 ABC랑 비교할때 ABD에서 ABC를 뺀다. 앞에서부터 하나씩 빼가다가 0이 아닌수를 만나면 1을 리턴 한다.
//		-값이 나왔다면 위값보다 아래값이 더 크다. 위값<아래값
		for (int i = 0; i < msg.length-1; i++) {
			if(msg[i].compareTo(msg[i+1]) <= 0) {
				String tmp = msg[i];
				msg[i] = msg[i+1];
				msg[i+1] = tmp;
			}
		}
		
        ///////////////////////////////////////////////////
		//   선택정렬
		for (int i = 0; i < msg.length-1; i++) {  //기준위치
			//1. 가장 작은 값, 작은값의 위치 찾기
			String min = msg[i];
			int minp = i;
			for (int j = i+1; j < msg.length; j++) {
				if(min.compareTo(msg[j]) > 0) {
					min = msg[j];
					minp = j;
				}
			}
			//2. 작은값과 i번째 값을 교체
			msg[minp] = msg[i];
			msg[i] = min;
		}
		
//		Arrays.sort(msg);
		for (String str : msg) {
			System.out.println(str);
		}
		
	}
}
