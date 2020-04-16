package algo;

import java.util.Scanner;

/*
 * 월말평가 소금배달 문제 
 */
public class 소금배달2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();

		// 3kg 5kg
//		int cnt = M/5 + M%5 / 3; //가설 틀림
		int cnt = 0;
		// 21kg 5 5 5 3 3
		// 18 3
		// 15 3 3 5 5 5
		// 4kg x
		// 1  3
		//-2  3 3
		//-5  3 3 3
		while (M % 5 != 0) { // 5로 나누어 떨어지지 않는다면 
			M -= 3;
			cnt++;
		}

//		cnt -= M / 5;
		
		if(M<0) { // 음수 
			System.out.println(-1);
		}else {
			cnt+=M/5;
			System.out.println(cnt);
		}
//		Greedy
//		3kg 5kg 7kg 11kg
//		소금 봉지의 무게 종류 
		
		
		

	}
}
