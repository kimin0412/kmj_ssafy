package swea.swtest;

import java.util.Arrays;

public class Solution_4012_모의SW_요리사_combination {
	static int N,R,totalCnt;
	static int[] number; 
	static boolean[] visit;
	
	public static void main(String[] args) {
		N=4;
		R=2;
		totalCnt=0;
		number=new int[R];
		visit=new boolean[N];
		comb(0,0);
		System.out.println(totalCnt);
	}
	static void comb(int cnt, int cur) {
		if(cur>=N) return;
		if(cnt==R) {
			totalCnt++;
			System.out.println(Arrays.toString(number)+" "+
				               Arrays.toString(visit));
			return;
		}
		for(int i=cur; i<N; i++) {
			visit[i]=true;
			number[cnt]=i;
			comb(cnt+1,i+1);
			visit[i]=false;
		}
	}
}
/*
[0, 1] [true, true, false, false]
[0, 2] [true, false, true, false]
[1, 2] [false, true, true, false]
3
*/