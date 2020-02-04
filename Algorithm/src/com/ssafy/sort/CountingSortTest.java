package com.ssafy.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountingSortTest {

	public static void main(String[] args) {
		int[] data = { 0, 4, 1, 3, 1, 2, 4, 1};
		int n= data.length;
		int[] temp = new int[n];
		
		//int max = -1;   //배열의 인덱스라 최솟값으로
		int max = Integer.MIN_VALUE;   //배열의 인덱스라 최솟값으로
		//System.out.println(max);
		
//		Step1. max값 찾기 및 카운트 배열 생성
		for (int d : data) {
			max = Math.max(max, d);
		}
		
		//0~max까지 저장하기 위해 max+1개의 카운트 배열 생성
		int[] counts = new int[max+1];  //max까지 저장해야 하므로 +1한 배열의 크기
		
//		Step2. 데이터 개수 세기
		for (int d : data) {  //데이터가 count배열의 index로 활용해서 해당 인덱스에 증가
			counts[d]++;
		}		
		
//		Step3. count 배열에 값을 누적하기 - 앞의 값과 현재 값을 더해서 현재 index에 누적
		for (int i = 1; i <= max; i++) {  //counts.length = max이다.
			counts[i] += counts[i-1];
		}
		System.out.println(Arrays.toString(counts));
		
//		Step4. 데이터 배열과 count 배열을 이용해서 정렬하기
		int idx = -1;
		int d;
		//데이터 배열의 맨 끝에 있는 데이터 부터 정렬하기
		for (int i = n-1; i >= 0; i--) {  //data 배열을 기준으로 돌아간다.
			//idx = --counts[data[i]];
			d = data[i]; 		//데이터는 count 배열의 index
			idx = --counts[d];  //정렬할 temp 배열의 index
			temp[idx] = data[i];
		}
		
//		=> 총 4n 이므로 시간복잡도는 n이 되고, 공간복잡도는 k가 되므로 최종 복잡도는 O(n+k).
//		공간 복잡도가 너무 커지면 k를 무시할 수 없게 된다.
		
		
		System.out.println(Arrays.toString(temp));
	}

}
