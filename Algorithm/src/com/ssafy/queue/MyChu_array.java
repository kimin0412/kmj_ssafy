package com.ssafy.queue;

import java.util.LinkedList;

public class MyChu_array {
	public static void main(String[] args) {
		int N = 20;
		int person = 1;
		LinkedList<int[]> chueue = new LinkedList<>();
		chueue.offer(new int[] {person, 1}); //한번에 인라인코드 가능  이거 싫으면 비트마스크 쓰셈
		while(true) {
			int[] p = chueue.poll();
			int num = p[1]++;
			N-=num;
			if(N<=0) {
				System.out.printf("마지막 마이쮸는 %d번 사원이 %d개를 가져갔습니다.\n", p[0], num+N);
				break;
			}
			else {
				System.out.printf("%d번 사원이 %d개의 마이쮸를 가져갔습니다. 남은 개수는 %d개 입니다.\n", p[0], num, N );
				chueue.offer(p);
				chueue.offer(new int[]{ ++person, 1});
			}
		}		
//		`
//		int per = 1;
//		chue.offer(1);
//		for (int i = 0; i < 20; i++) {
//			int tmp = per;
//			int out = chue.poll();
//			System.out.println(out+"번 사원이 " + tmp+"게의 마이쮸를 가져갔습니다. 남은 개수는 " + cnt+ "개 입니다.");
//			chue.push(out);
//			
//			chue.offer(per);
//			per++;
//			chue.offer(per);
//			
//			
//			
//			//ㄴㅇㄱ !!
//
//		}		
	}
}
