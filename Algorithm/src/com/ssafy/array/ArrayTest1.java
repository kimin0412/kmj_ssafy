package com.ssafy.array;

import java.util.Arrays;

public class ArrayTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 배열
		 * -변수 하나에 여러개의 공간을 할당해서 같은 타입의 값만 저장하는것
		 * -어떤 타입이든 배열을 선언할 수 있고 배열로 선언하면 reference type이 된다.
		 * -자바 배열의 인덱스는 0부터 시작한다. length-1까지 접근 가능하다.
		 * 접근 범위를 벗어나면 ArrayIndexOutOfBoundsException발생
		 * -배열의 size는 0부터 양의 정수만 지정할 수 있다.
		 * 음수로 지정하면 NegativeArraySizeException발생
		 * -length 속성이 있다. 배열의 size다. 
		 * 배열의 크기는 생성시에 설정할 수 있고 이후에는 크기 변경이 불가하다.
		 * =>변경하고 싶으면 새로 배열을 생성하고 값을 복사해줘야함.
		 * 복사하는 함수(양이 적을땐 for문 돌리는게 빠름)
		 * 	Arrays.copyOf
		 * 	System.arrayCopy(~)
		 * 
		 * -배열을 생성하면 기본값으로 초기화된다.
		 * 정수는 0, 실수는0.0, 문자는 \u0000, 논리는 false, 참조형은 null
		 * -선언할때
		 * DataType[] 변수명;
		 * DataType 변수명[];
		 * DataType 변수명[size]; 자바에서는 컴파일 에러 발생
		 * 
		 * -생성
		 * 변수명 = new 데이터타입[size];
		 * -선언과 생성 같이
		 * DataType[] 변수명 =new 데이터타입[size];
		 * 
		 * -할당
		 * 변수명[index]=값;
		 * 
		 * 선언&생성&할당 동시에 =>할당된 값의 개수가 배열의 size
		 * DataType[] 변수명 = {값1,값2,....}
		 */
		int[] i,j,k; // 일차원 int배열
		int a[],b,c; //a만 일차원 int배열. b,c는 int
		int[] l,m[],n[][]; // l은 일차원 m은 이차원 n은 삼차원
		int[] array1 = new int[3];
		array1[0]=10; //값 넣어주기
		for(int o=0; o<array1.length; o++) {
			System.out.printf("array1[%d] : %d\n",o,array1[o]); //배열 초기화
		}
	//	for(int o=0; size=array1.length; o<size; o++) {// heap은 시간이 오래 걸리기 때문에 local 변수를 주면 빠르다.
	//		System.out.printf("array1[%d] : %d\n",o,array1[o]); //배열 초기화
	//	}
		int[] array2 = {0,1,2,3,4,5};
		System.out.println(Arrays.toString(array2));
}

}

