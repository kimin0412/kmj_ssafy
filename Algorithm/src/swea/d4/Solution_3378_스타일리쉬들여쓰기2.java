package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
해결 방법1 : 수학시간처럼 풀이한다.
문제점 예시
({abc	0
....})a	4
[ab		0
.]		1

R + C = 4
S = 1

유일한 해를 구하기위해 방정식이 부족하다
그렇다고 -1 이라고 바로 표현하는것이 아니라, 위 정보만으로도 해결할 수 있는 들여쓰기 코드가 있을수 있습니다.
예를들면
(({{abc			0
........}}))a	8
[[ab			0
..]]			2
(ab				0
???			   -1

이외에 고민해야하는 것들이 껀껀이 많다
하나씩 경우를 찾아서 대응하기엔 위험할 수 있다. Greedy

해결 방법2 :
1 <= R,C,S <= 20 정수 라는 조건을 활용 (범위가 유한하고, 적음)
가능한 모든 R,C,S 의 순열 구해보자 (동일한 값이 나오는것도 가능하므로 중복순열)
 *
 */
public class Solution_3378_스타일리쉬들여쓰기2 {
	private static int[][] m;
	private static int[][] dap;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/d4/3378_스타일리쉬들여쓰기.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= TC; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken()); // p 스타일리쉬를 마스터한 사람의 코드 줄 수 (1 ≤ p, q ≤ 10)
			int q = Integer.parseInt(st.nextToken()); // q 당신 코드의 줄 수 (1 ≤ p, q ≤ 10)
			m = new int[p][4];
			
			for (int i = 0; i < p; i++) { 
				String line = br.readLine();
				
				int index = 0;
				while(line.charAt(index) == '.') { 
					index++;
				}
				m[i][0] = index; // .의 개수 
				if (i > 0) { 
					m[i][1] = m[i-1][1];
					m[i][2] = m[i-1][2];
					m[i][3] = m[i-1][3];
				}

				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(': m[i][1]++; break;
					case ')': m[i][1]--; break;
					case '{': m[i][2]++; break;
					case '}': m[i][2]--; break;
					case '[': m[i][3]++; break;
					case ']': m[i][3]--; break;
					}
				}
			} 
			dap = new int[q][4];
			for (int i = 0; i < q; i++) {
				String line = br.readLine();
				int index = 0;
				if (i > 0) {
					dap[i][1] = dap[i-1][1];
					dap[i][2] = dap[i-1][2];
					dap[i][3] = dap[i-1][3];
				}
				for (int j = index; j < line.length(); j++) {
					switch (line.charAt(j)) {
					case '(': dap[i][1]++; break;
					case ')': dap[i][1]--; break;
					case '{': dap[i][2]++; break;
					case '}': dap[i][2]--; break;
					case '[': dap[i][3]++; break;
					case ']': dap[i][3]--; break;
					}
				}
			}
			
			for (int i = 0; i < q; i++) {
				dap[i][0] = -2; // 초기값 
			}

			for (int R = 1; R <= 20; R++) {
				for (int C = 1; C <= 20; C++) {
					for (int S = 1; S <= 20; S++) {
						if (check(R,C,S)) {
							cal(R,C,S);
						}
					}
				}
			}
			
			sb.append('#').append(testCase).append(" 0"); 
			for (int i = 1; i < dap.length; i++) {
				sb.append(' ').append(dap[i][0]);
			}
			sb.append('\n');
		} // end of for testCase
		System.out.print(sb);
	} // end of main
	public static void cal(int R, int C, int S) {
		for (int i = 1; i < dap.length; i++) {
			int x = dap[i-1][1]*R+dap[i-1][2]*C+dap[i-1][3]*S;
			if (dap[i][0] == -2) {
				dap[i][0] = x;
			} else if (dap[i][0] != x) {
				dap[i][0] = -1;
			}
		}
	}
	public static boolean check(int R, int C, int S) {
		for (int i = 1; i < m.length; i++) {
			if (m[i][0] != m[i-1][1]*R+m[i-1][2]*C+m[i-1][3]*S) { 
				return false;
			}
		}
		return true;
	}
} // end of class

/*
그래서 오늘 문제는  중복 순열 20TT3이고   20TT3으로 고정이므로 반복문으로 하면  총 반복은 8000이라서 시간내에 구할 수 있었습니다. 

for(int r = 1; r<=20; r++) { // 1<=R<=20
                for(int c = 1; c<=20; c++) {// 1<=C<=20
                    for(int s = 1; s<=20; s++) {// 1<=S<=20
                        if(isAvailable(r,c,s)) {
                            processIndent(r,c,s);
                            break;
                        }
                    }
                }
            }


완전탐색으로 풀수 없는 문제는 없다. 다만 시간이 많이 걸리므로 우리는 N의 숫자를 잘 파악하자... 
다시한번 교훈이 되는 문제였습니다.


*/



