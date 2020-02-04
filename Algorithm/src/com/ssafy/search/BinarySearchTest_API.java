package com.ssafy.search;

import java.util.Arrays;

public class BinarySearchTest_API {

	public static void main(String[] args) {
		int[] datas = {3,1,2,5,6,4,8,7,9};
		
/*		Arrays.binarySearch(배열, 값)
 * 		  - 값이 배열에 몇번째 index에 위치하는지 찾아주는 함수
 * 		  - 정렬되어 있지 않은 배열은 index를 찾지 못하므로 -1을 리턴한다.
 */
		Arrays.sort(datas);
		System.out.println(Arrays.toString(datas));
		System.out.println(Arrays.binarySearch(datas, 4));
		
	}

}
