package day2;

import java.util.Random;

public class Lotto2 {
	static int[] lo = new int[6];
	public static void main(String[] args) {
		selectLotto();
		print();
	}
	//임의의 6개 번호를 구한다.
	public static void selectLotto() {
		for (int i = 0; i < lo.length; i++) {
			lo[i] = uniqueNumber(i);
		}
	}
	//index 위치의 중복되지 않은 값 생성하여 리턴
	public static int uniqueNumber(int index) {
		Random r = new Random();  //random의 값을 갖는 r
		int temp;
		boolean dup = false;
		do {
			temp = r.nextInt(45)+1;  //임의의 값 구하기
			dup = false; //다시 초기화
			for(int j = 0; j<index; j++) {
				if(temp == lo[j]) {
					dup=true;
					break;
				}
			}
		}while(dup);
		return lo[index] = temp;
	}
	//배열 출력
	public static void print() {
		for (int su : lo) {
			System.out.print(su+ " ");
		}
	}
	
	
}
