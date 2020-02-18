package com.ssafy.sort;

import java.util.Arrays;

public class QuickSortTest {

	public static void main(String[] args) {
//		int[] data = { 69, 10, 30, 2, 16, 8, 31, 22 };
//		int[] data = {1, 2, 3, 4, 5};
//		int[] data = {5, 4, 3, 2, 1};
		int[] data = {9, 1, 7, 5, 3, 4, 8, 6};
		quickSort(data, 0, data.length-1);
		System.out.println(Arrays.toString(data));
	}

	private static void quickSort(int[] data, int begin, int end) {
		//begin이 end와 같거나 커지면 더이상 원하는 데이터(작은값, 큰값)을 찾을 수 없는 상황
		if(begin < end) {
			int p = begin, left = begin+1, right = end, temp;
			do {
				//왼쪽부터 피복 값보다 큰 값을 찾는다.
				//피봇 보다 값이 작으면 패스, 크면 while문 중단
				while(left < end && data[left] < data[p]) left++;

				//오른쪽부터 피복 값보다 작은 값을 찾는다.
				//피봇 보다 값이 작으면 패스, 크면 while문 중단
				while(right > p && data[right] >= data[p]) right--;
				
				//피봇 보다 작으면 왼쪽, 크면 오른쪽으로 이동
				if(left < right) {
					temp = data[left];
					data[left] = data[right];
					data[right] = temp;
				}
			}while(left<right);
			
			//피봇 보다 작은값, 큰값을 더이상 발견하지 못한다면 피봇을 이동시켜 피봇은 고정
			temp = data[p];
			data[p] = data[right];
			data[right] = temp;
			
			//다시 왼쪽 정렬
			quickSort(data, begin, right-1);  //피봇의 위치가 정해져서 right-1
			
			//오른쪽 정렬
			quickSort(data, right+1, end);  //피봇의 위치가 정해져서 right+1
			
		}
	}
	
}
