package com.ssafy.array;

import java.util.Arrays;

public class ArrayTest1 {

	public static void main(String[] args) {
		int[][] a = new int[2][3];
		
		int[][] b = new int[3][];
//		runtime error : 문법은 맞는데 실행하다가 오류가 난 경우
		b[0] = new int[5];
		b[1] = new int[3];
		b[2] = new int[10];
		b[0][1] = 50;
		b[1][2] = 60;
		b[2][2] = 70;
		
//		배열은 초기화 될때 0으로 초기화된다.
		for (int r = 0; r < b.length; r++) {
			for (int c = 0; c < b[r].length; c++) {
				System.out.print(b[r][c]+" ");
			}
			System.out.println();
		}
		System.out.println("=====================");
		for (int[] bb : b) {
			for (int bbb : bb) {
				System.out.print(bbb + " ");
			}
			System.out.println();
		}
		
		
		
		
		
		
//		compile error : 문법적인 오류
//		int k; //k안에는 쓰레기 값이 들어가있다. (초기화 안되어있음)
//		k=k+5; //쓰레기 값에 값을 더할 수 없기 때문에 오류
		
		
		
		
	}

}
