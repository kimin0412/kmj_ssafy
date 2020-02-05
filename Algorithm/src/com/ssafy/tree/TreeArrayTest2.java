package com.ssafy.tree;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class TreeArrayTest2 {
	static int N;
	static int[] arrTree;
	static int[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
//		1. 데이터 읽기
		System.setIn(new FileInputStream("res/tree2.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//		2. 배열에 데이터 담기
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		arrTree = new int[N + 1];
		temp = new int[N + 1];
//		for (int i = 1; i <= N; i++) {
//			arrTree[i] = Integer.parseInt(st.nextToken());
//		}
		
		for (int i = 1; i <= N; i++) {
			temp[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println("origin :" + Arrays.toString(temp));
		Arrays.sort(temp);

		System.out.println("sort : " + Arrays.toString(temp));
//		insertTree(1, 1, N);
		LinkedList<Integer> que = new LinkedList<>();
		int mL, mR, middle;
		mL = 1;
		mR = N;
		for (int i = 1; i <= Math.log(N+1); i++) {
			middle = (1+N)/2;
			mL = mL<<1;
			mR = mR/2;
			
			que.offer(temp[middle]);
			que.offer(temp[mL]);
			que.offer(temp[mR]);

		}
		
		
		System.out.println("트리 구성 후 : " + que);
		

//		3. 순회
		// 전위순회
//		System.out.println("전위순회");
//		preorder(1);
//		System.out.println();
//		System.out.println(" 중위순회");
//		inorder(1);
//		System.out.println();
//		System.out.println("후위순회");
//		postorder(1);
//		System.out.println();
	}

	/**
	 * 트리를 구성하는 함수
	 * 
	 * @param index 트리를 구성할 데이터의 index
	 * @param start data의 시작 위치
	 * @param end   data의 끝 위치
	 */
	public static void insertTree(int index, int start, int end) {
		if (index <= N) {
			int middle = (start + end) / 2;
			arrTree[index] = temp[middle];
//			System.out.print(arrTree[(start + end) / 2] + " "); // 현재노드(V)를 먼저 출력
//			System.out.print(arrTree[(start+end)/2] + " ");  //현재노드(V)를 먼저 출력
			insertTree(index<<1, start, middle);  //왼쪽자식
			insertTree((index<<1)+1, middle+1, end);	  //오른쪽자식
		}
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