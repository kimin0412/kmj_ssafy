package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PokerGame {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/PokerGame.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int[] suit = new int[5];
			int[] lank = new int[14];
			for (int i = 0; i < 5; i++) {
				String tmp = st.nextToken();
				switch (tmp.charAt(0)) {
				case 'S':
					suit[0]++;
					break;
				case 'D' :
					suit[1]++;
					break;
				case 'H':
					suit[2]++;
					break;
				case 'C' :
					suit[3]++;
					break;
				}
//				2 = 50
				if(49<tmp.charAt(1) && tmp.charAt(1) <58) {
					lank[tmp.charAt(1)-48]++;
				}
				else if(tmp.charAt(1) == 'A'){
					lank[1]++;
				}
				else if(tmp.charAt(1) == 'T'){
					lank[2]++;
				}
				else if(tmp.charAt(1) == 'J'){
					lank[3]++;
				}
				else if(tmp.charAt(1) == 'Q'){
					lank[4]++;
				}
				else if(tmp.charAt(1) == 'K'){
					lank[0]++;
				}
			}

			System.out.println("#" + tc + " " );

		}
	}

}
