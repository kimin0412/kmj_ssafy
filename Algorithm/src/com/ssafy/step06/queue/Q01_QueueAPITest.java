package com.ssafy.step06.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q01_QueueAPITest {

	public static void main(String[] args) {

		Queue<String> queue = new LinkedList<>();
		System.out.println(queue.isEmpty() + "//" + queue.size());
		queue.offer("김태희");
		queue.offer("이동욱");
		queue.offer("이지아");
		System.out.println(queue.isEmpty() + "//" + queue.size());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.isEmpty() + "//" + queue.size());
		System.out.println(queue.peek());
		System.out.println(queue.isEmpty() + "//" + queue.size());
		// deque는 두개의 큐를 선언한 거랑 비슷
		// 덱은 front, rear로 양쪽에서 뺄 수 있으므로 총 4가지로 사용 가능.
		// rear로 넣고 front로 빼면 : Queue
		// front/rear로 넣고 front/rear로 빼면 : stack
		
	}

}
