package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AdjMatrix_bfs {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/lecture/graph/AdjMatrix.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<>();
		
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			boolean[] visit = new boolean[N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				// 굳이 StringTokenizer 쓰지 않고 0부터 2증가하면서 charAt으로 불러와도 ㄱㅊ
				for (int j = 0; j < visit.length; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			queue.add(0);  //방문한 첫 노드를 queue에 넣는다.
			visit[0] = true;  //방문 처리를 한다.
			int current;
			while(!queue.isEmpty()) {  //계속 꺼낸다.
				current = queue.poll();
				System.out.printf("%c  ->  ", current+65);
				//현재 노드와 인접한 노드를 탐색
				for (int adj = 0; adj < N; adj++) { //열 탐색
					//          인접된 노드                       방문안한 노드라면
					if(map[current][adj] != 0 && !visit[adj]) { //0이 아니라는건 인접한 노드라는뜻
						//0이 아니어도 되고 1이어도 된다.
						visit[adj] = true;
						queue.add(adj);
						
						
					}
				}
			}
			System.out.println();

		}

	}

}
