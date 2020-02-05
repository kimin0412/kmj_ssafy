package com.ssafy.method;

public class MethodTest {

	public static void main(String[] args) {
//		c나 c++이나 java는 메인에서 밖에 실행 안함. 실행하려면 무조건 main으로 오셈
		int k = 5;
		work(k);
		System.out.println();
		int result = work(3, k);
		System.out.println("일한 시간 :" + result + "시간");
		
	}
//	public은 패키지 밖에서도 쓰겠다는 의미
//	static은 객체 생성 없이 사용하겠다는 의미
	public static void work(int time) {
		if(time == 0) {
			return;  //그만 되돌아가.
		}
		System.out.println("열심히 일하는 중...."+ time);
	}
	
//	Overloading(중복)기법 : 이름은 같고 파라미터 다르게 정의하는 것
	public static int work(int day, int time) {
		if(time == 0 || day == 0) {
			return 0;  //리턴 타입이 정의되어 있기 때문에 반드시 값을 갖고 되돌아 가야함.
		}
		for (int i = 1; i <= day; i++) {
			System.out.println("열심히 일하는 중...."+ time);
		}
		return day*time;
	}
	
	public void mmm() {
		System.out.println("mmmmmmmmm");
	}
	

}
