package com.ssafy.queue;

import java.util.LinkedList;

public class MyChew_array {
	public static void main(String[] args) {
		int N = 20;
		int person = 1;   //사람 번호
		LinkedList<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {person,1});   
		while(true) {
			int[] p = queue.poll();
			int num = p[1]++;
			N-=num;
			if(N<=0) {
				System.out.printf("마지막 마이쭈는  %d번 사원이 %d개를 가져갔습니다.\n", p[0], num+N);
				break;
			}else {
				System.out.printf("%d번 사원이 %d개의 마이쭈를 가져갔습니다. 남은 개수는 %d개입니다.\n"
								  ,p[0], num, N );
				queue.offer(p);
				queue.offer(new int[] {++person, 1});
			}
		}
	}
}












