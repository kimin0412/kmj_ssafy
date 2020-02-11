package com.ssafy.graph;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class AdjList_dfs {
	static int N = 0;			//노드개수
	static GraphNode[] list;	//노드를 담을 배열
	static boolean[] visit;		//방문 체크
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/lecture/graph/AdjList.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			
			N = sc.nextInt();
			list = new GraphNode[N];
			visit = new boolean[N];
			int L = sc.nextInt();	//링크개수
			int v, ad;
			for (int i = 0; i < L; i++) {
				v = sc.nextInt();
				ad = sc.nextInt();
				list[v] = new GraphNode(ad, list[v]);
			}
			
			dfs(0);
			System.out.println();
		}
	}
	/** 첫번째 dfs(재귀사용) */
//	private static void dfs(int cur) {
//		visit[cur] = true;
//		System.out.printf("%c->", (cur+65));
//		GraphNode temp = list[cur];
//		while(temp != null) { //인접노드가 없을때까지 방문
//			if(!visit[temp.vertex]) { //방문되지 않았다면
//				dfs(temp.vertex);
//			}
//			temp = temp.link;
//		}
//	}
//	

	/** 두번째 dfs(스택사용) */
	private static void dfs(int cur) {
		Stack<Integer> stack = new Stack<>();
		stack.push(cur);
		GraphNode temp = null;
		while (!stack.isEmpty()) {
			cur = stack.pop();
			if (!visit[cur]) {
				visit[cur] = true;
				System.out.printf("%c->", cur + 65);
				temp = list[cur];
				while (temp != null) {
					stack.push(temp.vertex);
					temp = temp.link;
				}
			}
		}
	}
}
