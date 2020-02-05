package day2;

import java.util.Random;

public class Lotto {
	
	public static void main(String[] args) {
		int[] su = new int[6];
		Random r = new Random();  //random의 값을 갖는 r
		for (int i = 0; i < 6; i++) {
			int temp;
			boolean dup = false;
			do {
//				arr[i] = r.nextInt(45);  //0~44
				temp = r.nextInt(45)+1;  //임의의 값 구하기
				dup = false; //다시 초기화
				//중복체크
				for(int j = 0; j<i; j++) {
					if(temp == su[j]) {
						dup=true;
						break;
					}
				}
			}while(dup);
			su[i] = temp;
		}//end for
		
//@@@@@@내가 한거@@@@@@@	
//		int[] arr = new int[6];
//		for (int i = 0; i < 6; i++) {
//			arr[i] = (int) (Math.random() * 45) +1 ;
//		}
		for (int ar : su) {
			System.out.print(ar+" ");
		}
	} //end main
} //end Class
