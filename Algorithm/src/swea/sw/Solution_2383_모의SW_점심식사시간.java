package swea.sw;
///////보류////////
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_2383_모의SW_점심식사시간 {
	static int N;
	static LinkedList<Character> hexa;
	static int[][] map;
	
	public static class Person{
		int r;
		int c;
		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public int getR() {
			return r;
		}
		public void setR(int r) {
			this.r = r;
		}
		public int getC() {
			return c;
		}
		public void setC(int c) {
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/swea/sw/5658_모의SW_보물상자비밀번호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			LinkedList<Person> persons = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						persons.offer(new Person(i, j));
					}
				}
			} // map 입력 끝 
			
			for (int i = 0; i < persons.size(); i++) {
				
				
			}
			
			
			
			
			
			System.out.println("#" + tc + " "  );

		}
	}

}
