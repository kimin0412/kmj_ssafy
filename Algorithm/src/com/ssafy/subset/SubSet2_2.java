package com.ssafy.subset;

import java.util.Arrays;

public class SubSet2_2 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] arr= {3, 6, 7, 1, 5, 2};
//		int[] arr= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21};
		int n = arr.length;
		int[] select = new int[n];
		int[][] subset = new int[1<<n][n];
		/* subset의 개수는 2의 n승개 만큼 나오기때문에 
		 * size  : 1<<n
		 * O(1<<n)  >n이 20까지는 1초안에  구할 수 있다. 
		 *  */
		for (int i = 0, size =1<<n ; i <size; i++) {
			for (int j = 0; j <n; j++) {
				if((i & 1<<j ) !=0) {
//					System.out.print(j+" ");
//					System.out.print(arr[j]+" ");
					select[j] = 1;
//					select[j] = arr[j];
				}
			}
			subset[i] = Arrays.copyOf(select, n);
//			subset[i] = select;   //레퍼런스이므로 맨 마지막 조합만 유지한다. 반드시 카피로 해야함.
			Arrays.fill(select, 0);
//			System.out.println(Arrays.toString(select));
		}
		for (int[] s : subset) {
			System.out.println(Arrays.toString(s));
		}
		long end= System.currentTimeMillis();
		System.out.println(end-start);
	}
}

