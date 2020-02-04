package com.ssafy.array;

public class ArrayRetrieveTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] datas= {{1,2,3}
						,{4,5,6}
						,{7,8,9}};
		
		int n =datas.length;
		for (int i = 0; i < n; i++) { //지그재그 탐색
			if(i%2==0) {
			for (int j = 0; j < n; j++) {
				System.out.print(datas[i][j]+" ");
			}
			}else {
				for (int j = n-1; j>-1; j--) {
					System.out.print(datas[i][j]+" ");
				}
			}
			System.out.println();
		}
		}

	}


