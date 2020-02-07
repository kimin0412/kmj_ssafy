package swea.d3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_D3_1234_비밀번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/1234_비밀번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			
			System.out.println(N);
			char[] arr = st.nextToken().trim().toCharArray();
			
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < N; i++) {
				stack.push(arr[i]);
			}
			System.out.println(stack);
			
//			int i = 0, j = 1;
//			while(j<N) {
////				j = i+1;
//				
//				if(arr[i] == arr[j]) {
//					arr[i] = '-';
//					arr[j] = '-';
//					i--;
//					j++;
//				}
//				else {
//					i = j;
//					j++;
//					if(arr[i] == '-')
//						i--;
//					else if(arr[j] == '-')
//						j++;
//				}
//				
//				
//			}
			
			System.out.print("#"+ tc + " ");
//			for (int ar = 0; ar < N; ar++) {
//				if(arr[ar] != '-') {
//					System.out.print(arr[ar]+" ");
//				}
//			}
//			System.out.println();
			
		}
	}
}
