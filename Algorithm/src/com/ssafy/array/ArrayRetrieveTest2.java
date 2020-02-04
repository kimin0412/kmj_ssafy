package com.ssafy.array;

public class ArrayRetrieveTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] datas= {{1,2,3}
						,{4,5,6}
						,{7,8,9}};
		
		int n =datas.length;
		for (int i = 0; i < n; i++) { //열우선탐색
			for (int j = 0; j < n; j++) {
				System.out.print(datas[j][i]+" ");
			}
			System.out.println();
		}
		}

	}


