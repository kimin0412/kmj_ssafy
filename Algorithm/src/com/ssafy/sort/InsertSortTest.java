package com.ssafy.sort;

import java.util.Arrays;

public class InsertSortTest {

	public static void main(String[] args) {
		int n = 1000;
		int[] data = new int[n];
		for (int i = 0; i < n; i++) {
//			Math.random() 0<= x <1의 랜덤 데이터 발생
//			0<= x <1000 범위의 랜덤 데이터 발생
			data[i] = (int)(Math.random()*1000);
//			자바의 클래스 중에 랜덤데이터 뽑아주는 메서드도 있음
		}
		System.out.println(Arrays.toString(data));
		InsertSort(data, data.length);
		System.out.println(Arrays.toString(data));
	}

	private static void InsertSort(int[] data, int size) {
		int standard;  //정렬될 데이터
		int target;    //비교할 데이터의 index
		//1. 배열 전체를 반복 시켜서 
		for (int i = 1; i < size; i++) {
			standard = data[i];
			target = i-1;
			//2. 정렬될 데이터를 정렬될 데이터의 위치-1 부터 0번째 위치까지 반복해서
			while(target>=0 && standard <data[target]) {
				//3. 비교 데이터가 standard보다 작으므로 뒤로 이동
				data[target+1] = data[target];
				target--;
			}
			//정렬될 위치에 standard저장
			data[target+1] = standard;
		}
		
	}

}
