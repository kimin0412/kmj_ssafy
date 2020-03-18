package com.ssafy.step06.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q02_MyChew {

	public static void main(String[] args) {
		int N = 11;
		int person = 1;
		Queue<int[]> queue = new LinkedList<>(); // 0:번호, 1:마이쮸개수
		queue.offer(new int[] { person, 1 });

		while (N > 0) {
			int availableCnt;
			if (!queue.isEmpty()) {
				int[] p = queue.poll();
				availableCnt = (N >= p[1]) ? p[1] : N;
				N -= availableCnt; // 마이쮸 잔여개수
				if (N == 0) { // 마지막 마이쮸를 가져가는 상황
					System.out.println("마지막 마이쮸를 가져가는 사람 : " + p[0] + ", 가져간 개수 : " + availableCnt);
				} else {
					// 받은 사람이 다시 줄 서기 (마이쮸 개수 1 증가)
					System.out.println(p[0] + "번 사람이 " + p[1] + "개의 마이쮸를 가져갑니다. 남은 개수 : " + N);
					p[1]++;
					queue.offer(p);
					// 새로운 사람이 줄 서기
					queue.offer(new int[] { ++person, 1 });
				}
			}
		}
	}
}
