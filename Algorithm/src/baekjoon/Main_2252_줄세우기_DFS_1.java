package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//  백준 2252 줄세우기-1 Scanner
public class Main_2252_줄세우기_DFS_1 {

	private static boolean[] v;
	private static int N;
	private static int M;
	private static ArrayList<Integer>[] list;
	private static int[] indegree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		v = new boolean[N+1];
		//		인접행렬, 인접리스트(o)
		list = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		//		진입차수 관리 배열
		indegree = new int[N+1];
		//		입력받기
		for(int i =0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y); //인접리스트에 방향그래프 삽입
			indegree[y]++;  //인접 차수 별도 관리
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= N; ++i) {
			if (v[i]) { 
				continue;			
			}
			if (indegree[i] == 0) {
				dfs(i, result);
			}
		}
		for(Integer idx : result) {
			System.out.print(idx + " ");
		}
		System.out.println();
		

	}

	static void dfs(int cur, List<Integer> result) {
		v[cur] = true;
		for (Integer idx : list[cur]) {
			if (v[idx]) {
				continue;
			}
			dfs(idx, result);
		}
		result.add(0,cur);
	}

}
