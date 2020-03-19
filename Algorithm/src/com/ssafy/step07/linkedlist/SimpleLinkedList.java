package com.ssafy.step07.linkedlist;

public class SimpleLinkedList {

	static class Node {
		Object data;
		Node link;

		public Node(Object data) {
			this.data = data;
		}

		public Node(Object data, Node link) {
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", link=" + link + "]";
		}
		
	}

	private Node head; // 첫노드 자신

	public void addFirstNode(Object data) {
		head = new Node(data, head);
	}

	public Node getNode(Object data) {
		Node curNode = head;
		while (curNode != null) {
			if (curNode.data.equals(data))
				return curNode;
			curNode = curNode.link;
		}
		return null;
	}

	public void printList() {
		Node curNode = head;
		while (curNode != null) {
			System.out.print(curNode.data + " ");
			curNode = curNode.link;
		}
		System.out.println();
	}

	
	
}
