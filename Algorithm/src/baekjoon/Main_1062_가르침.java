package baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1062_가르침 {
	static int N, K;
	static String[] words;
	static boolean[] check;
	static int maxCnt;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjoon/1062_가르침.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		if(K<5) {
			System.out.println(0);
			return;
		}
		
		words = new String[N];
		check = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			s = s.substring(4, s.indexOf("tica"));
			words[i] = s;
		}

		LinkedList<Character> antic = new LinkedList<Character>();
		LinkedList<Character> tmpList = new LinkedList<Character>();
		antic.add('a');
		antic.add('n');
		antic.add('t');
		antic.add('i');
		antic.add('c');
		maxCnt = 0;
		
		for (int i = 0; i < N; i++) {
			tmpList = (LinkedList) antic.clone();
			check[i] = true;
//			System.out.println("[!! " + words[i] + " !!]");
			dfs(words[i], 5, 0, tmpList);
			tmpList.clear();
			check[i] = false;
		}
		System.out.println(maxCnt);

	}

	private static void dfs(String word, int cnt, int order, List<Character> tmpList ) {
		int tmpCnt = cnt;
//		System.out.println(tmpCnt + " " + tmpList);
		for (int i = 0; i < word.length(); i++) {
			if (!tmpList.contains(word.charAt(i))) {
				tmpList.add(word.charAt(i));
				tmpCnt++;
			}
		}
		
		if (tmpCnt > K) {
			maxCnt = Math.max(maxCnt, order);
			return;
		}
		else {
			order++;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i] && words[i].length()<=K ) {
				check[i] = true;
				dfs(words[i], tmpCnt, order, tmpList);
				check[i] = false;
			}
		}
	}
}
