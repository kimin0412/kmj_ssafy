package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TreeArrayTest3 {
	static int N;
	static int[] arrTree;
	static int[] data;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		1. 데이터 읽기
		System.setIn(new FileInputStream("res/tree2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//		2. 배열에 데이터 담기
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		arrTree = new int[N + 1];
		data = new int[N];
		
		for (int i = 0; i < N; i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println("origin :" + Arrays.toString(data));
		Arrays.sort(data);

		System.out.println("sort : " + Arrays.toString(data));
		insertTree(0, N-1);
		System.out.println("트리 구성 후 : " + Arrays.toString(arrTree));
		

	}

	/**
	 * 트리를 구성하는 함수
	 * 
	 * @param index 트리를 구성할 데이터의 index
	 * @param start data의 시작 위치
	 * @param end   data의 끝 위치
	 */
	public static void insertTree(int start, int end) {
		int middle = middle(start, end);
		LinkedList<int[]> que = new LinkedList<>();
		que.offer(new int[] {middle, start, end});
		int idx = 1;		//트리를 구성할 index 
		int left, right;
		int[] node;
		while(!que.isEmpty()) {
			node = que.poll();
			middle = node[0];
			if(middle>=0 && middle <= N && idx<=N) {
				arrTree[idx++] = data[middle];
				left = middle(node[1], middle);
				right = middle(middle+1, node[2]);
				que.offer(new int[] {left, node[1], middle});
				que.offer(new int[] {right, middle, node[2]});
			}
		}
		
	}

	public static int middle(int start, int end) {
		return (start+end)>>1;
	}
	/*
	 * 전위순회(preorder) : 현재 노드를 먼저 방문 VLR
	 */
	private static void preorder(int index) {
//		재귀호출이 되어야함
//		index는 15번까지 (N)번까지 갈 수 있다.
//		순회하려는 index가 배열 범위내에 있고 해당 index에 데이터가 있으면 순회시작
		if (index <= N && arrTree[index] != 0) {
			System.out.print(arrTree[index] + " "); // 현재노드(V)를 먼저 출력
			preorder(index << 1); // 왼쪽 자식 노드(L)을 순회 : 현재노드 index*2 (이진이므로)
			preorder((index << 1) + 1); // 오른쪽 자식 노드(R)을 순회. : 현재노드 *2+1
		}
	}

	/*
	 * 중위순회(inorder) : 왼->현재->오른쪽 LVR
	 */
	private static void inorder(int index) {
//		재귀호출이 되어야함
//		index는 15번까지 (N)번까지 갈 수 있다.
//		순회하려는 index가 배열 범위내에 있고 해당 index에 데이터가 있으면 순회시작
		if (index <= N && arrTree[index] != 0) {
			inorder(index << 1); // 왼쪽 자식 노드(L)을 순회 : 현재노드 index*2 (이진이므로)
			System.out.print(arrTree[index] + " "); // 현재노드(V)를 먼저 출력
			inorder((index << 1) + 1); // 오른쪽 자식 노드(R)을 순회. : 현재노드 *2+1
		}
	}

	/*
	 * 후위순회(postorder) : 왼->오른쪽->현재 LRV
	 */
	private static void postorder(int index) {
//		재귀호출이 되어야함
//		index는 15번까지 (N)번까지 갈 수 있다.
//		순회하려는 index가 배열 범위내에 있고 해당 index에 데이터가 있으면 순회시작
		if (index <= N && arrTree[index] != 0) {
			postorder(index << 1); // 왼쪽 자식 노드(L)을 순회 : 현재노드 index*2 (이진이므로)
			postorder((index << 1) + 1); // 오른쪽 자식 노드(R)을 순회. : 현재노드 *2+1
			System.out.print(arrTree[index] + " "); // 현재노드(V)를 먼저 출력
		}
	}

}
