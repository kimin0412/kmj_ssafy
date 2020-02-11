package com.ssafy.queue;

import java.util.LinkedList;

public class MyChew_bit {
	public static void main(String[] args) {
		int N = 20;
		int person = 1;   //사람 번호
		LinkedList<Integer> queue = new LinkedList<>();
		int p =(person<<8)+1;
		queue.offer(p);
		int no, cnt;
		while(true) {
			p  = queue.poll();
			cnt=(byte)p;
			N -=cnt;
			no =p>>8;			//사원번호
			if(N<=0) {
				System.out.printf("마지막 마이쭈는  %d번 사원이 %d개를 가져갔습니다.\n", no, cnt+N);
				break;
			}else {
				System.out.printf("%d번 사원이 %d개의 마이쭈를 가져갔습니다. 남은 개수는 %d개입니다.\n"
								  ,no, cnt, N );
				queue.offer(++p);
				queue.offer((++person<<8)+1);
			}
		}
	}
}












