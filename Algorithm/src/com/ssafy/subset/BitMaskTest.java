package com.ssafy.subset;

public class BitMaskTest {
	public static void main(String[] args) {
		//byte, short 연산 시 int 형으로 변환됨.
		byte a = 12;
//		byte b = a & 0;  //에러남 : int를 byte로 변환할 수 없다.
		byte c = 15;
		int b = a & 0;
		int d = a | c;
		System.out.printf("%d 의 bit : %s\n", a, Integer.toBinaryString(a));
		System.out.printf("%d 의 bit : %s\n", b, Integer.toBinaryString(b));
		System.out.printf("%d 의 bit : %s\n", d, Integer.toBinaryString(c));
		
		/*
		 * >> n : 비트를 n번 오른쪽으로 이동 => 2의 n승으로 나눈 효과
		 * 0000 1000    8 >> 2   8/4
		 * 0000 0010    2
		 * << n : 비트를 n번 왼쪽으로 이동 => 2의 n승으로 곱한 효과
		 * 0000 1000    8 << 2   8*4
		 * 0010 0000    32
		 */
		System.out.println("8 >> 2 : "+ (8>>2));
		System.out.println("-8 >> 2 : "+ (-8>>2));
		System.out.println("8 << 2 : "+ (8<<2));
		
		/*
		 * >>> n : 비트를 n번 오른쪽으로 이동
		 * 부호에 0을 채운다.
		 */
		System.out.println("8 >>> 2"+ (8>>>2));		
		System.out.println("-8 >>> 2"+ (-8>>>2));
		
		System.out.println("-8 >> 2 : "+ Integer.toBinaryString(-8>>2));
		System.out.println("-8 >>> 2 : "+ Integer.toBinaryString(-8>>>2));
	
//		숫자 i의 j번째 비트가 0인지 1인지를 출력하기
//		i & (1<<j) => j번째 비트가 0인지 1인지 알 수 있다.
		for (int i = 0; i < 5; i++) {
			printBit(i);
			
		}
		
	}

	private static void printBit(int i) {
		for (int j = 7; j >= 0; j--) {
			System.out.printf("%d", (i & 1<<j) != 0 ? 1:0);  //(i & 1<<j) 반드시 외우기!!!!
		}
		System.out.println();
	}
}
