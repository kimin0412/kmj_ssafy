package swea.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5653_모의SW_줄기세포배양 {
	static int[][] map = new int[1000][1000];
	static int N;
	static int M;
	static int K;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/swea/sw/5563_모의sw_줄기세포배양.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken()); //세로 
			M = Integer.parseInt(st.nextToken()); //가로 
			K = Integer.parseInt(st.nextToken()); //시간 
			
			
			
		}
		
	}

}
