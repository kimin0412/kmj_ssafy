package com.ssafy.algo;

import java.util.Arrays;

public class CountingSort {

	public static void main(String[] args) {
		int[] arr = {5,5,4,1,0,2,3,5,4,6,2,1,1,2,5,5,5,3,3,3};
		int[] cnt = new int[6];
		int[] arr2 = new int[20];		
		Arrays.fill(cnt, 0);
		
		for (int i = 0; i < arr.length; i++) {
			cnt[arr[i]]++;
		}
		
		int c = 0;
		for (int i = 0; i < arr2.length; i++) {
			
		}
		
	}

}
