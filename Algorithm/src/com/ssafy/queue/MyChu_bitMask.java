package com.ssafy.queue;

import java.util.LinkedList;

public class MyChu_bitMask {
	public static void main(String[] args) {
		int N = 20;
		int person = 1;
		LinkedList<Integer> chueue = new LinkedList<>();
		int p = (person<<8) + 1;
		int no, cnt;
		chueue.offer(p); //한번에 인라인코드 가능  이거 싫으면 비트마스크 쓰셈
		while(true) {
			p = chueue.poll();
			cnt = (byte)p;
			N-=cnt;
			no = p>>8;
			if(N<=0) {
				System.out.printf("마지막 마이쮸는 %d번 사원이 %d개를 가져갔습니다.\n", no, cnt+N);
				break;
			}
			else {
				System.out.printf("%d번 사원이 %d개의 마이쮸를 가져갔습니다. 남은 개수는 %d개 입니다.\n", no, cnt, N );
				chueue.offer(++p);
				chueue.offer((++person<<8) + 1);
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
