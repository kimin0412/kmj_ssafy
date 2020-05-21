package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_6987_월드컵 {
	// 6C2
	static int[] vsA = new int[15];
	static int[] vsB = new int[15];
	static int[][] input;
	static boolean check;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/6987_월드컵.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {
				vsA[idx] = i;
				vsB[idx] = j;
				idx++;
			}
		}
		for (int tc = 1; tc <= 4; tc++) {
			input = new int[6][3];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					input[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(dfs(0))
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
		}
//		System.out.println((int));
	}

	static boolean dfs(int cnt) {
		if (check)
			return true;
		if (cnt == 15) {
			for(int i=0; i<6; i++) {
                if(input[i][0] != 0) return false;
                if(input[i][1] != 0) return false;
                if(input[i][2] != 0) return false;
            }
			return true;
		}
		int teamA = vsA[cnt];
		int teamB = vsB[cnt];

		if (input[teamA][0] > 0 && input[teamB][2] > 0) {
			input[teamA][0]--;
			input[teamB][2]--;
			if(dfs(cnt+1)) return true;
			input[teamA][0]++;
			input[teamB][2]++;
		}
		if (input[teamA][2] > 0 && input[teamB][0] > 0) {
			input[teamA][2]--;
			input[teamB][0]--;
			if(dfs(cnt+1)) return true;
			input[teamA][2]++;
			input[teamB][0]++;
		}
		if (input[teamA][1] > 0 && input[teamB][1] > 0) {
			input[teamA][1]--;
			input[teamB][1]--;
			if(dfs(cnt+1)) return true;
			input[teamA][1]++;
			input[teamB][1]++;
		}
		return false;
	}
}
