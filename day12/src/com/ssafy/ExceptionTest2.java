package com.ssafy;

public class ExceptionTest2 {
	/*
	 * String[] args={"10","5"}; String[] args={"ab","cd"}; String[] args={"10"};
	 * String[] args={"10","0"};
	 * 
	 * su1 su2 ---------- 10 5 ab cd ==> NumberFormatException 10 X ==>
	 * ArrayIndexOutOfBoundsException 10 0 ==> ArithmeticException
	 */
	public static void main(String[] args) {

		try {
			System.out.println("매개변수로 받은 두개의 수!!");
			int su1 = Integer.parseInt(args[0]);// NumberFormat,ArrayIndex
			int su2 = Integer.parseInt(args[1]);// NumberFormat,ArrayIndex
			System.out.println("su1=" + su1 + ", su2=" + su2);
			System.out.println("su1을 su2로 나눈 몫= " + (su1 / su2));// Arithmetic
			System.out.println("나눗셈을 잘 실행하였습니다~!!");
		} catch (Exception e) {
			// Exception e = new NumberFormatException(); => 됨.
			System.out.println("#모든 예외 처리 : " + e);
		} finally {
			System.out.println("finally 블럭 : 예외와 상관없이 실행되어지는 영역!!");
			// 보통 (파일, DB)자원 반환
		}
		System.out.println("마지막 문장!!!");
//		catch (NumberFormatException e) {
//			System.out.println("#숫자만 입력하세요.");
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println("#두 개의 숫자를 입력하세요.");
//		} catch (ArithmeticException e) {
//			System.out.println("#0으로 나눌 수 없음.");
//		}

	}
}
