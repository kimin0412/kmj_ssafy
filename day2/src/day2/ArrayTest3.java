package day2;

import java.util.Scanner;

//키보드로부터 10개의 자연수를 입력받아 표준 편차를 출력하세요.
public class ArrayTest3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		String msg = s.nextLine();  //줄바꿈(엔터키 입력)전 까지
//		String[] m = msg.split(" ")  //공백단위로 분리시켜라
//		String tokenrise? 라는 함수도 있는데 split보다 빠르다.
		int[] arr = new int[10];
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
//		int tot = 0;
//		for(int ss : arr) {
//			tot+=ss;
//		}
		
		int avg = sum/10;
		System.out.println("평균 : "+avg+"\n표준편차 : ");
		for (int i = 0; i < 10; i++) {
			arr[i] -=avg;
			System.out.print(arr[i]+" ");
		}
//		for (int ss : arr) {
//			System.out.println((avg-ss) + " ");
//		}
	}

}
