package HW;

import java.util.Scanner;

public class Main_1592_영식이와친구들 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int allcnt = 0;
		
		int[] cnt = new int[N+1];
		cnt[1]++;
		int cur = 1;
		while(true) {
			if(cnt[cur]%2 == 1)
				cur+=L;
			else
				cur-=L;
			
			if(cur<=0)
				cur += N;
			else if (cur>N)
				cur-=N;
			
			cnt[cur]++;
			allcnt++;
			System.out.println(cur);
			if(cnt[cur] == M) {
				System.out.println(allcnt);
				break;
			}
		}
	
	}

}
