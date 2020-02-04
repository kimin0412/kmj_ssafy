package swea.d4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_1233_사칙연산유효성검사 {
	static int N;
	static String[] arrTree;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/1233_사칙연산유효성검사.txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean flag = true;
		for (int ii = 0; ii < 10; ii++) {
			flag = true;
			int N = Integer.parseInt(in.readLine());
			arrTree = new String[N + 1];
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				st.nextToken(); // 정점 번호
				arrTree[i] = st.nextToken(); // data 중요한거

				switch (st.countTokens()) {
				case 2:
					if (!(arrTree[i].equals("+") || arrTree[i].equals("-") || arrTree[i].equals("*")
							|| arrTree[i].equals("/"))) {
						flag = false;
						break;
					}
					break;
				case 0:
					if ((arrTree[i].equals("+") || arrTree[i].equals("-") || arrTree[i].equals("*")
							|| arrTree[i].equals("/"))) {
						flag = false;
						break;
					}
					break;
				}
			}
			if (flag == true)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
