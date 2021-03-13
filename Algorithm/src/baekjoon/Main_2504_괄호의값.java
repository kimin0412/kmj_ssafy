package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504_괄호의값 {
	/*
	 * https://blog.naver.com/PostView.nhn?blogId=yongyos&logNo=221454435252
	 * 다시 풀기
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] arr = br.readLine().toCharArray();

		int ans = 0;
		int tmp = 1;
		boolean flag = true;

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				tmp *= 2;
				stack.push(arr[i]);
			} else if (arr[i] == '[') {
				tmp *= 3;
				stack.push(arr[i]);
			} else if (arr[i] == ')') {
				if (stack.isEmpty() || !(stack.peek() == '(')) {
					flag = false;
					break;
				}
				if (arr[i - 1] == '(')
					ans += tmp;
				stack.pop();
				tmp /= 2;
			} else if (arr[i]==']') {
				if (stack.isEmpty() || !(stack.peek() == '[')) {
					flag = false;
					break;
				}
				if (arr[i - 1]=='[')
					ans += tmp;
				stack.pop();
				tmp /= 3;
			}
		}
		
		if(!stack.isEmpty())
			flag = false;
		
		if(flag)
			System.out.println(ans);
	}
}