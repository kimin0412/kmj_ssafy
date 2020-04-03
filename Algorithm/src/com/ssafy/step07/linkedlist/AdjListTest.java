package com.ssafy.step07.linkedlist;

import java.util.Scanner;

public class AdjListTest {

	static class Node {
		int to;
		Node link;

		public Node(int to, Node link) {
			super();
			this.to = to;
			this.link = link;
		}

		public Node(int to) {
			super();
			this.to = to;
		}
	}

	private static Node[] adjList;
	private static int N;
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 정점 수
		int M = sc.nextInt(); // 간선 수
		adjList = new Node[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();

			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]); // 무향그래프 이므로 양쪽링크 다 해줌
		}

		dfs(1);

	}

	private static void dfs(int cur) {

		visited[cur] = true;
		System.out.println((char)(cur + 64));
		
		for (Node temp = adjList[cur]; temp != null; temp = temp.link) {
			if (!visited[temp.to]) { // 인접 여부 체크하지 않음. 어차피 나랑 관계되어있는 애들만 포함되어있음
				dfs(temp.to);
			}

		}

	}

}
