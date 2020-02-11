package com.ssafy.graph;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class AdjList_bfs {
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
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(i + ":" + list[i]);
//				
//			}
			bfs(0);
			System.out.println();
			
			
		}
	}
	
	private static void bfs(int cur) {
		//노드 번호를 저장하는 큐 생성
		LinkedList<Integer> queue = new LinkedList<>();
		visit[cur] = true;  //bfs는 먼저 방문처리 해줌
		queue.add(cur);
		GraphNode temp = null;
		while( !queue.isEmpty() ) {
			cur = queue.poll();
			System.out.printf("%c=>", (cur+65));
			temp = list[cur];
			while(temp != null) { //인접노드가 없을때까지 방문
				if(!visit[temp.vertex]) { //방문되지 않았다면
					visit[temp.vertex] = true;
					queue.offer(temp.vertex);
				}
				temp = temp.link;
			}
		}
		
//		맨마지막걸 넣어줘서 A다음에 D가 나온다.
//		bfs로 가는건 똑같으니까 상관없다.
		
	}

}
