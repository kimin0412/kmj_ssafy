package baekjoon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
//  백준 2252 줄세우기
public class Main_2252_줄세우기_ToSort_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
//		인접행렬, 인접리스트(o)
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
//		진입차수 관리 배열
		int[] indegree = new int[N+1];
//		입력받기
		for(int i =0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y); //인접리스트에 방향그래프 삽입
			indegree[y]++;  //인접 차수 별도 관리
		}
//		진입차수가 0인것을 큐에 삽입
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				q.offer(i);
			}
		}
//		만약에 q가 비었으면 종료
		if(q.size() == 0) {
			System.out.println("시작정점모름");
			return;
		}
		
//		큐가 빌때까지 indegree값을 1씩 감소하고, 0인 degree 큐에 삽입
//		큐에서 뽑아논 번호 출력을 위해 리스트에 삽입
		List<Integer> result = new ArrayList<>();
		Integer cur;
		while(!q.isEmpty()) {
			cur = q.poll();
			result.add(cur);
//			현재 연결된 정점들의 indegree 1 씩 감소
//			indegree 값이 0인것은 큐에 삽입
			for(int idx : list[cur]) {
				indegree[idx]--;
				if(indegree[idx] == 0) {
					q.offer(idx);
				}
			}
		}
//		result사이즈가 N보다 작으면 내부 사이클 존재
		if(result.size() != N) {
			System.out.println("사이클");
			return;
		}
		for(Integer idx : result) {
			System.out.print(idx + " ");
		}
		System.out.println();

	}

}
