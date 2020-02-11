package com.ssafy.graph;

import java.util.Arrays;

public class DisjoinSetTest1 {
	/** 노드와 루트를 담는 배열
	 * index가 노드
	 * 값이 상위(부모)노드
	 * => index와 값이 같으면 root이다.
	 * => index와 값이 다르면 root가 아닌 트리에 속한 일반 노드
	 */
	
	static int[] parent;
	
	/** 처음에 모든 노드들은 해당 노드가 root가 된다. */
	public static void makeSet(int v) {
		parent[v] = v;
	}
	
	/**
	 * 노드의 root를 찾는 기능
	 * @param v
	 * @return 찾은 root
	 */
	public static int findSet(int v) {
		if(v == parent[v]) {  //배열의 값과 index가 같으면 root
			return v;
		}
		//root가 아니라면 자식이므로 상위(부모)로 가야함
		return findSet(parent[v]);
	}
	
	/**
	 * 두 트리를 결합하는 기능 */    //자기자신 하나여도 트리이다.
	public static void union(int u, int v) {
		//각각의 노드들의 root 찾기
		int root1 = findSet(u);
		int root2 = findSet(v);
		
		//두 트리를 결합  -> 둘중 하나의 값에다가 root를 넣어주면됨
		parent[root1] = root2;
//		 얘가      			  얘 밑으로 들어가는거.
		
		//한번에 해주는 코드. 두개 바껴도 상관없다.
//		parent[findSet(u)] = findSet(v);
	}
	
	public static void main(String[] args) {
		int N = 6;
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}
		
		System.out.println();
		System.out.println("=================== make set =====================");
		System.out.println(Arrays.toString(parent));
		
		union(3, 4);
		union(2, 4);
		union(5, 6);
		
		System.out.println();
		System.out.println("=================== union set =====================");
		System.out.println(Arrays.toString(parent));
		
		System.out.println();
		System.out.println("=================== find =====================");
		System.out.printf("2, 4 : %b\n", findSet(2) == findSet(4) );
		System.out.printf("2, 6 : %b\n", findSet(2) == findSet(6) );
		
		
		
		
//		System.out.println();
//		System.out.println("=================== make set =====================");
//		System.out.println(Arrays.toString(parent));
	}

}
