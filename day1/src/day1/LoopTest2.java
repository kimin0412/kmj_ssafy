package day1;
import java.util.Scanner;

//키보드로 부터 10개의 자연수를 입력받아 합계와 평균을 구하세요.
public class LoopTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum=0;
		for (int i = 0; i < 10; i++) {
			sum+=sc.nextInt();
		}
		System.out.println("sum : "+sum+"  avg : "+sum/10.); 
		sc.close();  //서버 프로그래밍이라면 자원 반납이 안되서 다른 사람이 자원을 사용하지 못하게됨
	}
}
