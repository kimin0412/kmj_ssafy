package com.ssafy.combination;

import java.lang.Character.Subset;
import java.util.Arrays;

public class CombinationTest2 {
	public static void main(String[] args) {
		int[] arr = {3, 6, 7, 1, 5, 2};
//		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
		int n = arr.length;
		int[] select = new int[n];
		int[][] subset = new int[n][n];
		
//		서브셋은 2의 n승개가 나온다.
//		여기선 2의 5승 개
//		System.out.println(1<<n);
		/* subset의 개수는 2의 n승개 만큼 니오기 때문에
		 * size : 1<<n
		 * O(1<<n) : n이 20까지는 1초안에 무난하게 구할 수 있다. 
		 * 16개 까지는 괜찮다! 17개도 코딩 잘하면 괜찮다!
		 * */
		for (int i = 0, size = 1<<n; i < size; i++) { //O(1<<n)
			for (int j = 0; j < n; j++) { //선택하냐 안하냐이기 때문에 n개만큼 돌림
				if((i & 1<<j) != 0) {
//					System.out.print(j + " ");
					System.out.print(arr[j] + " ");
				}
			}
			subset[i] = Arrays.copyOf(select, n);
//			System.out.println();
		}
		long end = System.currentTimeMillis();
//		이 포문 달달 외워라 -> 서브셋 구하기 기본   A마을 B마을이 각각 연결되는지,.,, -> 이해가 됐다면 외워라 
//		dfs, bfs 등등
	}
}
