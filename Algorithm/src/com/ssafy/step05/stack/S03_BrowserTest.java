package com.ssafy.step05.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class S03_BrowserTest {

	/**
	 * @author taehee kim
	 * Visit : 현재 페이지를 B stack에 push, F stack clear
	 * Back : 현재 페이지를 F stack에 push, B stack pop 후 현재페이지로 설정
	 * Forward : 현재 페이지를 B stack에 push, F stack pop 후 현재페이지로 설정
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		String current = "http://www.ssafy.com";
		Stack<String> bStack = new Stack<String>();
		Stack<String> fStack = new Stack<String>();
		
		while(true) {
			String input = in.readLine();
			if(input.charAt(0) == 'Q') {
				break;
			}
			
			st = new StringTokenizer(input, " ");
			switch (st.nextToken().charAt(0)) { // V  http://www.naver.com
												// B
			case 'V':// Visit : F stack clear , 현재 페이지를 B stack에 push 
				fStack.clear();
				bStack.push(current);
				current = st.nextToken(); // url
				System.out.println(current);
				break;
			case 'B': // Back : 현재 페이지를 F stack에 push, B stack pop 후 현재페이지로 설정
				if(bStack.isEmpty()) {
					System.out.println("Ignored...");
				}else {
					fStack.push(current);
					current = bStack.pop();
					System.out.println(current);
				}
				break;
			case 'F': //Forward : 현재 페이지를 B stack에 push, F stack pop 후 현재페이지로 설정
				if(fStack.isEmpty()) {
					System.out.println("Ignored...");
				}else {
					bStack.push(current);
					current = fStack.pop();
					System.out.println(current);
				}
				break;
			}			
		}
	}
}

