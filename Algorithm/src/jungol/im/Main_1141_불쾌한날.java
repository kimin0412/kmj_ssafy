package jungol.im;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Main_1141_불쾌한날 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/1141_불쾌한날.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// Integer.ParseInt(s) : 정수 포맷의 문자열을 정수로 변환시켜주는 함수
		int N = Integer.parseInt(in.readLine());
		long cnt = 0;
		Stack<Integer> st = new Stack<>();
//		stack에 현재 소를 볼 수 있는 소만 담기
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(in.readLine().trim());
//			현재 소를 볼 수 없다면 stack에서 제거한다.
			while (!st.isEmpty() && st.peek() <= cur) {
				st.pop();
			} //stack에 있는 소들은 현재 나를 볼 수 있는 소 => count 세기
			cnt+=st.size();
			st.push(cur);
		}
		System.out.println(cnt);
	}
}
