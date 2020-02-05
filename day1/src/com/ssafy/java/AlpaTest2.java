package com.ssafy.java;

public class AlpaTest2 {

	public static void main(String[] args) {
		char c = 'A';
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6-i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < i; j++) {
				System.out.print(c++);
			}
			System.out.println();
		}
	}
}
