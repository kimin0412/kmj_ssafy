package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 정렬 - 우선순위
 * 중복을 제거
 * 시간이 터짐 
 * 선택 정렬 O[N^2]
 */
public class Solution_7701_염라대왕의이름정렬2 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/7701_염라대왕의이름정렬.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine().trim()); // 이름의 개수 1~20,000
			
			String[] name = new String[N];
			for (int i = 0; i < N; i++) {
				name[i] = br.readLine();
			}
			
			// 선택정렬 - 우선순위
//			0~끝 : name[0] <-> name[minIndex]
//			1~끝 : name[1] <-> name[minIndex]
			
//			끝~끝 : name[끝] <-> name[minIndex]
			for (int i = 0; i < name.length; i++) { // 범위의 시작값
				int minIndex = i;
				for (int j = i; j < name.length; j++) { // 범위 i~끝
					if((compare(name[minIndex], name[j]) >0)) { // 최소값이라면, 앞쪽에 배치해야 된다면
						minIndex = j; // 최소값 인덱스 기억 
					}
				}
				// swap name[i] <-> name[minIndex]
				String temp = name[i];
				name[i] = name[minIndex];
				name[minIndex] = temp;
				
			}
			// 중복제거
//			System.out.println(Arrays.toString(name));
			System.out.println("#" + tc);
			String temp = null;
			for (int i = 0; i < name.length; i++) {
				if(!name[i].equals(temp)){
					System.out.println(name[i]);
				}
				temp = name[i];
			}
			
		}// end of tc
		
	}// end of main
	/** 바꿔야된다면, (next 앞으로 가야한다면) 양수를 리턴 */
	private static int compare(String pre, String next) {
		if(pre.length() != next.length()) { // 글자의 길이 짧은 순서 
			return pre.length() - next.length();
		} else { // 길이가 같으면, 사전순
			return pre.compareTo(next); // 오름차순
		}
	}// end of class 
}
