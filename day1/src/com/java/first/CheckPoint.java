package com.java.first;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int m = sc.nextInt();
		int km = m+100-k;
		System.out.println("비만수치는 "+km+"입니다.");
		if(km>0) System.out.println("당신은 비만이군요...");
	}

}
