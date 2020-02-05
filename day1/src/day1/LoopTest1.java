package day1;
// 1~100 사이의 3의 배수의 합을 구하세요
public class LoopTest1 {

	public static void main(String[] args) {
		int sum = 0;
//		for(int i = 1; i<=100; i++) {
//			if(i%3 == 0) sum+=i;
//		}
		for (int i = 3; i <= 100; i=i+3) {
			sum = sum+i;
		}
		
		System.out.println(sum);
	}
	
}
