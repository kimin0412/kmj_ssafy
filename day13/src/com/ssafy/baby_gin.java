package com.ssafy;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baby_gin {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("res/baby_gin.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			int[] cnt = new int[10];
			int[] arr = new int[6];
			for (int i = 0; i < 6; i++) {
				int a = s.charAt(i)-'0';
				cnt[a]++;
				arr[i] = a;
			}
			System.out.println(Arrays.toString(cnt));
			
//			int[] front = new int[3];
//			int[] back = new int[3];
//			for (int i = 0; i < 3; i++) {
//				front[i] = arr[i];
//			}
//			for (int i = 0; i < 3; i++) {
//				back[i] = arr[i+3];
//			}
//			
//			boolean flag1 = false;
//			boolean flag2 = false;
//			
//			for (int i = 0; i < 3; i++) {
//				if(cnt[front[i]]==cnt[front[i+1]] &&  cnt[front[i+1]]==cnt[front[i+2]]) {
//					
//				}
//			}

			int result = 0; //run이나 triplet이 발견될 때마다  ++시켜줄 결과변수.
			for (int i = 0; i < 10; i++) {
				//트리플릿인지 검사
				if(cnt[i] >= 3) {
					cnt[i]-=3;
					result++;
					i--;
				}
				//run인지 검사
				else if(i<=7 && cnt[i] >= 1 && cnt[i+1] >= 1 && cnt[i+2] >= 1) {
					cnt[i]--;
					cnt[i+1]--;
					cnt[i+2]--;
					result++;
					i--;
				}
			}
			System.out.println(result==2 ? "O":"X");
		}
		
	}
}
