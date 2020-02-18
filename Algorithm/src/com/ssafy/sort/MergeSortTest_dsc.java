package com.ssafy.sort;

import java.util.Arrays;

/**
 * 분할 정복을 이용한 Merge Sorting 
 * 최악시간 복잡도 O(nlogn) 
 * 평균시간 복잡도 O(nlogn)
 * 
 * 1. 데이터를 반씩 분할 -> 원소가 한 개가 될때까지 분할 
 * 2. 병합
 */
public class MergeSortTest_dsc {
	// 두 그룹의 데이터를 병합하면서 정렬할 때 사용할 임시 배열, 정렬한 데이터 크기만큼 선언
	static int[] sorted;

	public static void main(String[] args) {
		int[] data = { 69, 10, 30, 2, 16, 8, 31, 22 };
		int size = data.length;
		sorted = new int[size];
		System.out.println(Arrays.toString(data));
		System.out.println("정렬시작");
		mergeSort(data, 0, size - 1);
	}

	private static void mergeSort(int[] data, int start, int end) {
		if (start < end) { // start == end가 같은건 원소가 하나 남았다는것
			// 1. 데이터를 반씩 분할 -> 원소가 한개가 될때까지 분할
			int mid = (start + end) >> 1;
			mergeSort(data, start, mid);
			mergeSort(data, mid+1, end);
			//2. 병합
			merge(data, start, mid, end);
		}
	}

	private static void merge(int[] data, int s, int mid, int n) {
		// 임시로 정렬한 데이터를 원래 배열(data[]에 옮길때 s, n값을 사용하므로 s와 n 변수가 변하면 안됨.
		int start = s, end = n, next = mid + 1, k = s;

		//두 집합 중에 작은 값들은 임시 배열에 저장
		while (start <= mid && next <= end) {
			if (data[start] >= data[next]) { //여기 부호 바뀌면 오름차순, 내림차순 가능
				sorted[k] = data[start++];
			} else {
				sorted[k] = data[next++];
			}
			k++;
		}
		
		//임시로 정렬된 sorted 배열에 반대편 데이터를 옮겨 놓는다.
		if(start > mid) {
			for (int i = next; i <= n; i++, k++) {
				sorted[k] = data[i];
			}
		}else {
			for (int i = start; i <= mid; i++, k++) {
				sorted[k] = data[i];
			}
		}
		
		//임시로 정렬된 데이터를 원래 배열에 옮기기
		for (int i = s; i <= n; i++) {
			data[i] = sorted[i];
		}
		System.out.println("합병정렬 >> ");
		System.out.println(Arrays.toString(data));
	}
}
