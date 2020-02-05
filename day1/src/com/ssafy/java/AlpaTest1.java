package com.ssafy.java;

public class AlpaTest1 {

	public static void main(String[] args) {
		char c = 'A';
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(c++ + " ");
			}
			System.out.println();
		}
	}
}
