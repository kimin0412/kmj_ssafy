package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D3_4615_재미있는오셀로게임 {

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/swea/d3/4615_재밌는오셀로게임.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[N + 1][N + 1];
			map[N/2][N/2] = 2;
			map[N/2+1][N/2+1] = 2;
			map[N/2][N/2+1] = 1;
			map[N/2+1][N/2] = 1;
			
			int[] cnt = new int[3];
			cnt[1] = 2;
			cnt[2] = 2;			

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int dol = Integer.parseInt(st.nextToken());
				int Ddol = ((dol == 1) ? 2 : 1);
				boolean flag1 = false;
				map[r][c] = dol;
				cnt[dol]++;
				int rr = r, cc = c;
//						  			상		  하		     좌             	우		    좌상		    좌하 		      우상	    우하
				int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }, 
						{ -1, -1 }, { 1, -1 }, { -1, 1 }, { 1, 1 } };
				// 주변이 0이나 Ddol인지 검사
				
				top:
				for (int j = 0; j < 8; j++) {
					rr = r + dir[j][0];
					cc = c + dir[j][1];
					if (!(rr > 0 && rr <= N && cc > 0 && cc <= N) || map[rr][cc] == dol) {
						continue top;
					}
					
					int ar = 0;
					int ac = 0;
					while ((rr > 0 && rr <= N && cc > 0 && cc <= N) && map[rr][cc] == Ddol) {
						rr = rr + dir[j][0];
						cc = cc + dir[j][1];
						if (!(rr > 0 && rr <= N && cc > 0 && cc <= N)) {
							break;
						}
						if (map[rr][cc] == dol) {
							flag1 = true;
							ar = rr;
							ac = cc;
							break;
						}
					}
					
					rr = r + dir[j][0];
					cc = c + dir[j][1];

					while (!(rr == ar && cc == ac) && flag1 == true) {
						if (!(rr > 0 && rr <= N && cc > 0 && cc <= N))
							break;
						if(map[rr][cc] == Ddol) {
							map[rr][cc] = dol;
							cnt[dol]++;
							cnt[Ddol]--;
						}
						rr = rr + dir[j][0];
						cc = cc + dir[j][1];
					}
					flag1 = false;

				}

			}
			System.out.println("#"+(tc+1) + " " +cnt[1] + " " + cnt[2]);
		}

	}

}

//						for (int[] mm : map) {
//							System.out.println(Arrays.toString(mm));
//						}
//						System.out.println(); 