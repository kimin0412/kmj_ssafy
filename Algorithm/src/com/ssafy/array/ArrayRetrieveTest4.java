package com.ssafy.array;

public class ArrayRetrieveTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] datas= {{1,2,3}
						,{4,5,6}
						,{7,8,9}};
		
		int n =datas.length;
		for (int i = 0; i < n; i++) { //지그재그 탐색
			for (int j = 0; j < n; j++) {
				System.out.print(datas[i][j+(n-1-2*j)*(i%2)]+" ");
			}
			
		}
	}
}

	
