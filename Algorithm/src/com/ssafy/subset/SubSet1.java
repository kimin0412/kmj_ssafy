package com.ssafy.subset;

public class SubSet1 {
	static String[] datas = {"a", "b", "c", "d"};
	public static void printSubset(int[] subset) {
		int k = 0;
		 System.out.print("[");
		 for (int s : subset) {
			if(s!=0) {
				System.out.print(datas[k]+" ");
			}
			k++;
		}
		 System.out.println("]");
		
	}
	
	public static void main(String[] args) {
		int[] subset = new int[datas.length];  //반복 2^n 만큼
		for (int i = 0; i < 2; i++) {  //2^1 만큼
			subset[0] = i;
			for (int j = 0; j < 2; j++) {  //2^2 만큼
				subset[1] = j;
				for (int k = 0; k < 2; k++) {  //2^3 만큼
					subset[2] = k;
					for (int l = 0; l < 2; l++) {  //2^4 만큼
						subset[3] = l;
						printSubset(subset);
					}  //n의 개수가 늘면 for문도 계속 는다 -> 별로 좋은 코드는 아님
				}  //비트연산을 배워놓는게 좋음
			}
		}
		
		
	}

}
