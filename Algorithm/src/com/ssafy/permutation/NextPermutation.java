package com.ssafy.permutation;

import java.util.Arrays;

//이걸로 조합 순열 다 사용 가능하다.
public class NextPermutation {
//	static int[] p = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0}; //12개 중에 9개를 선택하겠다.
	static int[] p = {1, 2, 3, 0, 0}; //5개 중에 3개를 선택하겠다.
	
	public static void main(String[] args) {
		long stime = System.currentTimeMillis();
		int size = p.length-1;
		do {
			System.out.println(Arrays.toString(p));
		}while(np(size));
		long etime = System.currentTimeMillis();
		System.out.printf("%dms", etime-stime);
	}
	
	private static boolean np(int size) {
		int i = size;
		//교차점
		while(i>0 && p[i-1]>=p[i]) --i;
		//교차점 찾기를 실패해서 더이상 다음 permutation이 없음
		if(i==0) return false;
		
		//교차할 데이터 찾기
		int j = size;
		while(p[i-1]>=p[j]) --j;
		
		//swap
		int temp = p[i-1];
		p[i-1] = p[j];
		p[j] = temp;
		
		j = size;
		while(i<j) {
			temp = p[i];
			p[i] = p[j];
			p[j] = temp;
			i++;
			--j;
		}
		
		return true;
	}

}
