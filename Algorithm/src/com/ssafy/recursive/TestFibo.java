package com.ssafy.recursive;

public class TestFibo {

	public static void main(String[] args) {
		int num = 0;

//		num = fibo1(43);
//		num = fibo2(43);
		num = fibo3(43);
		System.out.println(num);
	}

	private static int fibo1(int num) { // 일반 재귀
		if (num == 1) {
			return 1;
		}
		if (num == 2) {
			return 1;
		}
		return fibo1(num - 1) + fibo1(num - 2);
	}

	static int[] memo = new int[100]; // 시간복잡도는 낮추고 공간복잡도를 늘려서 (메모리공간을 더 써서)
	private static int fibo2(int num) { // 메모이제이션 호출(하향식) 
		if(num == 1) {
			return 1;
		}
		if (num == 2) {
			return 1;
		}
		if(memo[num] == 0) { // 그 공간에 새로운 값이 없다면
			memo[num] = fibo2(num - 1) + fibo2(num - 2);
		}
		return memo[num];
	}

	private static int fibo3(int num) { // DB 점화식 구현(상향식) 재귀사용X
		memo[1] = 1;
		memo[2] = 1;
		for (int i = 3; i <= num; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[num];
	}

}
