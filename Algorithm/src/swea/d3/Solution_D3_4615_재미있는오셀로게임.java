package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_4615_재미있는오셀로게임 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/4615_재밌는오셀로게임.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			int[][] map = new int[N][N];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int r = Integer.parseInt(in.readLine());
				int c = Integer.parseInt(in.readLine());
				int dol = Integer.parseInt(in.readLine());
				boolean[] flag = new boolean[8];
				map[r][c] = dol;
				int k= 1;
				while(true) {
					
					
					
					
				}
				
				
			}
		}
		
		
		
		
	}

}
