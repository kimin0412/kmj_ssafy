package swea.d4;
import java.util.Arrays;
import java.util.Scanner;
// SWEA 5643 키순서 DFS 방식
public class Solution_5643_키순서_DFS {
	static int result = 0;
	static int N, M; // 사람수와 사람 관계 수
	static int[][] maps;
	static boolean[] v;
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC  = sc.nextInt();
		for(int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			maps = new int[N+1][N+1];
			result = 0;
			
			int a, b;
			for(int i = 0; i < M; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				maps[a][b] = 1;
			}
//			입력 자료 확인하기
//			for(int i = 1; i <=N; i++) {
//			System.out.println(Arrays.toString(maps[i]));
//		}
			
//			모든 사람이 자신보다 큰 사람 한번 세고, 자신보다 작은 사람 한번 세기
			for(int i = 1; i <= N; i++) {
				cnt = 0;
				v = new boolean[N+1];
//				자신보다 큰사람 카운트 하는 dfs 호출
				dfs(i);
				
//				자신보다 작은 사람 카운트 하는 dfs 호출
				v = new boolean[N+1];
				dfs1(i);
//				System.out.println("cnt : " + cnt);
				if(cnt == N-1) {
					result++;
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}
	private static void dfs(int cur) {
		v[cur] = true;  //방문체크
		for(int i = 1; i <=N; i++) {
			if(v[i]) { // 이미 방문한것 무시
				continue;
			}
			if(maps[cur][i] != 1) { // 나보다 키가 큰지 모르면 무시
				continue;
			}
			cnt++;//1증가
			dfs(i); //그 사람 보다 더 큰사람도 나보다 큰사람임으로 재귀 호출
		}		
	}
	private static void dfs1(int cur) {
		v[cur] = true;
		for(int i = 1; i <=N; i++) {
			if(v[i]) {
				continue;
			}
			if(maps[i][cur] != 1) {
				continue;
			}
			cnt++;			
			dfs1(i);
		}		
	}
}
