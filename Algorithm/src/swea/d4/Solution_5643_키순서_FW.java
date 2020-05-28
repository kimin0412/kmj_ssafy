package swea.d4;
import java.util.Arrays;
import java.util.Scanner;
// SWEA 5643 키순서 프로이드 와샬
public class Solution_5643_키순서_FW {
	static int result = 0;
	static int N, M; // 사람수와 사람 관계 수
	static int[][] maps;
	static boolean[] v;
	static int cnt = 0;
//	프로이드 와샬 기본값	
	static final int INF = 999;
	static int counts[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC  = sc.nextInt();
		for(int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			maps = new int[N+1][N+1];
			counts = new int[N+1];
			result = 0;
			//			모든 관계를 모른다고 설정하기
			for(int i = 0; i <=N; i++) {
				Arrays.fill(maps[i], INF);
			}

			int a, b;
			for(int i = 0; i < M; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				maps[a][b] = 1;
			}
			//			프로이드 와샬 처리
			for(int k=1; k <=N; k++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						if(maps[i][j] > maps[i][k] + maps[k][j]) {
							maps[i][j] = maps[i][k] + maps[k][j];
						}
					}
				}
			}

//			프로이드 와샬 결과 확인하기
			for(int i = 1; i <=N; i++) {
				for(int j = 1; j <=N; j++) {
					System.out.print(maps[i][j] + "\t");
				}
				System.out.println();
			}

//			Map 반복 처리하면서 관계를 알 수 있는 사람 카운트 처리하기
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(maps[i][j] != INF) {
						counts[i]++;
						counts[j]++;
					}
				}
			}
			System.out.println(Arrays.toString(counts));
//			counts 배열의 값이 N-1이면 그 위치는 모든 사람과의 관계를 알 수 있는것
			for(int i = 1; i <=N; i++) {
				if(counts[i] == N-1) {
					result++;
				}
			}
			System.out.println("#" + t + " " + result);
		}
	}	
}
