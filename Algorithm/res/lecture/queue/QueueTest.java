package com.ssafy.queue;
class MyQueue{
	private Object[] queue;
	/**데이타를 입력하는 위치를 위한 index */
	private int rear;
	/**데이타를 추출하는 위치를 위한 index */
	private int front;
	/**queue의 총 크기 */
	private int n;
	/**queue에 저장된 데이타 개수  */
	private int size;
	public MyQueue() {
		this(5);
	}
	public MyQueue(int n) {
		this.n= n;
		queue = new Object[n];
	}
	
	public boolean isFull() {
		if(rear == n) {
			return true;
		}else {
			return false;
		}
	}
	public boolean isEmpty() {
		if(rear == front) {
			return true;
		}else {
			return false;
		}
	}
	public void enQueue(Object data) {
		if(isFull()) {
			throw new RuntimeException("Queue is Full");
		}
		queue[rear++] = data;
		size++;
	}
	public Object peek() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		return queue[front];
	}
	public Object deQueue() {
		if(isEmpty()) {
			throw new RuntimeException("Queue is Empty");
		}
		size--;
		return queue[front++];
	}
	public int size() {
		return size;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder(size*2+2);
		sb.append("[");
		if(size>0) {
			for (int i = front; i <rear; i++) {
				sb.append(queue[i]);
				sb.append(" ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
}
public class QueueTest {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
//		System.out.println(queue.peek());
		System.out.println(queue);
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		System.out.println(queue);
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
	}
}



