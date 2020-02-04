package com.ssafy.array;

public class ForTest {
	public static void main(String[] args) {
	/*
	 *  반복문 for
	 *  for(반복변수의 초기값 설정; 조건; 반복변수의 증감)
	 *    //반복할 문장
	 *  for(int i =0; i<args.length; i++){
	 *  }
	 */
		int sum =0;
		for (int i = 0; i <= 100; i++) {
			sum+=i;
		}
		System.out.println(sum);
		// ==보다 <가 빠름  <=보다 >로 하는게 빠름
		// lable: 반복문에 이름을 부여해서 특정 반복문을 break하거나 continue할 수 있다. 
		//lable명:
		top:
		for(int i =2; i<10; i++) {
			for(int j= 1; j<10; j++) {
				System.out.printf("%d*%d=%d\t",i,j,i*j);
				if(i*j>50) {
					break top;
				}
 		
			}
			System.out.println();
		}
}
}
