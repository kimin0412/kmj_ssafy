package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3378_스타일리쉬들여쓰기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/3378_스타일리쉬들여쓰기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			String[] nLine = new String[N];
			String[] mLine = new String[M];
			for (int i = 0; i < N; i++) {
				nLine[i] = br.readLine();
			}
			for (int i = 0; i < M; i++) {
				mLine[i] = br.readLine();
			}
			
			
			
		}
	}
}
