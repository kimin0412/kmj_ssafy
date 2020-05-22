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
	static boolean visit[] = new boolean[26];
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
		visit['a'-97]=true;
        visit['n'-97]=true;
        visit['t'-97]=true;
        visit['i'-97]=true;
        visit['c'-97]=true;
        
//		for (int i = 0; i < N; i++) {
//			tmpList = (LinkedList) antic.clone();
//			check[i] = true;
////			System.out.println("[!! " + words[i] + " !!]");
//			dfs(words[i], 5, 0, tmpList);
//			tmpList.clear();
//			check[i] = false;
//		}
        dfs(0, 5);
		System.out.println(maxCnt);

	}
	
	private static void dfs(int start, int count) {
        // TODO Auto-generated method stub
        if(count == K) {
            int rs = 0;
            for(int i=0; i<N; i++) {
                boolean isTrue = true;
                for(int j=0; j<words[i].length(); j++) {
                    if(!visit[words[i].charAt(j)-97]) {
                        isTrue = false;
                        break;
                    }
                }
                if(isTrue) {
                    rs++;
                }
            }
            maxCnt = Math.max(maxCnt, rs);
            return;
        }
        
        for(int i=start; i<26; i++) {
            if(!visit[i]) {
                visit[i]=true;
                dfs(i, count+1);
                visit[i]=false;
            }
        }
    }

//	private static void dfs(String word, int cnt, int order, List<Character> tmpList ) {
//		int tmpCnt = cnt;
////		System.out.println(tmpCnt + " " + tmpList);
//		for (int i = 0; i < word.length(); i++) {
//			if (!tmpList.contains(word.charAt(i))) {
//				tmpList.add(word.charAt(i));
//				tmpCnt++;
//			}
//		}
//		
//		if (tmpCnt > K) {
//			maxCnt = Math.max(maxCnt, order);
//			return;
//		}
//		else {
//			order++;
//		}
//
//		for (int i = 0; i < N; i++) {
//			if (!check[i] && words[i].length()<=K ) {
//				check[i] = true;
//				dfs(words[i], tmpCnt, order, tmpList);
//				check[i] = false;
//			}
//		}
//	}
}
