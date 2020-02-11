package com.ssafy.graph;

import java.util.Arrays;

/** 
 * rank가 있는 Disjoin Set
 * 
 * 배열의 index는 노드
 * 배열의 값이 상위노드 아니면 rank를 표시
 * 0과 양의 정수 : 상위 노드
 * 음수		: root이면서 rank
 */
public class DisjoinSetTest2 {
	
	static int[] parent;
	
	/** 
	 * 음수면 root이면서 rank수 이므로 -1로 초기화 한다.
	 */
	public static void makeSet(int v) {
		parent[v] = -1;
	}
	
	/**
	 * 노드의 root를 찾는 함수
	 * @param v
	 * @return 찾은 root
	 */
	public static int findSet(int v) {
		if(parent[v] < 0) {  //노드 값이 음수면 root이므로 노드를 리턴한다.
			return v;
		}
		//노드 값이 음수가 아니면 일반 노드 이므로 상위(부모)로 이동
		return findSet(parent[v]);
	}
	
	public static void union(int u, int v) {
//		각 트리의 root를 찾아온다.
		int root1 = findSet(u);
		int root2 = findSet(v);
		if(root1 == root2) return;	//같은 트리이므로 연결 할 필요 없음
		
		
//		두 트리 중 랭크가 높은 곳에 낮은 트리를 연결
		int rank1 = parent[root1];
		int rank2 = parent[root2];
		if(rank1 < rank2) {		//랭크1이 깊음
			parent[root1] += parent[root2];		//랭크1에 랭크2를 더한다. => 랭크 수 늘리기
			parent[root2] = root1;
		}else {
			parent[root2] += parent[root1];		//랭크2에 랭크1를 더한다. => 랭크 수 늘리기
			parent[root1] = root2;
		}
	}
	
	/** 노드가 속한 트리의 총 노드 수 반환 */
	public static int getSize(int v) {
		return -parent[findSet(v)];		//루트의 랭크 값에 -를 붙여서 해당 그래프의 size를 리턴
	}

	public static void main(String[] args) {
		int N = 6;
		parent = new int[N+1];  //0번 부터 할거면 N개만 해도 ㄱㅊ
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}
		
		System.out.println();
		System.out.println("=================== make set =====================");
		System.out.println(Arrays.toString(parent));
		
		union(4, 3);
		union(4, 2);
		union(6, 5);
		
		System.out.println();
		System.out.println("=================== Union =====================");
		System.out.println(Arrays.toString(parent));
		
		union(5, 2);
		System.out.println(Arrays.toString(parent));
		
		System.out.println();
		System.out.println("=================== getSize =====================");
		System.out.println("2번 노드가 속한 트리의 size : " + getSize(2));	
		
//		System.out.printf("2, 4 : %b\n", findSet(2) == findSet(4) );
//		System.out.printf("2, 6 : %b\n", findSet(2) == findSet(6) );
		
	}

}
