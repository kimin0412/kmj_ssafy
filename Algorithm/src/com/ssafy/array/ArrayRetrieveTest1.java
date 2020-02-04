package com.ssafy.array;

public class ArrayRetrieveTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] datas= {{1,2,3}
						,{4,5,6}
						,{7,8,9}};
		
		int n =datas.length;
		for (int i = 0; i < n; i++) { //행우선탐색
			for (int j = 0; j < n; j++) {  //열반복
				System.out.print(datas[i][j]+" ");
			}
			System.out.println();
			
		}
		}

	}


