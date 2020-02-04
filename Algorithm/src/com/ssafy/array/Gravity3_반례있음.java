package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Gravity3_반례있음 { //시뮬레이션으로 안풀경우_ 반례가 잇음

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("res/gravity.txt"));
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();  //배열의 크기
		
		int maxHeight =0;
		int max=n;
		for(int i=0; i<n; i++) {
			int height=scan.nextInt();  
			if(height>=maxHeight) {//더 높은애가 들어오면 
				maxHeight=height; //바꿔줌
				max--; //빼줌
			}
			
		}
		if(max==n) { //박스가 맵에 하나도 없는경우
			System.out.println(0);
		}else {
		System.out.println(max);
		}
	}

}
