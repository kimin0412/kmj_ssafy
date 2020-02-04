package swea.d3;

import java.io.FileInputStream;
import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구2 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("res/swea/d3/1289_원재의메모리복구.txt"));
		Scanner sc= new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1;test_case<=T; test_case++) {
			String data = sc.next();
			int size = data.length(); //문자열의 길이
			StringBuilder nData=new StringBuilder(data);
			
			int cnt = 0; //카운트 함수
			//첫 bit가 1로 시작하는지 확인하는
			if(data.startsWith("1")) { //endWith(문자열) 지정문자열로 끝나면 true, 그렇지 않으면 false 
				cnt++;
			}
			//현재 index비트문자와 다음 비트를 비교할거기 때문에 size-2까지 반복해야 index에서 벗어나지않음
			for (int i = 0; i <size-1; i++) {
				if(data.charAt(i) != data.charAt(i+1)) {
					cnt++;
				}
			}
			System.out.println("#"+test_case+" "+cnt);

			
		}
	}
}	
