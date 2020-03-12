package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_7701_염라대왕의이름정렬 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/7701_염라대왕의이름정렬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			LinkedList[] names = new LinkedList[50];
			for (int i = 0; i < 50; i++) {
				names[i] = new LinkedList<String>();
			}
			int N = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				String s = br.readLine().trim();
				if(!names[s.length()-1].contains(s))
					names[s.length()-1].offer(s);
			}
			for (int i = 0; i < 50; i++) {
				Collections.sort(names[i]);
			}
			System.out.println("#" + tc);
			for (int i = 0; i < 50; i++) {
				while(!names[i].isEmpty()) {
					String s = (String) names[i].poll();
					if(s != null)
						System.out.println(s);
				}
			}
		}
	}
}
