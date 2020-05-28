package com.ssafy.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 
 * 
정점 간선
왼쪽에서 오른쪽 방향 
8 9 
1 2
1 3
1 4
4 5
5 6
3 6
3 7
2 7
7 8

 *
 */
public class TopologicalSortTest {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); //정점 개수
		int E = Integer.parseInt(st.nextToken()); //간선 개수 
		ArrayList<Integer>[] list = new ArrayList[N+1];
		
		int[] inDegree = new int[N+1];
		ArrayList<Integer> result = new ArrayList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		// 진입 차수 관리 -> 인접 리스트 형태의 유향그래프를 그려준 것
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			inDegree[b]++;
		}
		
		// 진입차수가 0인 것들 큐에 삽입
		for (int i = 1; i <=N; i++) {
			if(inDegree[i] == 0) queue.add(i);
		}
		if(queue.size() == 0) {
			System.out.println("사이클 존재");
			return;
		}
		
		// 큐에서 하나씩 빼서 연결된 애들 진입차수 1씩 감소, 다시 0인 것들은 큐에 삽입
		// 큐에서 하나씩 뺄때 그 내용을 리스트로 정리
		while(!queue.isEmpty()) {
			int  current = queue.poll();
			result.add(current);
			for (int i = 0; i <list[current].size(); i++) {
				int temp = list[current].get(i);
				inDegree[temp]--;
				if(inDegree[temp] == 0) {
					queue.add(temp);
				}
			}
		}
		
		for (int i = 0, size = result.size(); i <size; i++) {
			System.out.print(result.get(i));
			if(i!=size) System.out.print(" ");
		}
	
	}
}











