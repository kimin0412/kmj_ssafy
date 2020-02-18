package com.ssafy.divconquer;

import java.math.BigInteger;

public class PowerTest {

	/**
	 * power를 sequential하게 구하는 기능
	 */
	public static long powerRec(int x, int n) {
		long result = x;
		for (int i = 1; i < n; i++) {
			result *= x;
		}
		return result;
	}

	/**
	 * 분할 정복을 이용한 power 구하는 기능
	 * 
	 */
//	public static long dcPower(int x, int n) {
//		if (n == 0)
//			return 1; // 0승인 경우 1을 리턴
//		if (n == 1)
//			return x; // 1일때는 자기자신 리턴
//		long result = dcPower(x, n >> 1);
//		if (n % 2 == 0) { // n이 짝수인 경우
//			return result * result;
//		} else {  //n이 홀수인 경우
//			return result * result*x;
//		}
//	}
	
	public static BigInteger dcPower(int x, int n) {
		if (n == 0)
			return new BigInteger("1"); // 0승인 경우 1을 리턴
		if (n == 1)
			return new BigInteger("" + x); // 0승인 경우 1을 리턴
		BigInteger result = dcPower(x, n >> 1);
		result = result.multiply(result);
		if (n % 2 == 1) { // n이 홓수인 경우
			return result = result.multiply(result);
		}
		return result;
	}

	public static void main(String[] args) {
		long stime = System.currentTimeMillis();
//		System.out.println(powerRec(9, 2111111111));
		System.out.println(dcPower(9, 2111111111));
		long etime = System.currentTimeMillis();
		System.out.printf("%dms", etime - stime);
	}

}
