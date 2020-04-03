package swea.d5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_현주가좋아하는제곱근놀이 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/swea/d5/현주가좋아하는제곱근놀이.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			long cnt = 0;
			while (N != 2) {
				double NN = Math.sqrt(N);
				if (N == 1) {  
		            cnt++;
		            break;
				}
				if (NN - (int) Math.sqrt(N) == 0) {
					N = (long) Math.sqrt(N);
					cnt++;
				} else {
//					System.out.println(Math.pow((int) Math.sqrt(N) + 1, 2) - N);
					cnt+=Math.pow((int) Math.sqrt(N) + 1, 2) - N;
					N = (long) Math.pow((int) Math.sqrt(N) + 1, 2);
				}
			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
