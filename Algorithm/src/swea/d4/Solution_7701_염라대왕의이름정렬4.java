package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * 정렬 - 우선순위 
 * 중복을 제거 
 * 선택 정렬 O[N^2] 시간이 터짐 
 * API 정렬 O[NlogN] : 3,100ms, 중복을 직접 제거 
 * 중복제거를 TreeSet 자료구조 O[NlogN] : 2,900ms
 * TreeSet, 입출력 최적화 -> 500~600ms
 * 
 *  아이디어 : 글자 개수에 해당하는 배열에 글자길이가 동일한 이름들을 TreeSet으로 사전순 정렬해보자
 *  글자 개수가 작은 TreeSet부터 출력하면 됨
 *  
 *  이름 글자의 개수가 골고루 포진되어 있을 때 시간을 많이 줄일 수 있다. 
 */
public class Solution_7701_염라대왕의이름정렬4 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/7701_염라대왕의이름정렬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim()); // 이름의 개수 1~20,000

			TreeSet<String>[] tsrr = new TreeSet[51];
			for (int i = 0; i < tsrr.length; i++) {
				tsrr[i] = new TreeSet<String>(); // 배열 각 칸에 생성해서 넣기
			}
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				tsrr[str.length()].add(str);
			}
			
			sb.append('#').append(tc).append('\n');
			for (int i = 1; i < tsrr.length; i++) {
				for (String s : tsrr[i]) {
					sb.append(s).append('\n');
				}
			}
		}// end of tc
		System.out.print(sb);
	}// end of main
}
