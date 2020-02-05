package com.ssafy.array;

import java.util.Arrays;

public class ArrayTest2 {

	public static void main(String[] args) {
		int[][] a = { {10,20,30},{40,50,60}};
		for (int[] aa : a) {
			for (int aaa : aa) {
				System.out.print(aaa+ " ");
			}
			System.out.println();
		}	
	}
}
