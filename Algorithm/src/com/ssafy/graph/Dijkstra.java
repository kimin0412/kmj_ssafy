package com.ssafy.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Dijkstra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt(); // 정점의 개수 
		int E = sc.nextInt(); // 간선의 개수 
		int[][] adj = new int[V][V];
		for (int i = 0; i < E; i++) {
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		// 최단 거리를 저장하는 배열
		int[] D = new int[V];
		Arrays.fill(D, Integer.MAX_VALUE); // 최저값으로 갱신해야 하므로 최고 값으로 초기화 
		
		// 방문 체크 배열 
		boolean[] check = new boolean[V];
		
		// Dijkstra 시작점이 a정점 이라면 D[a] = 0 
		// 0번 노드부터 출발 => 출발 노드를 입력 받는다. 
		D[0] = 0;
		for (int i = 0; i < V-1; i++) {
			int min = Integer.MAX_VALUE; // 가장 작은 값을 기억할 변수 
			int index = -1; // 그 위치를 기억할 변수 
			for (int j = 0; j < V; j++) {
				// 아직 처리하지 않았으면서(방문 한적 없으면서), 가장 짧은 거리라면 
				if(!check[j] && min > D[j]) {
					min = D[j];
					index = j;
				}
			}
			// 연결이 없는 경우 끝. INF
			if(index == -1)
				break;
			
			// 새로운 친구로부터 갈 수 있는 경로들을 업데이트 
			for (int j = 0; j < V; j++) {
				// (!check[j]) 아직 처리하지 않았으면서
				// (adj[index][j] != 0) 경로가 존재하고
				// (D[index] + adj[index][j] < D[j]) 이미 구한 노드보다 현재 노드를 거쳐 가는 비용이 더 저렴하다면 
				if(!check[j] && adj[index][j] != 0 && D[index] + adj[index][j] < D[j]) {
					D[j] = D[index] + adj[index][j]; // 저렴한 비용으로 갱신 
				}
			}
			// 처리된 놈으로 체크
			check[index] = true;
		}
		System.out.println(Arrays.toString(D));
	}

}
